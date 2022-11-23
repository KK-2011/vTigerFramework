package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	//declaration 
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrganizationLookUpImg;
	
	//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//utilization
	public WebElement getCreateOrganizationLookUpImg() {
		return CreateOrganizationLookUpImg;
	}
	
	//Business Library
	/**
	 * This method will click on create organization lookup image
	 */
	public void clickOnCreateOrganizationImg()
	{
		CreateOrganizationLookUpImg.click();
	}
	
	
	
}
