package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class UpdateDeleteContentsPage {
	WebDriver driver;
	public UpdateDeleteContentsPage() {
		PageFactory.initElements(driver, this);
	}

	// Download elements before updating the contents
	@FindBy(xpath = "//div[contains(text(), 'Download')]")
	WebElement DownloadButton;

	// Update contents elements
	@FindBy(xpath = "//div[@data-automationid='TextFile.txt']//span[@role='checkbox']")
	WebElement TextFileCheckBox;

	@FindBy(xpath = "//div[contains(text(), 'Open')]")
	WebElement Editor;

	@FindBy(xpath = "//div[@class='view-lines']//div[1]]")
	WebElement TextBody;
	// @Cachelookup;
	@FindBy(xpath = "//div[contains(text(), 'Save')]")
	WebElement SaveButton;

	// Delete elements
	@FindBy(xpath = "//div[contains(text(), 'Delete')]")
	WebElement DeleteButton;

	public void UploadedDocs() {
		TextFileCheckBox.click();
	}

	public void download() {
		DownloadButton.click();
	}

	public void updateFileContents() {
		Editor.click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentwindowID = it.next();
		String childwindowID = it.next();
		driver.switchTo().window(childwindowID);
		String Title = driver.getTitle();
		System.out.println("ChildWindow title;" + Title);
		Assert.assertEquals(Title, "OneDrive");
		TextBody.clear();
		TextBody.sendKeys("Updated");
		SaveButton.click();
		driver.close();
		driver.switchTo().window(parentwindowID);
	}

	public void deleteFile() {

		DeleteButton.click();
	}

}