package org.apache.commons.mail;
import org.apache.commons.mail.MultiPartEmail;
import static org.junit.Assert.*;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import javax.mail.MessagingException;


public class MultiPartEmailTest {
	 MultiPartEmail testMpEmail;
	 @Before
		public void setUp() throws MessagingException {
			System.out.println("Class Name: EmailAttachementTest\n\tThis test class tests the following methods of EmailAttachment"
					+ "\n\t\t1)setName\n\t\t2)setPath\n\t\t3)setDisposition\n\t\t4)getName\n\t\t5)getDisposition\n\t\t6)getPath\n\t\t7)setURL\n\t\t8)getURL");
			testMpEmail = new MultiPartEmail();
		}
		

}
