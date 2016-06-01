package kbc;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import sun.audio.*;

public class about extends JFrame{

	JLabel op[]=new JLabel[5];
	JLabel p[]=new JLabel[16];
	JLabel logo,lblKbc,l1,l2,l3,l4,l5,l6;
	JTextArea text;
	//constructor
	public about() {
		
		setTitle("Kaun Banega Crorepati");
		setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		logo = new JLabel();
		logo.setBounds(410, 100, 180, 180);
		add(logo);
		logo.setIcon(new ImageIcon("img_files/logo2.png"));

		lblKbc = new JLabel("ABOUT GAME");
		lblKbc.setBounds(0, 10, 1000, 80);
		lblKbc.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		lblKbc.setHorizontalAlignment(JLabel.CENTER);
		lblKbc.setForeground(Color.WHITE);
		add(lblKbc);
		
		backbutton();

		String line = "";
		File f = new File("text_files/about.txt");
		try{
			Scanner reader = new Scanner(f);
	        while(reader.hasNextLine())
	        {
	            line += reader.nextLine()+"\n";
	            // if there is a next line, add in the new line character that was skipped
	        }
	        reader.close();
		}
		catch (IOException e)
		{
			
		}
		
		text = new JTextArea(line);
		text.setBounds(338, 350, 800, 600);
		text.setFont(new Font("Roboto", Font.PLAIN, 23));
		text.setForeground(Color.WHITE);
		text.setBackground(Color.BLACK);
		text.setEditable(false);
		add(text);
		
	}
	
	void backbutton(){
		
		JLabel w = new JLabel();
		w.setBounds(445,600,116,32);
		add(w);
		w.setIcon(new ImageIcon("img_files/back.png"));
		w.setBackground(Color.BLACK);
		w.setOpaque(true);
		w.addMouseListener(new MouseAdapter() {
		    
			public void mouseEntered(MouseEvent e) {
		    	
				w.setIcon(new ImageIcon("img_files/back1.png"));
		    	sound("beep.wav");
		    	
		    }

		    public void mouseExited(MouseEvent e) {
		    	
		    	w.setIcon(new ImageIcon("img_files/back.png"));
		    	
		    } 
			
		    public void mouseClicked(MouseEvent e) {
					
					dispose();
			    	start ob1=new start();
					ob1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ob1.setResizable(false);
					ob1.setSize(1000,720);
					ob1.setVisible(true);
		    	
		    }     
		            
		});
	}
	
	void sound(String filename){
    	try{
    		filename="sounds/"+filename;
    		FileInputStream in=new FileInputStream(new File(filename));
    		AudioStream audio=new AudioStream(in);
    		AudioPlayer.player.start(audio);
    	}
    	catch(Exception e1){
    	}
	}
	
}
	
		