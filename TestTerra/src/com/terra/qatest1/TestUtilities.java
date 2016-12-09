package com.terra.qatest1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
 

public class TestUtilities {
	public  static void getProcessStatusEnv(String command) throws IOException{
        String s = null;
           
	    // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec(command);
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            
           // System.exit(0);
        
}
	
	public static void runCommand(String command1) throws IOException{
		  /*Properties prop = new Properties();*/
		  
		  //Properties colProp = new Properties();
	       InputStream input=null;
	       
	       
			try {
				input=new FileInputStream("config.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
        try{
        	 java.util.Properties config = new java.util.Properties(); 
            config.put("StrictHostKeyChecking", "no");
            config.load(input);
            JSch jsch = new JSch();
            Session session=jsch.getSession(config.getProperty("user"),config.getProperty("host"),22);
            session.setPassword(config.getProperty("password"));
           session.setConfig(config);
            session.connect();
            System.out.println("Connected");
             
            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);
             
            InputStream in=channel.getInputStream();
            channel.connect();
            byte[] tmp=new byte[1024];
            while(true){
              while(in.available()>0){
                int i=in.read(tmp, 0, 1024);
                if(i<0)break;
                System.out.print(new String(tmp, 0, i));
              }
              if(channel.isClosed()){
                System.out.println("exit-status: "+channel.getExitStatus());
                break;
              }
              try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }
 
    
		
	}
}
