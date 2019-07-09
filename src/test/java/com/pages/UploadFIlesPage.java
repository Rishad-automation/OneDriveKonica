package com.pages;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class UploadFIlesPage{
	WebDriver driver;
	public UploadFIlesPage() {
	PageFactory.initElements(driver, this);
	}

	// UploadFileElements
	@FindBy(xpath = "//div[contains(text(),'Upload')]")
	WebElement UploadButton;
	
	//upload new
	@FindBy(xpath = "//div[@id='id__29']")
	WebElement UploadButton1;
	
	//Files Element
	@FindBy(xpath = "//li[@role='presentation']/descendant::span[contains(text(),'Files')]")
	WebElement filesButton;
	
	//Files Element
	@FindBy(xpath = "//span[@class='ms-ContextualMenu-itemText label-109'][contains(text(),'Files')]")
	WebElement filesButton1;
	
	
	//uploaded text file
	@FindBy(xpath="//span[contains(text(),'TextFile.txt')]")
	WebElement uploadedFileText;
	
	//uploaded text file
	@FindBy(xpath="//span[contains(text(),'TextFile (1).txt')]")
	WebElement uploadedFileText1;
	
	//Delete Files
	@FindBy(xpath="//button[@name='Delete']//div[@class='ms-Button-flexContainer flexContainer-61']")
	WebElement deleteFile;
	
	//CopyToFile
	@FindBy(xpath="//button[@name='Copy to']//div[@class='ms-Button-flexContainer flexContainer-61']")
	WebElement copyToFile;
	
	//CopyButton
	@FindBy(xpath="//button[@name='Copy']//div[@class='ms-Button-flexContainer flexContainer-61']")
	WebElement copyButton;
	
	
	//XButton
	@FindBy(xpath="//button[@name='Close']//div[@class='ms-Button-flexContainer flexContainer-61']")
	WebElement ButtonX;
	
	//DownloadButton
	@FindBy(xpath="//button[@name='Download']//div[@class='ms-Button-flexContainer flexContainer-61']")
	WebElement downloadButton;
	
	
	//FilesCheckbox
	@FindBy(xpath = "")   //Didn't find the xpath
	WebElement TextFileCheckBox;
	//Info Button
	@FindBy(xpath = "//i[contains(text(),'')]")
	WebElement infoButton;
	//Filesize
	@FindBy(xpath = "//dd[contains(text(),'19 bytes')]")
	WebElement DataSize;
	@FindBy(xpath = "//div[contains(text(), 'Open')]")
	WebElement Editor;

	public void uploadFileButton() {
		UploadButton.click();
		
	}
	// Zero Beta File Upload
	public void zeroFilesClick() {
		filesButton.click();
		filesButton.sendKeys("/Users/nazmulhoque/eclipse-workspace/OneDriveAutomation/FORMAT70.CMD");
	}

	// TextFile Upload
	public void textFilesClick() {
		filesButton.click();
		filesButton.sendKeys("Users/nazmulhoque/eclipse-workspace/OneDriveAutomation/TextFile.txt");
	}

	// Zero file uploaded alert
	public void handleAlertZeroFile() {
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println(message);
		if (message.equals("Sorry, OneDrive can't upload empty folders or empty files. Please try again.")) {
			System.out.println("ZeroByte file is not able to uploaded");
		} else {
			System.out.println("Incorrect Message");
		}
		alert.dismiss();
	}

	// Text file Uploaded alert
	public void handleAlertTextFile() {
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println(message);
		if (message.equals("Uploaded 1 items to Files")) {
			System.out.println("Text file uploaded");
		} else {
			System.out.println("Text file was not uploaded");
		}
		alert.dismiss();
	}

	// Select Uploaded document
	public void selectUploadedDocs() {
		TextFileCheckBox.click();
	}

	// click info button
	public void clickInfoButton() {
		infoButton.click();
	}

	// Scrolling page
	public void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,4000)");
	}

	// Verify metadata comparing it to the source file
	public void textFileSize() {
		// WebElement DataSize = driver.findElement(By.xpath("//dd[contains(text(),'19
		// bytes')]"));
		Assert.assertEquals(DataSize, "19 bytes");
		File f = new File("/Users/nazmulhoque/eclipse-workspace/OneDriveAutomation/TextFile.txt");
		long Sourcesize = f.getTotalSpace();
		System.out.println(Sourcesize);
		Assert.assertEquals("Message displayed:" + Sourcesize, "19 bytes");
	}
	// Update the contents of the text document

}
