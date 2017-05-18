package zxc;

import org.testng.annotations.*;

public class TestExecution extends Linkedin{

@BeforeTest	
	public void verifylaunchapp() throws InterruptedException
	{
		launchapp("https://in.linkedin.com/");
	}

@Test(priority=0)
	public void verifylogin()
	{
	  	login();
	}


@Test(enabled=false)
	public void verifyforgotPassword() throws InterruptedException
	{
		forgotPassword();
	}

}
