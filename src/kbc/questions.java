package kbc;

import java.io.*;
//import java.util.Scanner; 

public class questions {
	
	public String menu1(int n,int p,int level)throws Exception{  
		
		 FileReader fr;
		if(level==1){
			 fr=new FileReader("text_files/easy.txt"); 
		}
		else if(level==2){
			 fr=new FileReader("text_files/medium.txt"); 
		}
		else{
			 fr=new FileReader("text_files/hard.txt"); 
		}
	  int i;  
	  int line=p+n;
	  int k=1;
	  int t=0;
	  String s= new String();
	  while((i=fr.read())!=-1)  
	  {
		  if(k==line)break;
		  if(i=='\n')k++;
	  }
	 
	  while((i=fr.read())!=-1)  
	  {
		  if(i=='\n')t++;
		  if(t==1)break;
		  s+=(char)i;
	  }
	 

	  fr.close();  
	  
	return s;
	 }
	
	public String menu(int n,int p,int level)throws Exception{  
		 FileReader fr;
		if(level==1){
			 fr=new FileReader("text_files/easy.txt"); 
		}
		else if(level==2){
			 fr=new FileReader("text_files/medium.txt"); 
		}
		else{
			 fr=new FileReader("text_files/hard.txt"); 
		}
	  int i;  
	  int line=p+n;
	  int k=1;
	  int t=0;
	  String s= new String();
	  while((i=fr.read())!=-1)  
	  {
		  if(k==line)break;
		  if(i=='\n')k++;
	  }
	 
	  while((i=fr.read())!=-1)  
	  {
		  if(i=='\n')t++;
		  if(t==1)break;
		  s+=(char)i;
	  }
	 

	  fr.close();  
	  
	return s;
	 }
	 
	 
	 
	 
	 int check(int n,int level) throws IOException
	 {
		  FileReader fr;
		  if(level==1)
			  fr=new FileReader("text_files/easy.txt"); 
		  else if(level==2)
			  fr=new FileReader("text_files/medium.txt"); 
		  else 
			  fr=new FileReader("text_files/hard.txt"); 
		  int i;  
		  int line=5+n;
		  int k=1;
		  int t=0;
	
		  while((i=fr.read())!=-1)  
		  {
			  if(k==line)
				  break;
			  if(i=='\n')
				  k++; 
		  }
		  while((i=fr.read())!=-1)  
		  {
			  if(i>='0' && i<='9'){
				  fr.close(); 
				  return (int)i-48;
			  }
			  if(i=='\n')
				  t++;
			  if(t==1)
				  break;
			  
		  }
		  fr.close();
		 return 0;
	 }
	 
	
	}  


