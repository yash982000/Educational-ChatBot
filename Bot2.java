/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

/**
 *
 * @author Admin
 */
import bitoflife.chatterbean.AliceBotMother;
import bitoflife.chatterbean.AliceBot;
import java.util.Scanner;
public class Bot2{ 
public static void main(String[] str)
{
try{
    Scanner sc=new Scanner(System.in);
    
    
AliceBotMother mother = new AliceBotMother();
AliceBot mybot = mother.newInstance();
String ask = "Show your face"; //Here You can ask Dynamic question.
String str2 = mybot.respond(ask);
System.out.println(str2);
}
catch(Exception ex)
{
System.err.println(ex.toString());
}
}

    Bot(String asuper, String resourcesPath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class brain {

        public brain() {
        }
    }
}