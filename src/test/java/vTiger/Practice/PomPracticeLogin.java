package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.LoginPage;

public class PomPracticeLogin {
     public static void main(String[] args) {
		
    	 WebDriverManager.chromedriver().setup();
    	 WebDriver driver = new ChromeDriver();
    	 
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 driver.get("http://localhost:8888");
    	 
    	 LoginPage lp = new LoginPage(driver);
    	// lp.getUserNameEdt().sendKeys("admin");
    	// lp.getPasswordEdt().sendKeys("admin");              // alternate way
    	// lp.getLoginBtn().click();
    	 
    	 lp.loginToApp("admin","admin");                       //optimizing above three lines to single line
    	
    	 
    	 
	}
}
