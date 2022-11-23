package vTiger.Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDDT {

	public static void main(String[] args) throws Exception {
		
		//step1: read the required data
	    FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	    Properties pobj = new Properties();
	    pobj.load(fis);
	    String BROWSER  = pobj.getProperty("browser");
	    String URL      = pobj.getProperty("url");
	    String USERNAME = pobj.getProperty("username");
	    String PASSWORD = pobj.getProperty("password");
	    
	    WebDriver driver = null;
	    
	    //step 2: launch the browser - RUN TIME POLYMORPHISM
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	System.out.println("==="+BROWSER+" is launched===");
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    	System.out.println("==="+BROWSER+" is launched===");
	    }
	    else
	    {
	    	System.out.println("invalid browser name");
	    }
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get(URL);
	    
	    //step3 : login to the application
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
				
		//Step 4: Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
			
		//Step 5: create contact with mandatory fields
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("KK");
				
		//step 6: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
				
		driver.findElement(By.linkText("Sign Out")).click();
		
		// close the browser
		driver.close();
	    
	    

	}

}
