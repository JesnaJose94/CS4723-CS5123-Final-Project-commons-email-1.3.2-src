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
	public void testgetname() throws Exception {
		testAttachment.setName("photo.jpg");	
		assertEquals("photo.jpg", testAttachment.getName());
	}
	@Test
	public void testgetDescription() throws Exception {
		testAttachment.setDescription("This is a test attachment");
		assertEquals("This is a test attachment", testAttachment.getDescription());
	}
	@Test
	public void testgeturl() throws Exception {	
		URL myURL = new URL("http://example.com/");
		testAttachment.setURL(myURL);	
		assertEquals(myURL, testAttachment.getURL());
	}
	@Test
	public void testgetDisposition() throws Exception {	
		testAttachment.setDisposition("Test");	
		assertEquals("Test", testAttachment.getDisposition());
	}
	
	@Test
	public void testgetPath() throws Exception {
		testAttachment.setPath("//test//");	
		assertEquals("//test//",testAttachment.getPath());
	}
	
}
