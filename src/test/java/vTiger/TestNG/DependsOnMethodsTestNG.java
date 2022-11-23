package vTiger.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsTestNG {

	@Test
	public void createCustomer()
	{
		Assert.fail();
		System.out.println("Customer Created");
	}
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("Customer Modified");
		
	}
	@Test
	public void deleteCustomer()
	{
		System.out.println("Customer Deleted");
	}
}
