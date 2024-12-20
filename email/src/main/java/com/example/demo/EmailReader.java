package com.example.demo;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
public class EmailReader{  
  
 public static void receiveEmail(String pop3Host, String storeType,  
  final String user, final String password) {  
  try {  
   //1) get the session object  
   Properties properties = new Properties();  
   properties.put("mail.store.protocol", "imaps");  
   //Session emailSession = Session.getDefaultInstance(properties);  
    Session emailSession = Session.getDefaultInstance(properties,
   new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
     return new PasswordAuthentication(user,password);
    }
   });
    System.out.println("Mail Server Started");
   //2) create the POP3 store object and connect with the pop server  
   Store emailStore = emailSession.getStore("imaps");
 emailStore.connect("imap.gmail.com","sandykumar132000@gmail.com", password);
    
  
   //3) create the folder object and open it  
   Folder emailFolder = emailStore.getFolder("INBOX");  
   emailFolder.open(Folder.READ_ONLY);  
  
   //4) retrieve the messages from the folder in an array and print it  
//   Message[] messages = emailFolder.getMessages();  
//   for (int i = 0; i < messages.length; i++) {  
//
//    Message message = messages[i]; 
//    System.out.println("---------------------------------");  
//    System.out.println("Email Number " + (i + 1));  
//    System.out.println("Subject: " + message.getSubject());  
//    System.out.println("From: " + message.getFrom()[0]);  
//    System.out.println("Date: " + message.getReceivedDate());
//    }
   Message[] messages = emailFolder.getMessages();  
   for (int i = 0; i < messages.length; i++) {  
       Message message = messages[i]; 
       Address[] from = message.getFrom();
//       System.out.println("Email Number " + (i + 1));  
//       System.out.println(from[0]);

       if (from != null && from.length > 0 && from[0].toString().equals("Rajeswari V <thamizhraji@gmail.com>")) {
           System.out.println("---------------------------------");  
           System.out.println("Email Number " + (i + 1));  
           System.out.println("Subject: " + message.getSubject());  
           System.out.println("From: " + message.getFrom()[0]);  
           System.out.println("Date: " + message.getReceivedDate());
       }
   }
   
   //5) close the store and folder objects  
   emailFolder.close(false);  
   emailStore.close();  
  
  } catch (NoSuchProviderException e) {e.printStackTrace();}   
  catch (MessagingException e) {e.printStackTrace();}  
//  catch (IOException e) {e.printStackTrace();
//  }  
 }  
  
 public static void main(String[] args) {  
  
  String host = "smtp.gmail.com";//change accordingly  
  String mailStoreType = "pop3";  
  final String username= "sandykumar132000@gmail.com";  
  final String password= "pgdp ssqm eqjj nytc";//change accordingly  
  
  receiveEmail(host, mailStoreType, username, password);  
  
 }  
}  