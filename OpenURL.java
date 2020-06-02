/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.chatbot;

/**
 *
 * @author Admin
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Dhruv
 */

 class LinkedList {
static class Node{
    int count;
    String name;
    Node next;
    
    Node(int count,String name){
        this.count=count;
        this.name=name;
        this.next=null;
    }
    
}
public static Node head=null;
public static Node tail=null;
public static int size=0;


static void get(){
Node current=head;
         Connection conn;  
  
   Statement stmt;

   ResultSet rs;
   try{        
   Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot", "root", "");

            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM `linked` WHERE 1");
   
while(rs.next()){
System.out.println(rs.getString(1));    
insert(Integer.parseInt(rs.getString(2)),rs.getString(1));
}

   }catch(Exception e){
       System.out.println("1"+e);
   }     
}

static void insert(int count,String name){
    Node newnode=new Node(count,name);
    if(head==null){
        head=newnode;
        tail=newnode;
    }
    else{
        tail.next=newnode;
        tail=newnode;
    }
    size++;
    sort();
}
    static void sort(){
        if (head==null){
            System.out.println("Not performed");
            return;
        }
        else{
            String arr_name[]=new String[size];
            int arr_number[]=new int[size];
            int i2=0;
            Node current=head;
            while(current!=null){
                arr_name[i2]=current.name;
                arr_number[i2]=current.count;
                i2++;
                current=current.next;
            }
            for (int i = 0; i < size; i++) {
                for (int j = i+1; j < size; j++) {
                    if(arr_number[i]<arr_number[j]){
                        System.out.println("Yes");
                        String temp=arr_name[i];
                        arr_name[i]=arr_name[j];
                        arr_name[j]=temp;
                        
                        int temp2=arr_number[i];
                        arr_number[i]=arr_number[j];
                        arr_number[j]=temp2;
                    }
                }
            }
            
            
            Node current2=head;
            int m=0;
            while(current2!=null){
                current2.name=arr_name[m];
                current2.count=arr_number[m];
                m++;
                current2=current2.next;
            }
        }
    }
    static void display(){
        Node current=head;
        while(current!=null){
            System.out.println("Name : "+current.name);
            System.out.println("Number : "+current.count);
            
            System.out.println("");
                    current=current.next;
        }
    }
    static void search(String name){
        if(head==null){
            System.out.println("Not Found");
//            return 0;
        }
        else{
            boolean flag=false;
            Node current=head;
            while(current!=null){
                if(name.equals(current.name)){
                    System.out.println("Found!");
                    System.out.println("Name:"+current.name);
                    System.out.println("Number:"+current.count);
                    current.count++;
                    flag=true;
//                return current.count;
                }
                current=current.next;
            }
            if(!flag){
            System.out.println("Not found");
                insert(0, name);
            }
//        return 0;
        }
    }
    static void add(){
            Connection conn;  
  Node current=head;
   Statement stmt;

   ResultSet rs;
   try{        
   Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot", "root", "");

            stmt = conn.createStatement();
while(current!=null){
             stmt.executeUpdate("UPDATE `linked` SET `count`="+current.count+" WHERE `url`='"+current.name+"';");
current=current.next;
}
   }catch(Exception e){
       System.out.println(e);
   }
    }
   static void countinc(String name){
            Node current=head;
            while(current!=null){
                if(name.equals(current.name)){
                    System.out.println("Found!");
                    System.out.println("Name:"+current.name);
                    current.count++;
                    System.out.println("Number:"+current.count);
                    return;
                }
                current=current.next;
        }
            
            System.out.println("Not found");
    }
}
 
public class OpenURL {
    public static void main(String[] args) {
        String str;
        Scanner in = new Scanner(System.in);
        System.out.println("Human: ");
        str = in.nextLine();
        System.out.println(str);
        LinkedList l=new LinkedList();
        l.get();
        try{
            String strm = str.substring(5,str.length());
            
            URI uri = new URI("http://"+ strm + ".com");
            l.search(strm);
//            l.countinc(strm);
            java.awt.Desktop.getDesktop().browse(uri);
            System.out.println("Website Opened in your default browser.");
        l.display();
        l.add();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
  
}

/*
Open youtube
*/