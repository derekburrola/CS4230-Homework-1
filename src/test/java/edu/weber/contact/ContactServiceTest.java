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
	}
	
	
	@Test
	public void testGetContactExisting() {
		ContactService cs = new ContactService();
		
		Assert.assertEquals(cs.getContacts().size(), 2);	
	}
	
	@Test
	public void testAddContact() {
		
		ContactService cs = new ContactService();
		int count = cs.getContacts().size();
		Contact c = new Contact("person", "one");
		
		cs.addContact(c);
		
		Assert.assertEquals(cs.getContacts().size(), count+1);
	}
}
