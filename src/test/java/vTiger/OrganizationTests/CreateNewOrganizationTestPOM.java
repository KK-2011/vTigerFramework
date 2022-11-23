package vTiger.OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateNewOrganizationTestPOM {

  @Test(groups = "smokeSuite")
  public void CreateNewOrganizationTestPOMClass() throws IOException
  {
	  
		// step 1 : create objects for all the libraries
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();

		// step 2 : read all the required data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		String ORGNAME = eLib.readDataFromExcel("Organization", 4, 2) + jLib.getRandomNumber();

		WebDriver driver = null;

		// step 3 : launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		} else {
			System.out.println("invalid browser name");
		}

		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);

		// step 4 : login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// step 5 : navigate to organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationsLnk();

		// step 6 : navigate to create organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationImg();

		// step 7 : create contact with mandatory details and save
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME);

		// step 8:validate
		OrganizationsInfoPage cip = new OrganizationsInfoPage(driver);
		String organizationHeader = cip.getOrganizationHeader();
		System.out.println(organizationHeader);
		
		if(organizationHeader.contains(ORGNAME))
	    {
	    	System.out.println("PASS");
	    }
	    else
	    {
	    	System.out.println("FAIL");
	    }
	
	     //step 9 : logout of application
	      hp.signOutOfApp(driver);
	
	}


	}


