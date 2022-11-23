package vTiger.OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationUsingBaseClass extends BaseClass {

	@Test(groups = "regressionSuite")
	public void CreateNewOrganizationUsingBaseClass() throws EncryptedDocumentException, IOException
	{

	String ORGNAME = eLib.readDataFromExcel("Organization", 4, 2)+jLib.getRandomNumber();
	
	        // step 1 : navigate to organizations link
			HomePage hp = new HomePage(driver);
			hp.clickOrganizationsLnk();
			Reporter.log("Organizations link clicked", true);

			// step 2 : navigate to create organization look up image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrganizationImg();
			Reporter.log("create organization look up image is clicked", true);

			// step 3 : create contact with mandatory details and save
			CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
			cop.createNewOrganization(ORGNAME);
			

			// step 4 :validate
			OrganizationsInfoPage cip = new OrganizationsInfoPage(driver);
			String organizationHeader = cip.getOrganizationHeader();
			System.out.println(organizationHeader);
			Assert.assertTrue(organizationHeader.contains(ORGNAME));
			Reporter.log("Organization created successfully", true);
			
		
	}	
}
