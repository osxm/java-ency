/**  
* @Title: MailDemo.java
* @Package com.osxm.je.topic.mail
* @Description: TODO
* @author XM
* @date 2021年12月1日 上午6:42:22
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.je.topic.mail;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MailDemo.send();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void mail163() throws Exception {
		String smtpHost = "smtp.163.com";
		String fromAddress = "xuemingchen83@163.com";
		String password = "xxxxx";
		String toAddress = "xuemingchen83@163.com";
		
		
		 //1. 连接邮件服务器的参数配置
        Properties properties=new Properties();
        properties.setProperty("mail.transport.protocol", "smtp"); //协议
        properties.setProperty("mail.host", smtpHost);
        properties.setProperty("mail.smtp.auth", "true");//需要请求认证
        
        //2. 根据参数创建会话， 会话用于和邮件服务器交互，需要输入用户名和密码
        Session session=Session.getDefaultInstance(properties,new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(fromAddress, password);
            }
        });   
        
        //3. 创建一封邮件
        MimeMessage message= new MimeMessage(session);
        message.setFrom(new InternetAddress(fromAddress));//发件人
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(toAddress)); //收件人
        message.setSubject("邮件主题");
        message.setContent("邮件内容","text/html;charset=utf-8");
        
        //4.使用传输对象发送信件
        Transport.send(message);
	}
	
	public static void send() throws Exception {
		String smtpHost = "smtp.163.com";
		String fromAddress = "xuemingchen83@163.com";
		String password = "chen1983sun1985";
		String toAddress = "xuemingchen83@163.com";
		
		
		 //1. 连接邮件服务器的参数配置
        Properties properties=new Properties();
        properties.setProperty("mail.transport.protocol", "smtp"); //协议
        //properties.setProperty("mail.smtp.host", smtpHost); //服务器地址
        properties.setProperty("mail.smtp.auth", "true");//需要请求认证
        properties.setProperty("mail.host", smtpHost);
        
        /*MailSSLSocketFactory sf =  new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);*/
        
        //2. 根据参数创建会话， 会话用于和邮件服务器交互
        //Session session=Session.getDefaultInstance(properties);
        Session session=Session.getDefaultInstance(properties,new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(fromAddress, password);
            }
          });
        
        session.setDebug(true);
        
        //3. 创建一封邮件
        MimeMessage message= new MimeMessage(session);
        message.setFrom(new InternetAddress(fromAddress));//发件人
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(toAddress)); //收件人
        message.setSubject("邮件主题");
        message.setContent("邮件内容","text/html;charset=utf-8");
        
        //4.根据会话创建传输对象
        Transport.send(message);
        /*Transport transport = session.getTransport();
        transport.connect();
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();*/
	}

}
