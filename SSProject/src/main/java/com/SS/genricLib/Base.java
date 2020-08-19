package com.SS.genricLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.SS.PageRepository.HomePage;
import com.SS.PageRepository.LogedinHome;

public class Base 
{
	public WebDriver driver;
	public static WebDriver staticdriver;
	FileLib lib = new FileLib();
	
	HomePage home;
	LogedinHome lhome;
	
//	@Parameters("broswer")
	@BeforeClass()
	public void configBC()
	{
//		if(browservar.equals("chrome")) //for cross browser action
		if (lib.getDataFromPrpoertyFile("browser").equals("chrome")) 
		{
//			System.setProperty("webdriver.chrome.driver","./browsers/chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			driver = new ChromeDriver(opt);
			staticdriver = driver;
		}
//		else if(browservar.equals("firefox")) //for cross browser action
		else if (lib.getDataFromPrpoertyFile("browser").equals("firefox")) 
		{
//			System.setProperty("webdriver.gecko.driver","./browsers/geckodriver.exe");
			driver = new FirefoxDriver();
			staticdriver = driver;
		}
		Reporter.log("browser is launched" , true);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(lib.getDataFromPrpoertyFile("url"));
		
		Reporter.log("Website is opened" , true);
	}
	
	@BeforeMethod
	public void configBM() throws Exception
	{	
		home = PageFactory.initElements(driver, HomePage.class);
		home.getLocpopClose().click();
		Thread.sleep(3000);
		home.login(lib.getDataFromPrpoertyFile("Uname"), lib.getDataFromPrpoertyFile("Password"));
		Thread.sleep(500);
		Reporter.log("Login successfully" , true);
	}
	
	@AfterMethod
	public void configAM()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lhome = PageFactory.initElements(driver, LogedinHome.class);
		lhome.logout(driver);
		Reporter.log("Loggedout successfully" , true);
	}
	
	@AfterClass
	public void cnfigAC()
	{
		driver.quit();
		Reporter.log("Browser closed" , true);
	}
}
