package com.xiongantaoli.grade.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Sendmail {

    public static boolean send_email(String toEmail,String subjects,String contents,String fujian) throws IOException, AddressException, MessagingException{

        String to = toEmail;//收件方
        String subject = subjects;//邮件主题
        String content = contents;//邮件正文
        
        Properties properties = new Properties();//用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        // 指定验证为true
        properties.put("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        //设置为ssl协议
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        // 验证账号及密码，密码需要是第三方授权码
        Authenticator authenticator = new Email_Authenticator("1054844837@qq.com", "ofvurdncomhvbfii");
        javax.mail.Session sendMailSession = javax.mail.Session.getInstance(properties, authenticator);
        MimeMessage mailMessage = new MimeMessage(sendMailSession);
        //设置发送者
        mailMessage.setFrom(new InternetAddress("1054844837@qq.com"));      
        // Message.RecipientType.TO属性表示接收者的类型为TO
        //类型为TO是收件人和增加收件人，CC抄送，BCC密送
        mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        // Subject: 邮件主题
        mailMessage.setSubject(subject, "UTF-8");
        // 设置显示的发件时间
        mailMessage.setSentDate(new Date());     
        // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart mainPart = new MimeMultipart();      
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart html = new MimeBodyPart();
        html.setContent(content.trim(), "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // Content: 邮件正文（可以使用html标签）
        mailMessage.setContent(mainPart);
        Transport.send(mailMessage);
        return true;
    }
}