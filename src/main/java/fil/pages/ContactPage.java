package fil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fil.utility.TestBase;
import fil.utility.TestUtil;

public class ContactPage extends TestBase {
	
@FindBy(xpath="//div[(text()=\"Contacts\")]")	
WebElement ContactLabel;
	

@FindBy(xpath="//button[contains(text(),'New')]")
WebElement CreateNewContact;

@FindBy(name="first_name")
WebElement Firstname;

@FindBy(name="last_name")
WebElement LastName;

@FindBy(xpath="(//input[@name=\"value\"])[1]")
WebElement Email;

public ContactPage() {
	PageFactory.initElements(driver, this);
}

public boolean verifyContactLabel() {
return  ContactLabel.isDisplayed();	
}



public void selectContactByLabel(String name) {
	driver.findElement(By.xpath("(//td[text()='"+name+"'])[1]//parent::tr//preceding-sibling::td/div")).click();
}


public void clickNewContact(String fn, String ln, String email) {
TestUtil.ClickWait(CreateNewContact, 15);
Firstname.sendKeys(fn);
LastName.sendKeys(ln);
Email.sendKeys(email);
}














//td[text()='Saddu Arrow']//parent::tr[@class='warning']//preceding-sibling::td/div[@class='ui checked fitted read-only checkbox']
//td[text()='Saddu Arrow']//parent::tr//preceding-sibling::td/div[@class='ui checked fitted read-only checkbox']
//td[text()='Flash Supergirl'])[1]//parent::tr//preceding-sibling::td/div

}
