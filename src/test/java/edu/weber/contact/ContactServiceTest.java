package edu.weber.contact;

import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import edu.weber.model.Contact;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {
	
	ContactService obj;
	
	@Before
	public void setup() {
		obj = ContactService.getInstance(); 
	}
	
	
	@Test
	public void testGetContactExisting() {
		//ContactService cs = new ContactService();
		obj.resetSet();
		Assert.assertEquals(2, obj.getContacts().size());	
	}
	
	
	@Test
	public void testAddContact() {
		
		//ContactService cs = new ContactService();
		int count = obj.getContacts().size();
		Contact c = new Contact("person", "one");
		
		obj.addContact(c);
		
		Assert.assertEquals(obj.getContacts().size(), count+1);
	}
}
