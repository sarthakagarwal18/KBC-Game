package kbc;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import sun.audio.*;

public class Ending extends JFrame{
	
	void win(int n,int i, String amount[])
	{
		setTitle("Kaun Banega Crorepati");
		setLayout(null);
		getContentPane().setBackground(Color.black);
		
		JLabel ty,tx,w,amt;
		
		ty = new JLabel("Thank  You for Playing!");
		ty.setBounds(0, 60, 1000, 80);
		ty.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		ty.setHorizontalAlignment(JLabel.CENTER);
		ty.setForeground(Color.ORANGE);
		add(ty);
		
		tx = new JLabel("You Have Won");
		tx.setBounds(0, 170, 1000, 80);
		tx.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		tx.setHorizontalAlignment(JLabel.CENTER);
		tx.setForeground(Color.WHITE);
		add(tx);
		
		sound("Thanks.wav");
		button();
		
		String s=new String();
		
		// SHOW WINNING AMOUNT
		if(i==1){
			
			if(n==0){
				s="Rs. 0";
			}
			else if(n==1){
				s ="Rs. 10,000";
			}
			else if(n==2){
				s="Rs. 3,20,000";
			}
			else if(n==3){
				s="Rs. 1 Crore";
			}
			
		}
		
		if(i==2){
			if(n==14)
				s="Rs. 0";
			else{
				s="Rs. "+ amount[n+1];
			}
		}
		
		amt = new JLabel(s);
		amt.setBounds(150, 285, 700, 130);
		add(amt);
		amt.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 65));
		amt.setHorizontalAlignment(JLabel.CENTER);
		amt.setForeground(Color.ORANGE);
		amt.setBackground(Color.BLACK);
		amt.setText(s);
		amt.setOpaque(true);	
		
		w = new JLabel();
		w.setBounds(0,270,1000,156);
		add(w);
		w.setIcon(new ImageIcon("img_files/winscreen.jpg"));
		w.setOpaque(true);

	}

	void button(){
		
		JLabel w = new JLabel();
		w.setBounds(524,500,116,32);
		add(w);
		w.setIcon(new ImageIcon("img_files/back.png"));
		w.setBackground(Color.BLACK);
		w.setOpaque(true);
		mouseaction(w,1);
		
		JLabel s = new JLabel();
		s.setBounds(360,500,116,32);
		add(s);
		s.setIcon(new ImageIcon("img_files/new.png"));
		s.setBackground(Color.BLACK);
		s.setOpaque(true);
		mouseaction(s,2);
		
	}
	
	void mouseaction(JLabel w,int i){
		
		w.addMouseListener(new MouseAdapter() {
		    
			public void mouseEntered(MouseEvent e) {
		    	
				if(i==1){
					w.setIcon(new ImageIcon("img_files/back1.png"));
				}
				else{
					w.setIcon(new ImageIcon("img_files/new1.png"));
				}
		    	sound("beep.wav");
		    	
		    }
	
		    public void mouseExited(MouseEvent e) {
		    	
		    	if(i==1){
					w.setIcon(new ImageIcon("img_files/back.png"));
				}
				else{
					w.setIcon(new ImageIcon("img_files/new.png"));
				}
		    	
		    } 
			
		    public void mouseClicked(MouseEvent e) {
					
					dispose();
					if(i==1){
						start ob1=new start();
						ob1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						ob1.setResizable(false);
						ob1.setSize(1000,720);
						ob1.setVisible(true);
					}
					else{
						interrface ob1;
						try {
							ob1 = new interrface();
							ob1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							ob1.setResizable(false);
							ob1.setSize(1000,720);
							ob1.setVisible(true);
						} catch (Exception e1) {
						}
	
					}
		    	
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






