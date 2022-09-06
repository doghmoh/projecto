/* Decompiler 3ms, total 1309ms, lines 61 */
package Model;

import Model.EmailVerification;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailVerification {
   public boolean sendEmail(String Id, String Role) throws NoSuchAlgorithmException, SQLException {
      String fromEmail = "doghmoh@gmail.com";
      boolean test = false;
      String toEmail = null;
      Random random = new Random();
      int number = random.nextInt(999999);
      Connection con = Database.getConnection();
      PreparedStatement ps = con.prepareStatement("select * from " + Role + " where id=?");
      ps.setString(1, Id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
         toEmail = rs.getString(4);
      }

      Properties pr = new Properties();
      pr.put("mail.smtp.host", "smtp.gmail.com");
      pr.put("mail.smtp.port", "587");
      pr.put("mail.smtp.auth", "true");
      pr.put("mail.smtp.starttls.enable", "true");
      Session session1 = Session.getInstance(pr, new Authenticator() {
			//override the getPasswordAuthentication method
    	  protected PasswordAuthentication getPasswordAuthentication() {
    	      return new PasswordAuthentication("doghmoh@gmail.com", "tkrijjpzelmpxwzr");
			}
      });
      try {
         Message message = new MimeMessage(session1);
         message.setFrom(new InternetAddress("doghmoh@gmail.com"));
         message.addRecipient(RecipientType.TO, new InternetAddress(toEmail));
         message.setSubject("Email Verification Link");
         message.setText("This is your verification code :" + number);
         PreparedStatement ps0 = con.prepareStatement("update " + Role + " set Code=? where id=?");
         message.setText("This is your verification code :" + number);
         ps0.setInt(1, number);
         ps0.setString(2, Id);
         ps0.executeUpdate();
         Transport.send(message);
         test = true;
      } catch (MessagingException var15) {
         System.out.print(var15);
      }

      return test;
   }
}