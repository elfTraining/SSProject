package com.SS.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SS.genricLib.Utility;

public class LogedinHome 
{
	HomePage home;
	
	@FindBy(linkText = "MY PROFILE")
	private WebElement myproLink;
	
	@FindBy(xpath="//span[.='LOGOUT']")
	private WebElement logoutButton;

	
	
	
	public WebElement getMyproLink() {
		return myproLink;
	}
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	
	
	
	public void logout(WebDriver driver)
	{
		home = PageFactory.initElements(driver, HomePage.class);
		Utility.mouseAction(driver, home.getUserIcon());
		logoutButton.click();
	}
	
	public void myPage(WebDriver driver)
	{
		home = PageFactory.initElements(driver, HomePage.class);
		Utility.mouseAction(driver, home.getUserIcon());
		myproLink.click();
	}
}
