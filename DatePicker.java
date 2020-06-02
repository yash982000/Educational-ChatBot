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
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class DatePicker {
    static String text2;
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog d;
	JButton[] button = new JButton[49];

	public DatePicker(JFrame parent) {
		d = new JDialog();
		d.setModal(true);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));

		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						d.dispose();
					}
				});
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JButton previous = new JButton("<< Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month--;
				displayDate();
			}
		});
		p2.add(previous);
		p2.add(l);
		JButton next = new JButton("Next >>");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month++;
				displayDate();
			}
		});
		p2.add(next);
		d.add(p1, BorderLayout.CENTER);
		d.add(p2, BorderLayout.SOUTH);
		d.pack();
		d.setLocationRelativeTo(parent);
		displayDate();
		d.setVisible(true);
	}

	public void displayDate() {
		for (int x = 7; x < button.length; x++)
			button[x].setText("");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
			button[x].setText("" + day);
		l.setText(sdf.format(cal.getTime()));
		d.setTitle("Date Picker");
	}

	public String setPickedDate() {
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"dd-MM-yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}
}

class Picker {
    
   public static String temp;
	public static void main(String[] args) {
		JLabel label = new JLabel("Selected Date:");
		JLabel label2 = new JLabel();
		final JTextField text = new JTextField(20);
		JButton b = new JButton("popup");
                JButton b2 = new JButton("Select Time");
		JPanel p = new JPanel();
//                p.setSize(420,220);
		p.add(label);
		p.add(text);
		p.add(b);
                p.add(b2);
                b2.setVisible(false);
                p.add(label2);
		final JFrame f = new JFrame();
		f.getContentPane().add(p);
		f.pack();
		f.setVisible(true);
                f.setSize(420, 220);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				text.setText(new DatePicker(f).setPickedDate());
//                            System.out.println(text.getText());
                            
                            String ab[]=new String[3];
                            int lo=0;
                            for(String mo:text.getText().split("-")){
                                ab[lo]=mo;
                                lo++;
                            }
                            String day_select=ab[0];
                            String month_select=ab[1];
                            String year_select=ab[2];
                            
//                            System.out.println(day_select);
//                            System.out.println(month_select);
//                            System.out.println(year_select);
                                   
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();  
    String c=formatter.format(date);
    String k[]=new String[10];
    int im=0;
    for(String a:c.split("/")){
        k[im]=a;
im++;
    }
    String sec=k[2];
    for(String a:sec.split(" ")){
        k[im]=a;
im++;
    }    
    String sec2=k[4];
    for(String a:sec2.split(":")){
        k[im]=a;
im++;
    }
        String fina[]=new String[7];
        int l=0;
        for (int j = 0; j < 9; j++) {
            if(j!=2 && j!=4){
                fina[l]=k[j];
                l++;
            }
        }
        int day_cur=Integer.parseInt(fina[0]);
        int month_cur=Integer.parseInt(fina[1]);
        int year_cur=Integer.parseInt(fina[2]);
        int hour_cur=Integer.parseInt(fina[3]);
        int min_cur=Integer.parseInt(fina[4]);
        int sec_cur=Integer.parseInt(fina[5]);
        
//        System.out.println(day_cur);
//        System.out.println(month_cur);
//        System.out.println(year_cur);
//        System.out.println(hour_cur);
//        System.out.println(min_cur);
//        System.out.println(sec_cur);
    String value=String.valueOf(year_cur)+String.valueOf(month_cur)+String.valueOf(day_cur);
    String value_whole=String.valueOf(year_cur)+String.valueOf(month_cur)+String.valueOf(day_cur)+" "+String.valueOf(hour_cur)+":"+String.valueOf(min_cur)+":"+String.valueOf(sec_cur)+":";
    SimpleDateFormat originalFormat_half = new SimpleDateFormat("yyyyMMdd");
  try {
//   SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
Date date2 = originalFormat_half.parse(value);
//        System.out.println("date2: "+date2);
        String value3=year_select+month_select+day_select;
Date date3;
           date3 = originalFormat_half.parse(value3);
            temp=text.getText();
//        System.out.println("date3: "+date3);
if(date3.compareTo(date2)>=0){
//    System.out.println("YES");
    b2.setVisible(true);
    label2.setText("");
}
else{
//    System.out.println("No");
b2.setVisible(false);
label2.setText("Please enter the date from future!");

}
  }catch(Exception e){
      System.out.println(e);
  }
                                
                         
                                
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//text.setText(new DatePicker(f).setPickedDate());
//                                this.dispose();
System.out.println("text:"+text.getText());
			                                
SelectTime s=new SelectTime(text.getText());
                                s.setVisible(true);
                        }
		});
	}
}