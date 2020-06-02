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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class prac {
    
    static Timer timer;
 
    public prac(Date time) {
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
        String number=null;
        int day=0;
        int month=0;
        int year=0;
        int hour=0;
        int minute=0;
        int second=0;
        int done;
     
                    try{ 
           Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot", "root", "");

            stmt = conn.createStatement();


            rs = stmt.executeQuery("select * from reminder where Done_flag=0 Order by Day,Month,Year,hour,minute,second ");
          int count=0;
//                        System.out.println("Hereeeee"+rs.next());
            if(rs.next()){
                day=Integer.parseInt(rs.getString(1));
                month=Integer.parseInt(rs.getString(2));
                year=Integer.parseInt(rs.getString(3));
                hour=Integer.parseInt(rs.getString(4));
                minute=Integer.parseInt(rs.getString(5));
                second=Integer.parseInt(rs.getString(6));
                    
                    email=rs.getString(7);
                    number=rs.getString(8);
                    message=rs.getString(9);
                    done=Integer.parseInt(rs.getString(10));
        System.out.println(day);
        System.out.println(month);
            System.out.println(year);
        System.out.println(hour);
            System.out.println(minute);
        System.out.println(second);
            System.out.println(email);
        System.out.println(number);
            System.out.println(message);
        System.out.println(done);
            

            }
            
                     
                            
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
//         stmt.execute("UPDATE `reminder` SET `Done_flag`=1 WHERE  `Day`="+day+","
//                 + "`Month`="+month+",`Year`="+year+",`Hour`="+hour+","
//                 + "`Minute`="+minute+",`Second`="+second+",`email`='"+email+"',"
//                 + "`Phone number`='"+number+"',`message`='"+message+"'");
         /*
   try {
			
			// Construct data
			String apiKey = "apikey=" + "bajBXwxWkLA-4wdlGmGivQC1FtGfoxEHHEuCHuf7N0";
			String messages = "&message=" + message;
			String sender = "&sender=" + "CHATBOT";
			String numbers = "&numbers=" + "91"+number;
			
			// Send data
			HttpURLConnection conn2 = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + messages + sender;
			conn2.setDoOutput(true);
			conn2.setRequestMethod("POST");
			conn2.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn2.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
//			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
//			return "Error "+e;
		}
                     */  
                        
          stmt.execute("UPDATE `reminder` SET `Done_flag`=1 WHERE"
                  +" `message`='"+message+"'");
                        
        
//  }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
        
        }
        catch(Exception e){
            System.out.println(e);
    }
   }

    public static void main(String[] args) {
                    
//        System.out.println("Task scheduled");
         Connection conn;  
  
   Statement stmt;

   ResultSet rs;
        String email=null;
        String message=null;
        String number=null;
        int day=0;
        int month=0;
        int year=0;
        int hour=0;
        int minute=0;
        int second=0;
        int done;
     
                    try{ 
           Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot", "root", "");

            stmt = conn.createStatement();


            rs = stmt.executeQuery("select * from reminder where Done_flag=0 Order by Day,Month,Year,hour,minute,second ");
          int count=0;
            if(rs.next()){
                day=Integer.parseInt(rs.getString(1));
                month=Integer.parseInt(rs.getString(2));
                year=Integer.parseInt(rs.getString(3));
                hour=Integer.parseInt(rs.getString(4));
                minute=Integer.parseInt(rs.getString(5));
                second=Integer.parseInt(rs.getString(6));
                    
                    email=rs.getString(7);
                    number=rs.getString(8);
                    message=rs.getString(9);
                    done=Integer.parseInt(rs.getString(10));
//                day=
//        System.out.println(day);
//        System.out.println(month);
//            System.out.println(year);
//        System.out.println(hour);
//            System.out.println(minute);
//        System.out.println(second);
//            System.out.println(email);
//        System.out.println(number);
//
//            System.out.println(message);
//        System.out.println(done);
            
   
        Calendar calendar = Calendar.getInstance();
        
      conn.close();
calendar.set(Calendar.HOUR_OF_DAY, hour);
calendar.set(Calendar.MINUTE, minute);
calendar.set(Calendar.SECOND, second);
Date time = calendar.getTime();
new prac(time);
                System.out.println(time);
System.out.println("Task scheduled.");
    
            }
            
            
                    }
            catch(Exception e){
                System.out.println(e);
            }
            
    }
}
