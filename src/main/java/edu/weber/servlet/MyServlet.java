package edu.weber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.weber.contact.ContactService;
import edu.weber.model.Address;
import edu.weber.model.Contact;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		name="MyServlet",
		urlPatterns = "/"
		)

public class MyServlet extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContactService service = new ContactService();
		req.setAttribute("err", req.getParameter("err"));
		req.setAttribute("contacts", service.getContacts());
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
		
		//lblError
	} 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fN = req.getParameter("inputfName");
		String lN = req.getParameter("inputlName");
		String add1 = req.getParameter("inputAddress");
		String add2 = req.getParameter("inputAddress2");
		String phn = req.getParameter("inputPhone");
		String city = req.getParameter("inputCity");
		String state = req.getParameter("inputState");
		String zip = req.getParameter("inputZip");
		String type = req.getParameter("inputAddressType");
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(fN);
		arr.add(lN);
		arr.add(add1);
		arr.add(phn);
		arr.add(city);
		arr.add(zip);
		
		if(areInputsValid(arr) ) {//&& inputState != "...") {

			ContactService cs = ContactService.getInstance();

			String fName = fN;
			String lName = lN;

			Set<String> phones = new HashSet<String>();
			phones.add(phn);

			Address addr[] = new Address[2];
			
			
			Map<String, String> addrSet = new HashMap<String, String>();
			
			addrSet.put("inputAddress", add1);
			addrSet.put("inputAddress2", add2);
			addrSet.put("inputCity", city);
			addrSet.put("inputState", state);
			addrSet.put("inputZip", zip);
			addrSet.put("inpuAddressType", type);
			
			addr[0] = makeAddressFrom(addrSet);


			Contact c = new Contact(fName, lName);
			c.setPhoneNumbers(phones);
 			c.setAddress(addr);
			cs.addContact(c);


			resp.sendRedirect("./");
		}
		else {
			resp.sendRedirect("./?err=All fields with * must be filled in");
		}

	}


	protected boolean areInputsValid(ArrayList<String> arr) {
		
		for(int i=0; i < arr.size(); i++) {
			String s = arr.get(i);
			 
			if(s.length() == 0 || s == "") {
				return false;
			}
		}
		return true;
	}

	protected Address makeAddressFrom(Map<String, String> addrStrings) {
		String add1 = addrStrings.get("inputAddress");
		String add2 = addrStrings.get("inputAddress2");
		String city = addrStrings.get("inputCity");
		String state = addrStrings.get("inputState");
		String zip = addrStrings.get("inputZip");
		String type = addrStrings.get("inputAddressType");

		Address addr = new Address(add1, add2, city, state, zip);
		addr.setAddressType(type);
		return addr;
	}

}
