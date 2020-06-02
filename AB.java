/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.chatbot;

/**
 *
 * @author Admin
 */
import java.io.File;
import java.util.Scanner;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.utils.IOUtils;

public class AB {
   
    public static void main(String[] args) {
String botname="mybot"; 
Bot bot = new Bot(botname);
Chat chatSession = new Chat(bot);

String request = "WHAT IS NAME" ;
        String response = chatSession.multisentenceRespond(request); 
        System.out.println(response);
        System.out.println();
    }
}