package edu.weber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
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
		req.setAttribute("contacts", service.getContacts());
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<String> arr = new ArrayList<String>();
		arr.add(req.getParameter("inputfName"));
		arr.add(req.getParameter("inputlName"));
		arr.add(req.getParameter("inputPhone"));
		arr.add(req.getParameter("inputAddress"));
		//arr.add(req.getParameter("inputAddress2"));
		arr.add(req.getParameter("inputCity"));
		arr.add(req.getParameter("inputZip"));
		
		String inputState = req.getParameter("inputState");
		
		if(areInputsValid(arr) && inputState != "...") {

			ContactService cs = ContactService.getInstance();

			String fName = req.getParameter("inputfName");
			String lName = req.getParameter("inputlName");

			Set<String> phones = new HashSet<String>();
			phones.add(req.getParameter("inputPhone"));

			Address addr[] = new Address[2];
			addr[0] = makeAddressFrom(req);


			Contact c = new Contact(fName, lName);
			c.setPhoneNumbers(phones);
 			c.setAddress(addr);
			cs.addContact(c);

			//?? Unit test everything

			
		}
		resp.sendRedirect("./");

	}


	private boolean areInputsValid(ArrayList<String> arr) {
		
		for(int i=0; i < arr.size() -1; i++) {
			String s = arr.get(i);
			if(isBlankNull(s)) {
				// if isBlankNull the input is not valid
				return false;
			}
		}
		return true;
	}
	
	/*
	 * returns true if string is blank, empty, or null
	 * returns false otherwise
	 * */
	private boolean isBlankNull(String s) {
		
		if(s.length() > 0) {
			return false;
		}
		
		if(s.isBlank() || s.isEmpty() || s == null){
			return true;
		}else {
			return false;
		}
	}

	private Address makeAddressFrom(HttpServletRequest req) {
		String add1 = req.getParameter("inputAddress");
		String add2 = req.getParameter("inputAddress2");
		String city = req.getParameter("inputCity");
		String state = req.getParameter("inputState");
		String zip = req.getParameter("inputZip");
		String type = req.getParameter("inputAddressType");

		Address addr = new Address(add1, add2, city, state, zip);
		addr.setAddressType(type);
		return addr;
	}

	private void print(Object o) {
		System.out.println(o.toString());
	}

}
