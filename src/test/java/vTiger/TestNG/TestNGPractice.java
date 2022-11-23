package vTiger.TestNG;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test
	public void createCustomer()
	{
		System.out.println("Customer Created");
	}
	
	@Test
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
