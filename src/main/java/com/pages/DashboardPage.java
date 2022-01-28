package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage {

	WebDriver ldriver;

	public DashboardPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//span[text()='Users']")
	WebElement lnkuser;

	@FindBy(xpath="//button[text()='Add User']")
	WebElement txtAddUser;

	@FindBy(id="username")
	WebElement txtUserName;

	@FindBy(id="mobile")
	WebElement txtUserMoble;

	@FindBy(id="email")
	WebElement txtemail;

	@FindBy(id="course")
	WebElement txtcourse;

	@FindBy(id="Male")
	WebElement clkgender;

	@FindBy(xpath="//select")
	WebElement selectcls;

	@FindBy(id="password")
	WebElement txtpaswd;

	@FindBy(xpath="//input[@placeholder='FriendMobile']")
	WebElement txtfrndmob;

	@FindBy(id="submit")
	WebElement clkSubmit;

	public void clickUser() {
		lnkuser.click();
	}
	public void clickAddUser() {
		txtAddUser.click();
	}
	public void custUserName(String cname) {
		txtUserName.sendKeys(cname);
	}

	public void custMobile(String cMob) {
		txtUserMoble.sendKeys(cMob);
	}

	public void custEmailId(String cemail) {
		txtemail.sendKeys(cemail);
	}

	public void custCourse(String course) {
		txtcourse.sendKeys(course);
	}

	public void custgender() {
		clkgender.click();
	}

	public void custState(String state) {

		Select st = new Select(selectcls);
		st.selectByValue(state);
	}

	public void custPassword(String pwd) {
		txtpaswd.sendKeys(pwd);
	}

	public void custFriendMobile(String frndno) {
		txtfrndmob.sendKeys(frndno);
	}

	public void clickSubt() {
		clkSubmit.click();
	}

}

