package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fil.pages.ContactPage;
import fil.pages.HomePage;
import fil.pages.Login;
import fil.utility.TestBase;
import fil.utility.TestUtil;

public class ContactPageTest extends TestBase{
	
	
Login login1;
HomePage home1;
ContactPage contact1;
	
@BeforeMethod
public void setup() {
	TestBase.browserInitialization();
	login1 = new Login();
	home1=login1.login(TestBase.fetchValue("username"), TestBase.fetchValue("password"));	
	contact1=home1.ClickonContact();
}

@Test
public void ContactLabelTest() {
Boolean Act=contact1.verifyContactLabel();
Assert.assertTrue(Act, "Contact label is missing");
}

@Test
public void selectSingleContact() {
	contact1.selectContactByLabel("Saddu Arrow");
}



@Test(dataProvider="QA",dataProviderClass=TestUtil.class)
public void createNewContactTest(String Firstname, String Lastname, String Email) {
contact1.clickNewContact(Firstname, Lastname, Email);
}




@AfterMethod
public void teardown() {
driver.quit();	
}



}
