package com.terra.qatest1;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(MyTestResultListener.class)
public class TestDatabase {
	
	@Test(groups = "db",threadPoolSize = 1, invocationCount = 1, timeOut = 6000)
	public void testConnectOracle()  {
		System.out.println("testConnectOracle()");
		long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
     
       // Thread.sleep(5000);
	
	}

	@Test(groups = "db-nosql",threadPoolSize = 1, invocationCount = 1, timeOut = 1000)
	public void testConnectMongoDB() {
		System.out.println("testConnectMongoDB");
		long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
	}

	
	
}