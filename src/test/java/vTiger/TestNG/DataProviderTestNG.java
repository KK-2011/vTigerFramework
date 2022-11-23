package vTiger.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNG {

	@Test(dataProvider = "Phones")
	public void addProductToCartTest(String Name, String Model, int Price, int Quantity)
	{
		System.out.println("Phone name: "+Name+" Model: "+Model+" price: "+Price+" quantity: "+Quantity);
	}
	
	@DataProvider(name = "Phones")
	public Object[][] getData()
	{
		
		                          //row, column
		Object[][] data = new Object[3][4];
		
	 //row, column 	
		data[0][0]= "Samsung";
		data[0][1]= "A80";
		data[0][2]= 25000;
		data[0][3]= 10;
		
		data[1][0] = "iphone";
		data[1][1]= "11Pro";
		data[1][2]= 5000;
		data[1][3]= 5;
		
		data[2][0]= "Vivo";
		data[2][1]= "Y21";
		data[2][2]= 10000;
		data[2][3]= 15;
	    
		return data;
	}
}
