package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateContactWithOrganizationTest {

	@Test
	public void CreateContactWithOrganizationTest1() throws IOException  {
		
		//step 1 : create objects of all the libraries
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();
		
		//step 2 : read all the required data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2)+jLib.getRandomNumber();
		String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
		
		WebDriver driver = null;
		
		//step 3 : launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		// step 4 : Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//step 5 : navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 6 : navigate to create organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step 7 : create organization and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 8 : validate 
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("Organization creation failed");
		}
		
		//step 9 : navigate to contacts link 
		driver.findElement(By.linkText("Contacts")).click();
		
		//step 10 : navigate to create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
				
		//step 11 : create contact with mandatory details and save
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
		//step 12 : select the organization created in the organization window
		driver.findElement(By.xpath("//input[@ name='account_name']/following-sibling::img[@title='Select']")).click();
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		wLib.switchToWindow(driver, "Contacts");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 13 : validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		if(contactHeader.contains(LASTNAME));
		{
			System.out.println("PASS");
		}
		
		
		{
			System.out.println("FAIL");
		}
		
		//step 14 : logout of the application
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    wLib.mouseHoverOn(driver, adminImg);
	    driver.findElement(By.linkText("Sign Out")).click();
	    
		
		
		
	}

}
