/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.chatbot;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class Reminder {
    static Timer timer;
 
    public Reminder(Date time) {
        timer = new Timer();
       
timer.schedule(new RemindTask(), time);
    }

    class RemindTask extends TimerTask {
        public void run() {
            Sendmail();
            System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
        }
    }
 void Sendmail(){
        Connection conn;  
  
   Statement stmt;

   ResultSet rs;
        String email=null;
        String message=null;
     
                    try{ 
                        
           Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot", "root", "");

            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from reminder where email='vidit.v@ahduni.edu.in'");
            int count=0;
            while(rs.next()){
                
                    
                    email=rs.getString(4);
                    message=rs.getString(5);
            
        System.out.println(email);
        System.out.println(message);
            
            }
           
       }catch(Exception e){
           System.out.println(e);
       }
                    
      
      try{
            
                            
                            
                            
                            
                            
                            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "systemchat000@gmail.com";//
     final String password = "ABCD@1234";
//     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});

   // -- Create a new message --
     Message msg = new MimeMessage(session);
String user="parth";
String yourpass="patel";
  // -- Set the FROM and TO fields --
     msg.setFrom(new InternetAddress("systemchat000@gmail.com"));
     msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(email,false));
     msg.setSubject("Your system chat credentials");
     msg.setText(message);
     msg.setSentDate(new Date());
     Transport.send(msg);
     System.out.println("Message sent.");
          JOptionPane.showMessageDialog(null, "E-mail sent");
//  }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
        
        }
        catch(Exception e){
            System.out.println(e);
    }
   }

    public static void main(String args[]) {
        
 
        Calendar calendar = Calendar.getInstance();
         Connection conn;  
  
   Statement stmt;

   ResultSet rs;
       int hour=0;
       int minute=0;
       int second=0;
       
     
                    try{ 
           Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot", "root", "");

            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from reminder where email='vidit.v@ahduni.edu.in'");
            int count=0;
            while(rs.next()){
                
                    
                    
        hour=Integer.parseInt(rs.getString(1));
                minute=Integer.parseInt(rs.getString(2));
                    second=Integer.parseInt(rs.getString(3));
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
            }
           
       }catch(Exception e){
           System.out.println(e);
       }
                    
      
calendar.set(Calendar.HOUR_OF_DAY, hour);
calendar.set(Calendar.MINUTE, minute);
calendar.set(Calendar.SECOND, second);
Date time = calendar.getTime();
new Reminder(time);

        System.out.println("Task scheduled.");
    }
}