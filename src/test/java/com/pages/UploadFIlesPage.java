package com.pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

import com.base.OneDriveBase;

public class UploadFIlesPage extends OneDriveBase {
	WebDriver driver;

	public UploadFIlesPage() {
		PageFactory.initElements(driver, this);
	}

	// UploadFileElements
	@FindBy(xpath = "//div[contains(text(),'Upload')]")
	WebElement UploadButton;

	// upload new
	@FindBy(xpath = "//div[@id='id__29']")
	WebElement UploadButton1;

	// Files Element
	@FindBy(xpath = "//li[@role='presentation']/descendant::span[contains(text(),'Files')]")
	WebElement filesButton;

		// uploaded text file
	@FindBy(xpath = "//span[contains(text(),'TextFile.txt')]")
	WebElement uploadedFileText;

	// uploaded text file
	@FindBy(xpath = "//span[contains(text(),'TextFile (1).txt')]")
	WebElement uploadedFileText1;

	// FilesCheckbox
	@FindBy(xpath = "//div[@data-automationid='TextFile.txt']//span[@role='checkbox']")
	WebElement TextFileCheckBox;
	// Info Button
	@FindBy(xpath = "//i[contains(text(),'')]")
	WebElement infoButton;
	
	// Filesize
	@FindBy(xpath = "//dl[@class='InfoPaneSection-informationBody']/dd[contains(text(),'bytes')]")
	WebElement DataSize;
	
	//Editor Button
	@FindBy(xpath = "//div[contains(text(), 'Open')]")
	WebElement Editor;

	public void uploadFileButton() {
		UploadButton.click();
	}

	// Zero Beta File Upload
	public void zeroFilesClick() throws InterruptedException, AWTException {

		filesButton.click();

//		//Using SendKeys::
//		String ZeroFilePath  = System.getProperty("user.dir") + "/File/FORMAT70.CMD";
//		filesButton.sendKeys(ZeroFile);

		// Using Robot Class::

		// Specify the file location with extension
		String ZeroFilePath = System.getProperty("user.dir") + "/File/FORMAT70.CMD";
		StringSelection sel = new StringSelection(ZeroFilePath);

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		System.out.println("selection" + sel);

		// Create object of Robot class
		Robot robot = new Robot();
		Thread.sleep(1000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// TextFile Upload
	public void textFilesClick() throws AWTException, InterruptedException {
		filesButton.click();

		// Using SendKeys::
//		String textFile  = System.getProperty("user.dir") + "/File/TextFile.txt";
//		filesButton.sendKeys(textFile);

		// Using Robot Class::

		// Specify the file location with extension
		String textFilePath = System.getProperty("user.dir") + "/File/TextFile.txt";
		StringSelection sel = new StringSelection(textFilePath);

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		System.out.println("selection" + sel);

		// Create object of Robot class
		Robot robot = new Robot();
		Thread.sleep(1000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

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
		String size = DataSize.getText();
		System.out.println("Uploaded file bytes:" + size);
		Assert.assertEquals(size, "26 bytes");

		String textFile = System.getProperty("user.dir") + "/File/TextFile.txt";
		File f = new File(textFile);
		if (f.exists()) {
			String bytes = f.length() + " bytes";
			// double kilobytes = (bytes / 1024);
			// String bytesAsString = Double.toString(bytes);
			System.out.println("bytes : " + bytes);
			// System.out.println("kilobytes : " + kilobytes);
			System.out.println("Sourcefile bytes : " + bytes);

			Assert.assertEquals(size, bytes);
		} else {
			System.out.println("File does not exists!");
		}
	}
	
	// Files Element
		@FindBy(xpath = "//span[@class='ms-ContextualMenu-itemText label-109'][contains(text(),'Files')]")
		WebElement filesButton1;
		
	// Update the contents of the text document
	// Delete Files
		@FindBy(xpath = "//button[@name='Delete']//div[@class='ms-Button-flexContainer flexContainer-61']")
		WebElement deleteFile;

		// CopyToFile
		@FindBy(xpath = "//button[@name='Copy to']//div[@class='ms-Button-flexContainer flexContainer-61']")
		WebElement copyToFile;

		// CopyButton
		@FindBy(xpath = "//button[@name='Copy']//div[@class='ms-Button-flexContainer flexContainer-61']")
		WebElement copyButton;

		// XButton
		@FindBy(xpath = "//button[@name='Close']//div[@class='ms-Button-flexContainer flexContainer-61']")
		WebElement ButtonX;

		// DownloadButton
		@FindBy(xpath = "//button[@name='Download']//div[@class='ms-Button-flexContainer flexContainer-61']")
		WebElement downloadButton;

}
