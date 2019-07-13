package testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fil.pages.HomePage;
import fil.pages.Login;
import fil.utility.TestBase;

public class LoginTest extends TestBase {

HomePage homepageObject;
Login Lp;


@BeforeMethod
public void setUp() {
browserInitialization();	
Lp=new Login();
	
}


@Test(priority=1)
public void loginTitleTest() {
String ActTitle=Lp.getLoginPageTitle();
Assert.assertEquals(ActTitle, "CRM");	
System.out.println(ActTitle);
}


//boolean flag=true
//Assert.assertTrue(flag)



@Test(priority=2)
public void loginTest() {
homepageObject=Lp.login(fetchValue("username"),fetchValue("password"));
}


@AfterMethod()
public void tearDown() {
	driver.quit();
}




}
