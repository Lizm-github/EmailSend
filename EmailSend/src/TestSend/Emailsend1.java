package TestSend;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Emailsend1 {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.smtp.quth", "true");
		props.setProperty("mail.transport.protocol","smtp");
		props.put("mail.smtp.host", "smtp.qq.com");
		
		Session session = Session.getInstance(props);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setSubject("李子明测试SendEmail");
		msg.setText("测试内容");
		msg.setFrom(new InternetAddress("2010007117@qq.com"));//发件人
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("1304464432@qq.com"));//收件人邮箱1304464432
		msg.saveChanges();
		Transport transport = session.getTransport();
		transport.connect("2010007117@qq.com", "zhwqpzmlfiixdbed");//发件人邮箱  授权码
		transport.sendMessage(msg, msg.getAllRecipients());
        
        System.out.println("邮件发送成功...");
        transport.close();
	}
}
