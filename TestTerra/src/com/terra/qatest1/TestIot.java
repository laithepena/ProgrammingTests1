package com.terra.qatest1;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(MyTestResultListener.class)
public class TestIot {

	@Test(groups = "iot")
	public void testScheduler1() {
		System.out.println("iot1 Called");
		long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
        
        boolean actual = true;
        boolean expected = true;
        Assert.assertEquals(actual, expected);
        
        
	}
	@Test(groups = "iot")
	public void testScheduler2() {
		System.out.println("iot2 Called");
		long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
        boolean actual = true;
        boolean expected = false;
        Assert.assertEquals(actual, expected);
       
      }
	


	
}