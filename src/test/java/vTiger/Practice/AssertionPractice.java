package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	
	@Test
	public void demoTest()
	{
		
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		sa.assertEquals(10, 9);
		//Assert.assertEquals(true, false);
		
		System.out.println("Step 3");
		sa.assertTrue(false);
		
		System.out.println("Step 4");
		sa.assertAll();
		
	}
	
	@Test
	public void demo()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		sa.assertTrue(false);        //  non mandatory field
		
		System.out.println("Step 2");
		Assert.assertTrue(false);     // mandatory field
		
		System.out.println("Step 3");
		sa.assertTrue(false);       // non mandatory field
		
		System.out.println("Step 4");
		sa.assertAll();
	}
}
