package org.apache.commons.mail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.EmailAttachment;
import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.mail.MessagingException;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.junit.Rule;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

@RunWith(JUnit4.class)
public class MultiPartEmailTest {
	 MultiPartEmail testMpEmail;
	 SimpleEmail testEmail;
	 
	 @Rule
	 public TemporaryFolder testFolder = new TemporaryFolder();
	 
	 @Before
	 public void setUp() throws MessagingException {
		testMpEmail = new MultiPartEmail();
		testEmail = new SimpleEmail();
		}
	 @Test
	 public void TestattachFile() throws Exception {
		System.out.println("lgy__");
		System.out.println("Class Name: MultiPartEmailTest");
		System.out.println("This is the test for attach(File) method.");
		File createdFile = testFolder.newFile("myfile.txt");
		testMpEmail.attach(createdFile);
			
	 }
	 @Test
	 public void testsetsubType() throws Exception {
		
		System.out.println("This is the test for setSubType() method.");
		testMpEmail.setSubType("hello");
		assertEquals("hello", testMpEmail.getSubType().toString());
	 }
	 
	 @Test 
	 public void testBoolean() throws Exception {	
		 System.out.println("This is the test for setBoolHasAttachment() method.");
			testMpEmail.setBoolHasAttachments(true);
			assertEquals(true, testMpEmail.isBoolHasAttachments());
		 }
	 
	 @Test
	 public void testInitialized() throws Exception {
		 System.out.println("This is the test for setInitialized() method.");
		 testMpEmail.setInitialized(true);
		 assertEquals(true, testMpEmail.isInitialized());
		 
	 }
	 @Test
	 public void testattach() throws Exception {	
		 System.out.println("This is the test for attach(URL,string,string,string) method.");
		 URL myURL = new URL("http://example.com/");
		 testMpEmail.attach(myURL,"test1","test2","test3");
		 testMpEmail.attach(myURL,"test1","test2");
	 }
	 
	 @Test
	 public void testattachemail() throws Exception {	
		 System.out.println("This is the test for attach(EmailAttachment) method.");
		 EmailAttachment testAttachment = new EmailAttachment();
		 	testAttachment.setName("photo.jpg");
		 	testAttachment.setDescription("This is a test attachment");
		 	URL myURL = new URL("http://example.com/");
			testAttachment.setURL(myURL);	
			testAttachment.setDisposition("Test");	
			testAttachment.setPath("//test//");	
			testMpEmail.attach(testAttachment);
	 }
	 
	 @Test
	 public void testattachnull() throws Exception {
		 
		 try {
			 System.out.println("This is the test for attach() method with null.");
			 EmailAttachment testAttachment = null;
			 testMpEmail.attach(testAttachment);
			 fail("EmailException was expected to occur");
		 }catch (EmailException e) {
		 	 assertEquals("Invalid attachment supplied",e.getMessage());
		 }
	 }
	 
	 @Test
	 public void testBuildMimeMessage() {
		 System.out.println("This is the test for buildMimeMessage() method with null.");
		 try {
			testMpEmail.buildMimeMessage();
		} catch (EmailException e) {
			assertEquals("Cannot find valid hostname for mail session", e.getMessage());
		}
	 } 
	 
	 @Test
	 public void testBuildMimeMessageValid() throws Exception {
		    System.out.println("This is the test for BuildMimeMessage() method with valid inputs.");
			testEmail.setHostName("testhostname");
			testEmail.setFrom("a@b.com");
			testEmail.addTo("c@b.com");
			testEmail.addCc("d@b.com");
			testEmail.addBcc("e@b.com");
			testEmail.addReplyTo("f@b.com");
			testEmail.addHeader("type", "important");
			testEmail.setSubject("testsubject");
			testMpEmail.setMsg("hello");
			
			URL myURL = new URL("http://example.com/");
			testMpEmail.attach(myURL,"test1","test2","test3");
			testMpEmail.addPart("test","test");
			MimeMultipart mimeMultipart = new MimeMultipart();
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setText("Test body message");
			mimeMultipart.addBodyPart(bodyPart, 0);
			testEmail.setContent(mimeMultipart);
			
			testEmail.buildMimeMessage();
			MimeMessage message = testEmail.getMimeMessage();
			
			Address[] senders = message.getFrom();
			assertEquals(senders.length, 1);
			assertEquals(senders[0].toString(), "a@b.com");

			Address[] recipients = message.getAllRecipients();
			assertEquals(recipients.length, 3);

			Address[] toRecipient = message.getRecipients(Message.RecipientType.TO);
			assertEquals(toRecipient.length, 1);
			assertEquals(toRecipient[0].toString(), "c@b.com");

			Address[] ccRecipient = message.getRecipients(Message.RecipientType.CC);
			assertEquals(ccRecipient.length, 1);
			assertEquals(ccRecipient[0].toString(), "d@b.com");

			Address[] bccRecipient = message.getRecipients(Message.RecipientType.BCC);
			assertEquals(bccRecipient.length, 1);
			assertEquals(bccRecipient[0].toString(), "e@b.com");

			Address[] replyToAddresses = message.getReplyTo();
			assertEquals(replyToAddresses.length, 1);
			assertEquals(replyToAddresses[0].toString(), "f@b.com");
			
			testMpEmail.addPart(mimeMultipart,0);
			testMpEmail.addPart(mimeMultipart);
			
			Enumeration headersEnum = message.getAllHeaders();
			HashMap<String, String> headers = new HashMap<String, String>();

			while (headersEnum.hasMoreElements()) {
				Header header = (Header) headersEnum.nextElement();
				headers.put(header.getName(), header.getValue());
			}

			assertEquals(headers.containsKey("type"), true);
			assertEquals(headers.get("type"), "important");


			mimeMultipart = (MimeMultipart) message.getContent();
			bodyPart = mimeMultipart.getBodyPart(0);
			String bodyText = bodyPart.getContent().toString();
			assertEquals(bodyText, "Test body message");
		}

	 
	 
}
