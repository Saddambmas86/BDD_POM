package fil.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fil.utility.TestBase;

public class HomePage extends TestBase {
	
	
@FindBy(xpath="//div[@class='header item']")
WebElement HomePageLogo;


@FindBy(xpath="//span[contains(text(),'Contacts')]")
WebElement Contacts;

@FindBy(xpath="//span[contains(text(),'Calendar')]")
WebElement Calender;
	
@FindBy(xpath="//span[contains(text(),'Tasks')]")
WebElement Task;	
	
	
@FindBy(xpath="//span[contains(text(),'Deals')]")
WebElement Deals;


public HomePage() {
	PageFactory.initElements(driver, this);
}

public String HompagegetTitle() {
return driver.getTitle();	
}

public ContactPage ClickonContact() {
Contacts.click();
return new ContactPage();
}


public DealsPage clickonDeal() {
Deals.click();
return new DealsPage();
}

public TaskPage clickonTask() {
Task.click();
return new TaskPage();
}






}
