package com.terra.qatest1;

import java.io.IOException;

import org.testng.IExecutionListener;

public class ExecutionListener1 implements IExecutionListener {

   private long startTime;

  @Override

   public void onExecutionStart() {
	  try {
		TestUtilities.runCommand("ps -ef");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       startTime = System.currentTimeMillis();

       System.out.println("TestNG is going to start");    

   }

   @Override

   public void onExecutionFinish() {

       System.out.println("TestNG has finished, took around " + (System.currentTimeMillis() - startTime) + "ms");

       try {
   		TestUtilities.getProcessStatusEnv("sar -r");
   	} catch (IOException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
   }

}
