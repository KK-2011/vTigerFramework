package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
    
	 @FindBy(xpath = "//span[@class='dvHeaderText']")
	 private WebElement ContactHeaderText;
	 
	 public ContactsInfoPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	 
	 //Business Library
	/**
	 * This method will get the header text and returns it to the caller
	 * @return
	 */
	public String getContactHeader()
	{
	    return ContactHeaderText.getText();
	}
		
	
}
