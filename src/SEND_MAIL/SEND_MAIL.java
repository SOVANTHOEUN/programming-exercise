package SEND_MAIL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SEND_MAIL {

	public static void main(String[] args) throws Exception {
		SEND_MAIL objSend = new SEND_MAIL();
		objSend.send();
	}

	public void send() throws Exception
	{
		String smtpHost = "mx.webcash.co.kr";
		System.out.println("BiztripLOG_SendMail send() : smtpHost : " + smtpHost);
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", smtpHost);
		 
		Session session = Session.getInstance(properties, null);
		System.out.println("BiztripLOG_SendMail send() : A");
		
		InternetAddress[] toAddress = new InternetAddress[1];
		MimeMessage message = new MimeMessage(session);
		
		String charSubject = "utf-8";
		String charContent = "utf-8";
		
		String fromName = "비즈플레이";
		String from		= "biztrip@bizplay.co.kr";
		String toName	= "";
		String to		= "sovanthoeun88@gmail.com";
		String subject	= "Without js";
		String content	= "<div style=\"display:none; white-space:nowrap; font:15px courier; color:#ffffff; line-height:0; width:600px !important; min-width:600px !important; max-width:600px !important;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</div>\r\n";
		System.out.println("getHtml: "+content);
		
		message.setFrom(new InternetAddress(from));
		toAddress[0] =   new InternetAddress(to, toName, charSubject);
		message.setRecipients(javax.mail.Message.RecipientType.TO, toAddress);
		System.out.println("BiztripLOG_SendMail send() : B");
		
		//내용 charSet 변환 기본은 KSC5601에서 utf-8로 
		content = encoding(content);
		
		//제목 charSet 설정 utf-8로 
		message.setSubject(subject, charSubject);
		message.setSentDate(new Date());
		BodyPart bodyContent = new MimeBodyPart();
		
		bodyContent.setContent(content, "text/html; charset="+charContent);
		System.out.println("BiztripLOG_SendMail send() : C");
		
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(bodyContent);
		System.out.println("BiztripLOG_SendMail send() : D");
		
		message.setContent(mp);
		System.out.println("BiztripLOG_SendMail send() : E");
		
		Transport.send(message); 
		System.out.println("BiztripLOG_SendMail send() : F");
	}
	
	private String encoding(String str) throws UnsupportedEncodingException, FileNotFoundException {
		return new String(str.getBytes("KSC5601"));
	}
	
	private String getHtml(){

		String fileUrl = "";
		fileUrl = "https://biztrip-dev.appplay.co.kr/huser_voucher_0001.act?BOOKING_SEQ=BTH0012020052000005";
//		fileUrl = "https://www.w3schools.com";
		
		URL url; // The URL to read
		HttpURLConnection conn; // The actual connection to the web page
		BufferedReader rd; // Used to read results from the web page
		String line; // An individual line of the web page HTML
		String result = ""; // A long string containing all the HTML
		try {
			url = new URL(fileUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			conn.disconnect();
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
