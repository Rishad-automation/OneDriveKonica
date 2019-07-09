package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OneDriveLoginPage {
	WebDriver driver;

	public OneDriveLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(), 'Sign in')]")
	WebElement SignIn;

	@FindBy(xpath = ".//*[@id='signInTitle']/..//input[@type='email']")
	WebElement Email;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement Next;
	@FindBy(id = "i0118")
	WebElement Password;
	@FindBy(id = "idSIButton9")
	WebElement SignInButton;

	public void signinButton() {
		SignIn.click();
	}

	public void typeEmail(String un) {
		Email.sendKeys(un);
	}

	public void NextButton() {
		Next.click();
	}

	public void typePassword(String ps) {
		Password.sendKeys(ps);
	}

	public void signinClick() {
		SignInButton.click();
	}

}