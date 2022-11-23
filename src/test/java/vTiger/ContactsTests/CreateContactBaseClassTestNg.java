package vTiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;

@Listeners(vTiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactBaseClassTestNg extends BaseClass {
	
	@Test(groups = "smokeSuite")
	public void CreateContactBaseClassTestNG() throws EncryptedDocumentException, IOException 
	{
	
	   //step 1 : read all the required data
	   String LASTNAME = eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();

	  //step 2 : navigate to contacts link
	  HomePage hp = new HomePage(driver);
	  hp.clickContactsLnk();
	  //Assert.fail();  //--> This will purposefully fail the test script and rest all will execute
			
	  //step 3: navigate to create contact look up image
      ContactsPage cp = new ContactsPage(driver);
	  cp.clickOnCreateContactImg();
			
	  //step 4 : create contact with mandatory details and save
	  CreateNewContactPage ccp = new CreateNewContactPage(driver);
	  ccp.createNewContact(LASTNAME);
			
	  //step 5 :validate
	  ContactsInfoPage cip = new ContactsInfoPage(driver);
	  String contactHeader = cip.getContactHeader();
	  System.out.println(contactHeader);
	  Assert.assertTrue(contactHeader.contains(LASTNAME));
			
	 
	}		
	
	@Test
	public void createContactDemoTest()
	  {
		  System.out.println("demo created");
	  }
	
	@Test
	public void createContactWithLeadSource()
	{
		System.out.println("lead source");
	}
     
	@Test
	public void createContactWithLeadSourceandOrg()
	{
		System.out.println("lead source with org");
	}
}
