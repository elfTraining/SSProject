package com.SS.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SS.genricLib.Utility;


public class HomePage 
{
	@FindBy(xpath = "//a[contains(@class,'locationoverflow')]")
	private WebElement locLink;
	
	@FindBy(name = "sspl_location_pin")
	private WebElement locTB;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//i[@class='icon-user-circle']")
	private WebElement userIcon;
	
	@FindBy(name="email_mobileno")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement userPass;
	
	@FindBy(xpath="//button[.='PROCEED']")
	private WebElement loginButton;
	
	@FindBy(id="js_cartlink")
	private WebElement cartLink;

	@FindBy(xpath="//span[.='Health Services']")
	private WebElement healthLink;
	
	@FindBy(className="icon-dnavita2")
	private WebElement dnavitaLink;
	
	@FindBy(xpath="//a[.='X']")
	private WebElement locpopClose;
	
	
	
	
	public WebElement getLocpopClose() {
		return locpopClose;
	}

	public WebElement getDnavitaLink() {
		return dnavitaLink;
	}

	public WebElement getHealthLink() {
		return healthLink;
	}

	public WebElement getLocLink() {
		return locLink;
	}

	public WebElement getLocTB() {
		return locTB;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getUserPass() {
		return userPass;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getCartLink() {
		return cartLink;
	}

	
	
	
	public void login(String Uname, String Password) throws Exception
	{
		userIcon.click();
		Thread.sleep(500);
		userName.sendKeys(Uname);
		Thread.sleep(500);
		userPass.sendKeys(Password);
		Thread.sleep(500);
		loginButton.click();
	}
	
	
	
	public void dnavitaHP(WebDriver driver)
	{
		Utility.mouseAction(driver, healthLink);
		dnavitaLink.click();
	}
}
