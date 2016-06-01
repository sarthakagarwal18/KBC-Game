package kbc;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import java.io.*;
import sun.audio.*;


public class interrface extends JFrame{
	
	questions f=new questions();
	JLabel p[]=new JLabel[16];
	String[] amount = {"1,00,00,000","50,00,000","25,00,000","12,50,000","6,40,000","3,20,000","1,60,000","80,000","40,000","20,000","10,000","5,000","3,000","2,000","1,000",};
	String[] qno = {"15 ","14","13","12","11","10","9","8","7","6","5","4","3","2","1"};
	JLabel mark[] = new JLabel[16];
	String done[]=new String[400];
	int don=0;
	JLabel l[]=new JLabel[9];
	JLabel ques = new JLabel("");
	JLabel l5 = new JLabel("");
	JLabel l6 = new JLabel("");
	int variable[]=new int [4];
	int sec,flag=0,ti,bbox=0,used=0;
	Timer time;
	Timer stoptime;
	JLabel box = new JLabel();
	JLabel b[] = new JLabel[4];
	JLabel pr[] = new JLabel[4];
	//constructor
	
	
	public interrface() throws Exception {
		
		kbcframe();
		quitbutton();
		
	}
	
	
	JLabel q1 = new JLabel("");
	JLabel op[]=new JLabel[5];
	JLabel q2 = new JLabel("");
	JLabel q3 = new JLabel("");
	JLabel o1 = new JLabel("");
	JLabel o2 = new JLabel("");
	JLabel o3 = new JLabel("");
	JLabel o4 = new JLabel("");
	int safeposition=0,n_question=0,z,r;
	int x,level=1,n=15,x_check[]=new int[15];
	
	void settext() throws Exception
	{
		used=0;
		if(bbox==1){
			box.setVisible(false);
			for(int i=0;i<4;i++){
				b[i].setVisible(false);
				pr[i].setVisible(false);
			}
		}
			
		while(true){
			flag=0;
			Random ran = new Random();
			int x = ran.nextInt(15);
			if(x_check[x]!=1){
			x_check[x]=1;
			n=7*x+1;
			n_question++;
			if(n_question==6){
				level++;
				safeposition++;
				n_question=0;
				for(int j=0;j<15;j++)
					x_check[j]=0;
	
				continue;
				}
			if(level==4 && n_question==1){
				dispose();
				Ending ob1;
				ob1 = new Ending();
				ob1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ob1.setResizable(false);
				ob1.setSize(1000,720);
				ob1.win(safeposition,1,amount);
				ob1.setVisible(true);
			}

				break;
			}
		}
		z=15-(level-1)*5-n_question;
		if(z==14)
		{
			p[z].setBackground(Color.ORANGE);
			p[z].setForeground(Color.WHITE);
			p[z].setOpaque(true);
		}
		if(z<14 && z>=0)
		{
			mark[z+1].setVisible(true);
			p[z].setBackground(Color.ORANGE);
			p[z].setForeground(Color.WHITE);
			p[z].setOpaque(true);
			p[z+1].setBackground(Color.BLACK);
			p[z+1].setOpaque(true);
			if((z+1)%5==0)
				p[z+1].setForeground(Color.WHITE);
			else
				p[z+1].setForeground(Color.ORANGE);
		}
		done[don]=new String();
	
		String s=f.menu(n,0,level);
		for(int v=0;v<don;v++)
		{
			if(done[v].equals(s)){
			System.out.println("Repeated");
				settext();
				return;
			}
		}
		done[don++]=s;
		
		if(s.charAt(0)!='$'){
		q2.setText("");
		q3.setText("");
		q1.setText(s);
		q1.setForeground(Color.WHITE);
		q1.setFont(new Font("Arial", Font.PLAIN, 17));
		}
		else{
			q1.setText("");
			String sub1="";
			String sub2="";
			int h=s.length()-1;
			int b=0;
			for(int i=1;i<h;i++){
		       if(s.charAt(i)=='$'){
		    	   b=1;
		    	   continue;
		       }
				if(b==0)
					sub1=sub1+s.charAt(i);
				else
					sub2=sub2+s.charAt(i);
			}
			q2.setText(sub1);
			q3.setText(sub2);
			q2.setForeground(Color.WHITE);
			q2.setFont(new Font("Arial", Font.PLAIN, 17));
			q3.setForeground(Color.WHITE);
			q3.setFont(new Font("Arial", Font.PLAIN, 17));
		}
		
		o1.setText(f.menu(n,1,level));
		o1.setForeground(Color.WHITE);
		o1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		o2.setText(f.menu(n,2,level));
		o2.setForeground(Color.WHITE);
		o2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		o3.setText(f.menu(n,3,level));
		o3.setForeground(Color.WHITE);
		o3.setFont(new Font("Arial", Font.PLAIN, 15));
		
		o4.setText(f.menu(n,4,level));
		o4.setForeground(Color.WHITE);
		o4.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
	}
	
