package zxc;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkedin {

	public static WebDriver driver;
	public static Scanner s;
	public void launchapp(String url) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\SivaParvathi\\chromedriver.exe");
	    driver=new  ChromeDriver();
		driver.get(url);
		Thread.sleep(5000);
	}
	
	public void login()
	{
		
	    s=new Scanner(System.in);
	    
		System.out.println("!! Enter Email Address !!");
		String username=s.nextLine();
		driver.findElement(By.id("login-email")).clear();
		driver.findElement(By.id("login-email")).sendKeys(username);
		
		System.out.println("!! Enter Password !!");
		String password =s.nextLine();
		driver.findElement(By.id("login-password")).clear();
		driver.findElement(By.id("login-password")).sendKeys(password);
		
		driver.findElement(By.id("login-submit")).click();
	}
	
	
	
	public void forgotPassword() throws InterruptedException
	{
		driver.findElement(By.linkText("Forgot password?" )).click();
		Thread.sleep(2000);
		System.out.println("!! Enter Email Address !!");
		String email=s.nextLine();
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("request")).click();
		
		
	}
}
