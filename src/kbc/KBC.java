package kbc;

import java.io.*;
import javax.swing.*;
import sun.audio.*;

public class KBC {

	public static void main(String[] args) {
    	try{
    		FileInputStream in=new FileInputStream(new File("sounds/KBC_Theme.wav"));
    		AudioStream audio=new AudioStream(in);
    		AudioPlayer.player.start(audio);
    	}
    	catch(Exception e1){
    	}
		start obj=new start();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setResizable(false);
		obj.setSize(1000,720);
		obj.setVisible(true);
		
	}
}
