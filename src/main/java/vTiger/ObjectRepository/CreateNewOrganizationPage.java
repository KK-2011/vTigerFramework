package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewOrganizationPage extends WebDriverLibrary {

	//declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//utilization
    public WebElement getAccountNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	// Business Library
	/**
	 * This method will create new organization with account name.
	 * @param orgname
	 */
	public void createNewOrganization(String Orgname)
	{
		OrgNameEdt.sendKeys(Orgname);
		saveBtn.click();
		
	}
	/**
	 * This method will create new contact with industry drop down
	 * @param orgname
	 * @param industryValue
	 */
	public void createNewOrganization(String orgName, String industryValue)
	{
		OrgNameEdt.sendKeys(orgName);
		handleDropDown(industryDropDown, industryValue);
		saveBtn.click();
	}
	
}
