package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fil.pages.ContactPage;
import fil.pages.DealsPage;
import fil.pages.HomePage;
import fil.pages.Login;
import fil.pages.TaskPage;
import fil.utility.TestBase;

public class HomePageTest extends TestBase{
	

Login LoginPage;
HomePage HomePage;
ContactPage Contact;
DealsPage Deal;
TaskPage Task;


@BeforeMethod
public void setupHomePage() {
browserInitialization();
LoginPage=new Login();
HomePage=LoginPage.login(TestBase.fetchValue("username"), TestBase.fetchValue("password"));
}


//Testcase1:

//@Test(priority=1)
public void HomePageTitleTest() {
String HomePageActTitle=HomePage.HompagegetTitle();	
Assert.assertEquals(HomePageActTitle, "CRM","HomePage Title is not Matched");
}


@Test(priority=2)
public void clickContactPageTest() {
Contact=HomePage.ClickonContact();	
Assert.assertTrue(Contact instanceof ContactPage);
}

//@Test(priority=3)
public void clickDealPageTest() {
Deal=HomePage.clickonDeal();
Assert.assertEquals(Deal, new DealsPage());
}

//@Test(priority=4)
public void clickTaskPageTest() {
Task=HomePage.clickonTask();
Assert.assertEquals(Task, new TaskPage());
}

@AfterMethod
public void tearDown() {
	driver.quit();
}
	
	

}
