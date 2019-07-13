package fil.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;


public class TestUtil extends TestBase{
	
public static int PageLoadTime=30;
public static int Implicitwait=20;
String frameName="A";
public static XSSFWorkbook Wb;
	
public void switchToFrame() {
	driver.switchTo().frame(frameName);
}


//Wait:

public static void Threadwait(int time) {
try {
	Thread.sleep(time);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}


public static void SendKeysWait(WebElement Element,int Time, String Value) {
	new WebDriverWait(driver, Time).until(ExpectedConditions.visibilityOf(Element));
	Element.sendKeys(Value);
}


public static void ClickWait(WebElement Element, int Time) {
	new WebDriverWait(driver,Time).until(ExpectedConditions.elementToBeClickable(Element));
	Element.click();
	
}

///////////////////////////////////////////
@DataProvider(name="QA")
public static Object[][] QA() throws Exception{	
FileInputStream Fin=new FileInputStream("./Test Data/TestData.xlsx");

XSSFWorkbook wb=new XSSFWorkbook(Fin);
XSSFSheet sheet=wb.getSheet("Login");

int Rows=sheet.getLastRowNum();
int columns=sheet.getRow(0).getLastCellNum();
System.out.println(Rows+" ,"+columns);

Object data[][]=new Object[Rows][columns];

for(int i=0;i<Rows;i++) {
	for(int j=0;j<columns;j++) {
		
		data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		
		/*XSSFCell Username=sheet.getRow(i).getCell(0);
		XSSFCell Password=sheet.getRow(i).getCell(1);
		XSSFCell Age=sheet.getRow(i).getCell(2);
		*/
		/*if(Username.getCellType()==Username.CELL_TYPE_NUMERIC) {
			
			
			data[i][0]=Username.getNumericCellValue();
			Username.setCellType(Cell.CELL_TYPE_STRING);
		}
		else {
			data[i][0]=Username.getStringCellValue();
		}
		
		if(Password.getCellType()==Password.CELL_TYPE_NUMERIC) {
			
			
			data[i][1]=Password.getNumericCellValue();
			Password.setCellType(Cell.CELL_TYPE_STRING);
		}
		else {
			data[i][1]=Password.getStringCellValue();
		}
		*/
		
	}

}


//for(int i=0;i<data.length;i++) {
	//for(int j=0;j<data[0].length;j++) {
		//System.out.println(data[i][j]);
	//}
//}
return data;

	
}
//////////////////////////////////////////


}
