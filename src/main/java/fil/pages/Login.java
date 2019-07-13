package fil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fil.utility.TestBase;
import fil.utility.TestUtil;

public class Login extends TestBase {	
	
/*public Login(WebDriver driver){
	this.driver=driver;
}*/
	

//Page Factory:
	
@FindBy(name="email")
WebElement username;
	
@FindBy(name="password")	
WebElement password;

@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
WebElement loginButton;

@FindBy(xpath="//a[text()='Sign Up']")
WebElement SignUpButton;




//Initializing the page object:

public Login() {
	PageFactory.initElements(driver, this);
}

public String getLoginPageTitle() {
	return driver.getTitle();
}

public HomePage login(String un, String ps) {
TestUtil.SendKeysWait(username, 10, un);
TestUtil.SendKeysWait(password, 10, ps);
loginButton.click();
TestUtil.Threadwait(3000);
return new HomePage();
}




/*public void username(String uname, String pass) {
	driver.findElement(By.name("email")).sendKeys(uname);
	driver.findElement(By.name("password")).sendKeys(pass);
	
}
	*/
	

}
