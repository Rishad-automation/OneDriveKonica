package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class UpdateDeleteContentsPage {
	WebDriver driver;
	public UpdateDeleteContentsPage() {
		PageFactory.initElements(driver, this);
	}

	// Download Button
	@FindBy(xpath = "//div[contains(text(), 'Download')]")
	WebElement DownloadButton;

	// TextFile CheckBox
	@FindBy(xpath = "//div[@data-automationid='TextFile.txt']//span[@role='checkbox']")
	WebElement TextFileCheckBox;
	
	// Open in Text Editor Button
	//WebDriverWait wait=new WebDriverWait(driver, 20);
	//WebElement Editor= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Open')]")));
	@FindBy(xpath = "//div[contains(text(), 'Open')]")
	WebElement Editor;
	
	//Text Body
	@FindBy(xpath = "//div[@class='view-lines']//div[1]]")
	WebElement TextBody;
	
	//SaveButton
	@FindBy(xpath = "//div[contains(text(), 'Save')]")
	WebElement SaveButton;

	// Delete Button
	@FindBy(xpath = "//div[contains(text(), 'Delete')]")
	WebElement DeleteButton;

	public void UploadedDocs() {
		TextFileCheckBox.click();
	}

	public void download() {
		DownloadButton.click();
	}

	public void clickEditor() throws InterruptedException {
		Editor.click();
		Thread.sleep(4000);
		}
	
	public void windowhandle() {
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