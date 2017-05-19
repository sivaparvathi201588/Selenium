package login_test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Linked_Login_Test {
public WebDriver driver;

@Test (dataProvider = "testdata")
public void adminLogin(String Username, String Password){
driver = new FirefoxDriver();
driver.get("https://in.linkedin.com/");	
driver.findElement(By.id("login-email")).clear();
driver.findElement(By.id("login-email")).sendKeys(Username);

driver.findElement(By.id("login-password")).clear();
driver.findElement(By.id("login-password")).sendKeys(Password);

driver.findElement(By.id("login-submit")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/feed/" );	
 
}

@Test (dataProvider = "testdata")
public void forgotpassword(String Username, String Password){
driver = new FirefoxDriver();
driver.get("https://in.linkedin.com/");	
driver.findElement(By.id("login-email")).clear();
driver.findElement(By.id("login-email")).sendKeys(Username);

driver.findElement(By.id("login-password")).clear();
driver.findElement(By.id("login-password")).sendKeys(Password);
driver.findElement(By.linkText("Forgot password?")).click();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.id("userName-requestPasswordReset")).sendKeys(Username);   
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
driver.findElement(By.id("btnSubmitResetRequest")).click();

Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/uas/request-password-reset-submit" );	


}

@AfterMethod
public void closeBrowser(){
	driver.close();
}


@DataProvider (name="testdata")
public Object [] [] readExcel() throws BiffException, IOException{
File f = new File ("E:/selenium/loginData.xls");	
Workbook wb = Workbook.getWorkbook(f);
Sheet s = wb.getSheet("Sheet1");

int rows = s.getRows();
int columns = s.getColumns();

String inputData [][] = new String [rows] [columns];

for (int i = 0; i <rows; i++ ){
	for (int j = 0; j<columns; j++){
		Cell c = s.getCell(j,i);
		inputData [i][j] = c.getContents();
		
	}
}
return inputData;
}
}


