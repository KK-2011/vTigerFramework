package vTiger.TestNG;

import org.testng.annotations.Test;

public class NegativePriorityTestNg {

	@Test(priority = -3)
	public void createCustomer()
	{
		System.out.println("Customer Created");
	}
	
	@Test(priority = -1)
	public void modifyCustomer()
	{
		System.out.println("Customer Modified");
		
	}
	@Test(priority = -2)
	public void deleteCustomer()
	{
		System.out.println("Customer Deleted");
	}
}