	void countdown(int i)
	{
		time = new Timer();
		sec=6;
		
		time.scheduleAtFixedRate(
				new TimerTask()
				{
					public void run()
					{
						if(sec==0){
							checker(i);
							time.cancel();
							return ;
						}
						if(sec%2!=0)
							op[i].setIcon(new ImageIcon("img_files/orangebox1.png"));
						else
							op[i].setIcon(new ImageIcon("img_files/greenbox1.png"));
						sec--;
					}
				}					
				,0,300);
		
	}
	void checker(int i)
	{
		int ans=0;
		try {
			ans = f.check(n,level);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(ans==i)
		{
			sound("CorrectAns.wav");
			stoptime = new Timer();
			ti=8;
			op[i].setIcon(new ImageIcon("img_files/greenbox1.png"));
			stoptime.schedule(
				new TimerTask()
				{
					public void run()
					{
						if(ti==0){
							op[i].setIcon(new ImageIcon("img_files/transbox1.png"));
							try {
								stoptime.cancel();
								settext();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						ti--;
					}
				}					
				,0,300);
		}
		else
		{
			sound("WrongAns.wav");
			stoptime = new Timer();
			ti=8;
			op[i].setIcon(new ImageIcon("img_files/orangebox1.png"));
			op[ans].setIcon(new ImageIcon("img_files/greenbox1.png"));
			stoptime.scheduleAtFixedRate(
				new TimerTask()
				{
					public void run()
					{
						if(ti==0)
						{
							dispose();
							Ending ob1;
							ob1 = new Ending();
							ob1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							ob1.setResizable(false);
							ob1.setSize(1000,720);
							ob1.setBackground(Color.BLACK);
							ob1.win(safeposition,1,amount);
							ob1.setVisible(true);
		
					
						} 	
						ti--;
					}
				}					
				,0,500);
		}
    	//time.
	}
	
	void kbcframe() throws Exception{	
		setTitle("Kaun Banega Crorepati");
		setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		//padav
				int siz=20;
				for(int i=0;i<=14;i++)
				{
					
					String temp=new String();
					int a=qno[i].length(),b=amount[i].length();
					for(int j=0;j<=10;j++)
					{
						temp=temp.concat(" ");
					}
					if(a==1)
						temp=temp.concat("  ");
					int spaces=22-b;
					temp=temp.concat(qno[i]);
					for(int j=1;j<=spaces;j++)
						temp=temp.concat("  ");
					temp=temp.concat(amount[i]);
					p[i]=new JLabel(temp);
					p[i].setBounds(782, 70+i*siz, 220, 20);
					
					mark[i]=new JLabel();
					mark[i].setBounds(845, 48+i*siz, 60, 64);
					mark[i].setIcon(new ImageIcon("img_files/diamond.png"));
					mark[i].setVisible(false);
					add(mark[i]);
					if(i%5 == 0)
						p[i].setForeground(Color.white);
					else 
						p[i].setForeground(Color.orange);
					add(p[i]);
				}
				
		//QUESTION 
		
		q1.setBounds(140, 394, 871, 94);
		add(q1);
		
		q2.setBounds(140, 405, 871, 47);
		add(q2);
		
		q3.setBounds(140, 394+37, 871, 47);
		add(q3);
		
		//OPTIONS
		
		o1.setBounds(100, 510, 436, 47);
		add(o1);
		
		o2.setBounds(540, 510, 436, 47);
		add(o2);
		
		o3.setBounds(100, 580, 436, 47);
		add(o3);
		
		o4.setBounds(540, 580, 436, 47);
		add(o4);
		
		settext();
		
		//KBC Logo
		JLabel logo = new JLabel("");
		logo.setBounds(270, 50, 300, 300);
		add(logo);
		logo.setIcon(new ImageIcon("img_files/logo1.png"));
		
		
		//ques bar
		ques.setBounds(60, 394, 871, 94);
		add(ques);
		ques.setIcon(new ImageIcon("img_files/box.png"));
		
		//options
		
		int x=60,y=510;

		for(int i=1;i<=4;i++)
		{
			if(i%2==0)
			{
				x=500;
			}
			else
			{
				x=60;
			}
			if(i==3)
			{
				y+=70;
			}
			op[i] = new JLabel();
			op[i].setBounds(x,y,436,47);
			add(op[i]);
			op[i].setIcon(new ImageIcon("img_files/transbox1.png"));
			mouseaction(op[i],i);
		}
		
		//lifelines panel
		
		JLabel life = new JLabel("LIFELINES");
		life.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		life.setBounds(782, 0, 220, 50);
		add(life);
		life.setHorizontalAlignment(JLabel.CENTER);
		life.setOpaque(true);
		life.setBackground(Color.BLACK);
		life.setForeground(Color.WHITE);
		life.addMouseListener(new MouseAdapter() {

		    public void mouseEntered(MouseEvent e) {
		    	if(flag!=1)
		    	{
		    		life.setForeground(Color.ORANGE);
		    		sound("beep.wav");
		    	}
		    	
		    }

		    public void mouseExited(MouseEvent e) {
		    	if(flag!=1)
		    		life.setForeground(Color.WHITE);
		    	
		    } 
		    
		    public void mouseClicked(MouseEvent e) {
		    	if(flag!=1)
		    		life.setVisible(false);
		    	
		    }     
		            
		});
		
		//lines for interface
		
		
		int x1=0,y1=532,z1=63;

		for(int i=1;i<=6;i++)
		{
			if(i%3==1)
			{
				x1=0;
				z1=63;
			}
			if(i%3==2)
			{
				x1=493;
				z1=10;
			}
			if(i%3==0)
			{
				x1=932;
				z1=63;
			}
			if(i<=3)
			{
				y1=532;
			}
			else if(i<=6)
			{
				y1=602;
			}
			else if(i<=8)
			{
				y1=602;
			}
			l[i] = new JLabel();
			l[i].setBounds(x1,y1,z1,2);
			add(l[i]);
			l[i].setOpaque(true);
			l[i].setBackground(Color.WHITE);
		}
		
		l5.setBounds(0, 440, 66, 2);
		add(l5);
		l5.setOpaque(true);
		l5.setBackground(Color.WHITE);

		l6.setBounds(926, 440, 65, 2);
		add(l6);
		l6.setOpaque(true);
		l6.setBackground(Color.WHITE);

		JLabel l9 = new JLabel("");
		l9.setBounds(780, 0, 2, 395);
		add(l9);
		l9.setOpaque(true);
		l9.setBackground(Color.WHITE);

		JLabel l10 = new JLabel("");
		l10.setBounds(780, 50, 290, 2);
		add(l10);
		l10.setOpaque(true);
		l10.setBackground(Color.WHITE);
		
		
		
		//lifelines
		JLabel lf1 = new JLabel("");
		lf1.setBounds(930, 10, 30, 30);
		add(lf1);
		lf1.setIcon(new ImageIcon("img_files/aud1.png"));
		lifeaction(lf1,3);
		
		JLabel lf2 = new JLabel("");
		lf2.setBounds(820, 10, 30, 30);
		add(lf2);
		lf2.setIcon(new ImageIcon("img_files/501.png"));
		lifeaction(lf2,1);
		
		JLabel lf3 = new JLabel("");
		lf3.setBounds(882, 10, 30, 30);
		add(lf3);
		lf3.setIcon(new ImageIcon("img_files/skip1.png"));
		lifeaction(lf3,2);
		
	}
	
	//hovering and clicking action
	
	
	void mouseaction(JLabel op,int i){
		
		op.addMouseListener(new MouseAdapter() {

		    public void mouseEntered(MouseEvent e) {
		    	
		    	if(flag!=1)
		    	{
		    		op.setIcon(new ImageIcon("img_files/orangebox1.png"));
		    		sound("beep.wav");
		    	}
		    }

		    public void mouseExited(MouseEvent e) {
		    	
		    	if(flag!=1)
		    	op.setIcon(new ImageIcon("img_files/transbox1.png"));
		    	
		    } 
		    
		    public void mouseClicked(MouseEvent e) {
		    	
		    	if(flag!=1)
		    	{
		    		sound("OptionLock.wav");
		    		countdown(i);
			    	flag=1;
		    	}
		    	
		    }     
		            
		});
		
	}
	
	int lif[]=new int[4];
	
	void lifeaction(JLabel op,int i){
		
		op.addMouseListener(new MouseAdapter() {

		    public void mouseEntered(MouseEvent e) {
		    	if(flag!=1)
		    	{
		    		if(i==1 && lif[i]!=1)
			    	{
			    		op.setIcon(new ImageIcon("img_files/50.png"));
			    	}
			    	else if(i==2 && lif[i]!=1)
			    	{
			    		op.setIcon(new ImageIcon("img_files/skip.png"));
			    	}
			    	else if(i==3 && lif[i]!=1)
			    	{
			    		op.setIcon(new ImageIcon("img_files/audorange.png"));
			    	}
			    	sound("beep.wav");
		    	}
			    	
		    }

		    public void mouseExited(MouseEvent e) {
		    	if(flag!=1)
		    	{
		    		if(i==1 && lif[i]!=1)
			    	{
			    		op.setIcon(new ImageIcon("img_files/501.png"));
			    	}
			    	else if(i==2 && lif[i]!=1)
			    	{
			    		op.setIcon(new ImageIcon("img_files/skip1.png"));
			    	}
			    	else if(i==3 && lif[i]!=1)
			    	{
			    		op.setIcon(new ImageIcon("img_files/aud1.png"));
			    	}
		    	}	
		    } 
		    
		    public void mouseClicked(MouseEvent e) {
		    	if(flag!=1)
		    	{
		    		int ko=0,j=0;
			    	int temp=0;
					try {
						temp = f.check(n,level);
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
			    	if(i==1){
			    		used=1;
			    		if(lif[i]==1)
			    			return ;
			    		lif[i]=1;
			    		op.setIcon(new ImageIcon("img_files/cross.png"));
			    		while(j<2){ko++;
							if(temp!=ko){
								j++;
								if(ko==1)o1.setText("");
								if(ko==2)o2.setText("");
								if(ko==3)o3.setText("");
								
	
						}}
			    	}
			    	
			    	if(i==2){
			    		
			    		if(lif[i]==1)
			    			return ;
			    		op.setIcon(new ImageIcon("img_files/skipcross.png"));
			    		lif[i]=1;
			    		n_question--;
			    		try {
							settext();
						} catch (Exception e1) {
							
						}
			    	}
			    	
			    	if(i==3){

			    		int tem=0;
						try {
							tem = f.check(n,level);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
			    		if(lif[i]==1)
			    			return ;
			    		op.setIcon(new ImageIcon("img_files/aud11.png"));
			    		lif[i]=1;
			    		Random ran = new Random();
			    		
							if(tem==1){
								if(used==1)
									variable[0]=60;
								else
									variable[0]=ran.nextInt(15)+40;
							}
							else{
								if(used==1)
									variable[0]=0;
								else
									variable[0]=ran.nextInt(10)+12;
							}
						
							if(tem==2){
								if(used==1)
									variable[1]=60;
								else
								variable[1]=ran.nextInt(15)+40;
							}
								
							else{
								if(used==1)
									variable[1]=0;
								else
								variable[1]=ran.nextInt(10)+12;
							}
								
							
							if(tem==3){
								if(used==1)
									variable[2]=60;
								else
								variable[2]=ran.nextInt(15)+40;
							}
								
							else{
								if(used==1)
									variable[2]=0;
								else
								variable[2]=ran.nextInt(10)+12;
							}
								
							if(variable[0]==variable[1] && variable[2]==0 && used==1)
								variable[2]=35;
							
							variable[3]=100-variable[1]-variable[0]-variable[2];
							
							
							
							int xx=610;
							for(int i=0;i<4;i++){
								b[i] = new JLabel();
								int z= 270-(int)(1.2*(double)variable[i]);
								b[i].setBounds(xx, z , 18, (int)(1.2*(double)variable[i]));
								add(b[i]);
								b[i].setBackground(Color.decode("#44a2fa"));
								b[i].setOpaque(true);
								xx+=30;
								pr[i] = new JLabel(Integer.toString(variable[i])+"%");
								pr[i].setBounds(xx-30, z-25, 25, 25);
								add(pr[i]);
								pr[i].setForeground(Color.WHITE);
								pr[i].setBackground(Color.BLACK);
								pr[i].setOpaque(true);
							}
							
							box.setBounds(583, 90, 167, 220);
							add(box);
							box.setIcon(new ImageIcon("img_files/audbox1.png"));
							box.setBackground(Color.BLACK);
							
							bbox=1;
							
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
	
	void quitbutton(){
		
		JLabel w = new JLabel();
		w.setBounds(30,30,116,32);
		add(w);
		w.setIcon(new ImageIcon("img_files/quit.png"));
		w.setBackground(Color.BLACK);
		w.setOpaque(true);
		w.addMouseListener(new MouseAdapter() {
		    
			public void mouseEntered(MouseEvent e) {
		    	if(flag!=1)
				{
		    		w.setIcon(new ImageIcon("img_files/quit1.png"));
		    		sound("beep.wav");
				}
		    }

		    public void mouseExited(MouseEvent e) {
		    	if(flag!=1)
		    		w.setIcon(new ImageIcon("img_files/quit.png"));
		    	
		    }
			
		    public void mouseClicked(MouseEvent e) {
		    	if(flag!=1)
		    	{
		    		Object[] options = {"Yes","No"};
		    		int n = JOptionPane.showOptionDialog(null,"Want to Quit and walk out with the Money?","Want to Quit?",
		    											JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		    		if(n==0){
		    			r=15-5*(level-1) -n_question;
		    			dispose();
						Ending ob = new Ending();
						ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						ob.setResizable(false);
						ob.setSize(1000,720);
						ob.setVisible(true);
						ob.win(r,2,amount);
					}
		    	}
		    }     
		});
	}

}