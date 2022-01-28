package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	@FindBy(id="email")
	WebElement txtUserName;

	@FindBy(id="password")
	WebElement txtPassword;

	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSubmit;

	public LoginPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit() {
		btnSubmit.click();
	}
}
