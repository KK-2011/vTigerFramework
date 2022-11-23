package vTiger.ProductTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateProductWithVendorTest {

	public static void main(String[] args) throws IOException {
		
		// step 1 : create objects of all the libraries
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();
		
		//step 2 : read all the required data
	    String BROWSER = pLib.readDataFromPropertyFile("browser");
	    String URL = pLib.readDataFromPropertyFile("url");
	    String USERNAME = pLib.readDataFromPropertyFile("username");
	    String PASSWORD = pLib.readDataFromPropertyFile("password");
	    
	    String productName = eLib.readDataFromExcel("Products", 4, 2)+jLib.getRandomNumber();
	    String vendorName = eLib.readDataFromExcel("Products", 4, 3)+jLib.getRandomNumber();
	    
	    
	    
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
	    	System.out.println("invalid browser");
	    }
	    
	    wLib.maximiseWindow(driver);
	    wLib.waitForPageLoad(driver);
	    driver.get(URL);
	    
		//step 4 : login to application
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step 5 : navigate to More options link
		WebElement element = driver.findElement(By.linkText("More"));
		wLib.mouseHoverOn(driver, element);
		driver.findElement(By.linkText("Vendors")).click();

	}

}
