package com.terra.qatest1;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ExecutionTestListener1 implements ITestListener {

   private long startTime;
 
@Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
		
	Calendar calendar = Calendar.getInstance();

	java.util.Date startTime = calendar.getTime();

	
     System.out.println("TestNG  Test - startTime "+startTime);
  }

@Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println("TestNG Test has finished, took around " + (System.currentTimeMillis() - startTime) + "ms");
	
	Calendar calendar = Calendar.getInstance();

	java.util.Date endTime = calendar.getTime();

	
     System.out.println("TestNG  Test - End Time "+endTime);
     
     System.out.println("TEST PASSED ------ TEST PASSED\n");
    
}



@Override
public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println("TEST FAILED ------ TEST FAILED\n");
}



@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}



@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}



@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}



@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}

}
