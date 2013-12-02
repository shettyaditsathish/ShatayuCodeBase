package com.shatayu.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class Logger {
		public static void log(String content) {
			
			
			try{
	    	     String logLocation = System.getenv("SHATAYULOGLOCATION");
	    	     FileWriter fstream = new FileWriter(logLocation+File.separator+"log.txt",true);
			     BufferedWriter out = new BufferedWriter(fstream);
			     out.write(getCurrentDate()+content+"\n");
			     out.close();
			   }catch (Exception e){//Catch exception if any
				 System.out.println("Error=  "+e);
			   }
	   }
		
		public static void log(Throwable exc) {
			
			try{
	    	    String logLocation = System.getenv("SHATAYULOGLOCATION");
	    	    FileWriter fstream = new FileWriter(logLocation+File.separator+"log.txt",true);
			    BufferedWriter out = new BufferedWriter(fstream);
			    StringWriter sw = new StringWriter();
		        PrintWriter pw = new PrintWriter(sw, true);
		        
		        exc.printStackTrace(pw);
		        pw.flush();
			    out.write(getCurrentDate()+sw.toString()+"\n");
			    out.close();
			   
				pw.close();
		        sw.flush();
				
		   }catch (Exception e){//Catch exception if any
			   System.out.println("Error=  "+e);
		   }
	   }
	   
	   public static String getCurrentDate(){
		   return new Date() +" ";
	   }
}
