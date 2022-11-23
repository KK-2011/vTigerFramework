package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrganizationHeaderText;
	
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationHeaderText() {
		return OrganizationHeaderText;
	}
	
	//Business Library
	/**
	 * This method will get the header text and returns it to the caller
	 * @return
	 */
	public String getOrganizationHeader()
	{
		return OrganizationHeaderText.getText();
		
	}
}
