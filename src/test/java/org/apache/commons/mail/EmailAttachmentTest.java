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
		System.out.println("lgy__");
		System.out.println("Class Name: EmailAttachementTest\n\tThis test class tests the following methods of EmailAttachment"
				+ "\n\t\t1)setName\n\t\t2)setPath\n\t\t3)setDisposition\n\t\t4)getName\n\t\t5)getDisposition\n\t\t6)getPath\n\t\t7)setURL\n\t\t8)getURL");
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
