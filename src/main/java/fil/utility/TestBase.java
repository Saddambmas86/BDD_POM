package fil.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	
public static WebDriver driver;
public static Properties prop;



public static void browserInitialization() {
	String browserName=TestBase.fetchValue("browser");
	
if(browserName.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	driver=new ChromeDriver();
	}
else if(browserName.equalsIgnoreCase("firefox")){
	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	driver=new FirefoxDriver();
}
else {
	System.setProperty("webdriver.ie.driver", "");
	driver=new InternetExplorerDriver();
}


EventFiringWebDriver e_driver=new EventFiringWebDriver(driver);
WebEventListener EventListener=new WebEventListener();
e_driver.register(EventListener);
driver=e_driver;

driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTime, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(TestUtil.Implicitwait, TimeUnit.SECONDS);

driver.get(TestBase.fetchValue("url"));	
}
	
	
public static String fetchValue(String Key) {

try {	
FileInputStream Fin=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\fil\\config\\config.properties");
prop=new Properties();
prop.load(Fin);
}
catch(IOException E) {
	System.out.println(E);
}
return prop.getProperty(Key).toString(); 
}


}
