package edu.weber.servlet;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.protobuf.Any;

import edu.weber.model.Address;
import edu.weber.model.Contact;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Assert;
//import org.mockito.Captor;
//import org.mockito.Spy;


@RunWith(MockitoJUnitRunner.class)
public class MyServletTest {

	@Mock
	RequestDispatcher requestDispatcher;

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	MyServlet testObj;

	@Before
	public void setup() {
		testObj = new MyServlet();
	} 
 
	@Test
	public void doGetHasRequestAttributeContacts() throws ServletException, IOException {
		ArgumentCaptor<Collection> servletRequestCapture = ArgumentCaptor.forClass(Collection.class);

		when(request.getRequestDispatcher(ArgumentMatchers.any(String.class))).thenReturn(requestDispatcher);
		when(request.getParameter("err")).thenReturn("");
		testObj.doGet(request, response);


		verify(request).setAttribute(ArgumentMatchers.any(String.class), servletRequestCapture.capture());

		Assert.assertNotNull(servletRequestCapture.getValue());

	}

	@Test
	public void doGetHasRequestAttributeContactsHasDefault() throws ServletException, IOException {
		ArgumentCaptor<Set<Contact>> servletRequestCapture = ArgumentCaptor.forClass(Set.class);

		when(request.getRequestDispatcher(ArgumentMatchers.any(String.class))).thenReturn(requestDispatcher);
		//when(request.getParameter("err")).thenReturn("");
		testObj.doGet(request, response);

		verify(request).setAttribute(ArgumentMatchers.any(String.class), servletRequestCapture.capture());

		Set contactsCollection = servletRequestCapture.getValue();
		Assert.assertTrue(contactsCollection.size() > 0);

	}	 


	@Test 
	public void doSetHasRequestAttributeContacts() throws ServletException, IOException {
		ArgumentCaptor<Set<Contact>> servletRequestCapture = ArgumentCaptor.forClass(Set.class);

		when(request.getRequestDispatcher(ArgumentMatchers.any(String.class))).thenReturn(requestDispatcher);
		when(testObj.areInputsValid((ArrayList<String>) ArgumentMatchers.any())).thenReturn(true);
		testObj.doPost(request, response);

		verify(request).setAttribute(ArgumentMatchers.any(String.class), servletRequestCapture.capture());

		Assert.assertNotNull(servletRequestCapture.getValue());
	}


	@Test
	public void testPost() throws ServletException, IOException{
		ArgumentCaptor<String> servletRequestCapture = ArgumentCaptor.forClass(String.class);

		when(request.getRequestDispatcher(ArgumentMatchers.any(String.class))).thenReturn(requestDispatcher);

		when(request.getParameter(ArgumentMatchers.any(String.class))).thenReturn("aaa");
		testObj.doPost(request, response);

		verify(request, times(9)).getParameterValues(servletRequestCapture.capture());

		Assert.assertNotNull(servletRequestCapture.getValue());
	}



	@Test
	public void doAreInputsValidFalse() {

		MyServlet ms = new MyServlet();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("");

		Assert.assertFalse(ms.areInputsValid(arr));

	}

	@Test
	public void doAreInputsValidTrue() {

		MyServlet ms = new MyServlet();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Testing in progress");

		Assert.assertTrue(ms.areInputsValid(arr));

	}

	@Test 
	public void doMakeAddressFromCityWorks() {

		MyServlet ms = new MyServlet();


		Map<String, String> addrSet = new HashMap<String, String>();
		String add1 = "13 East New York";
		String add2 = "";
		String city = "London";
		String state = "Michigan";
		String zip = "1234";
		String type = "Home";

		addrSet.put("inputAddress", add1);
		addrSet.put("inputAddress2", add2);
		addrSet.put("inputCity", city);
		addrSet.put("inputState", state);
		addrSet.put("inputZip", zip);
		addrSet.put("inpuAddressType", type);

		Address addr = ms.makeAddressFrom(addrSet);

		Assert.assertTrue(addr.getCity() == "London");
	}









}
