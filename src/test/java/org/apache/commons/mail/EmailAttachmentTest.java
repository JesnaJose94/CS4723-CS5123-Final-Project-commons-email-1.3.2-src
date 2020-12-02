package org.apache.commons.mail;
import org.apache.commons.mail.EmailAttachment;
import static org.junit.Assert.*;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import javax.mail.MessagingException;


public class EmailAttachmentTest { 
	EmailAttachment testAttachment;
	
	@Before
	public void setUp() throws MessagingException {
		testAttachment = new EmailAttachment();
	}
	@Test
	public void testgetPath() throws Exception {
		System.out.println("lgy__");
		System.out.println("Class Name: EmailAttachmentTest");
		System.out.println("This is the test for setPath() method.");
		testAttachment.setPath("//test//");	
		assertEquals("//test//",testAttachment.getPath());
	}
	@Test
	public void testgetname() throws Exception {
		System.out.println("This is the test for setName() method.");
		testAttachment.setName("photo.jpg");	
		assertEquals("photo.jpg", testAttachment.getName());
	}
	@Test
	public void testgetDescription() throws Exception {
		System.out.println("This is the test for setDescription() method.");
		testAttachment.setDescription("This is a test attachment");
		assertEquals("This is a test attachment", testAttachment.getDescription());
	}
	@Test
	public void testgeturl() throws Exception {	
		System.out.println("This is the test for setURL() method.");
		URL myURL = new URL("http://example.com/");
		testAttachment.setURL(myURL);	
		assertEquals(myURL, testAttachment.getURL());
	}
	@Test
	public void testgetDisposition() throws Exception {	
		System.out.println("This is the test for setDisposition() method.");
		testAttachment.setDisposition("Test");	
		assertEquals("Test", testAttachment.getDisposition());
	}
	
	
	
}
