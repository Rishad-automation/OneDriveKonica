package com.test;

import java.awt.AWTException;
import java.io.File;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.OneDriveBase;
import com.healper.UtilitiesFIle;
import com.pages.OneDriveLoginPage;
import com.pages.UpdateDeleteContentsPage;
import com.pages.UploadFIlesPage;
import com.pages.ifDownloadFile;

public class TestUploadFile extends OneDriveBase {

	OneDriveLoginPage loginPage;
	UploadFIlesPage upload;
	UpdateDeleteContentsPage Filecontents;
	ifDownloadFile IsDownload;

	public TestUploadFile() {
		super();
	}

	@BeforeMethod
	// Test case 1
	public void setUp() throws InterruptedException {
		initialization();

		OneDriveLoginPage loginPage = PageFactory.initElements(driver, OneDriveLoginPage.class);
		// UploadFIlesPage upload = PageFactory.initElements(driver,
		// UploadFIlesPage.class);
		logger = extent.createTest("Login");
		loginPage.signinButton();
		logger.createNode("Click on Sign in Button");
		UtilitiesFIle.signInFrame();
		logger.createNode("Select sin in frame");
		loginPage.typeEmail(prop.getProperty("username"));
		loginPage.NextButton();
		loginPage.typePassword(prop.getProperty("password"));
		loginPage.signinClick();

	}
	// Test Case 2
	// Attempt to upload a 0 byte file to the documents folder. Verify and track the
	// status of the upload.
	@Test(priority = 1)

	public void uploadZeroByte() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		upload = PageFactory.initElements(driver, UploadFIlesPage.class);
		Thread.sleep(1000);
		upload.uploadFileButton();
		Thread.sleep(1000);
		upload.zeroFilesClick();
		Thread.sleep(2000);
		upload.handleAlertZeroFile();
	}

	// Test Case 3
	// Attempt to upload a text file with content to the documents folder. Verify
	// and track the status of the upload
	 @Test(priority = 2)
	public void uploadTextFile() throws InterruptedException, AWTException {

		upload = PageFactory.initElements(driver, UploadFIlesPage.class);
		Thread.sleep(1000);
		upload.uploadFileButton();
		Thread.sleep(1000);
		upload.textFilesClick();
		upload.handleAlertTextFile();
	}

//Test Case 4
//Select the uploaded document and click on the info button in the top right of the screen.
//Verify metadata about the document is correct by comparing it to the source file
@Test(priority = 3)
	public void verifyMetada() {
		upload = PageFactory.initElements(driver, UploadFIlesPage.class);
		upload.selectUploadedDocs();
		upload.clickInfoButton();
		upload.scrollPageDown(driver);
		upload.textFileSize();
	}

	// Test Case 5
	// Download the versions before update and compare the contents to make sure
	// they download correctly.
	 @Test(priority = 4)
	public void downloadFileBeforeUpdate() throws InterruptedException {

		Filecontents = PageFactory.initElements(driver, UpdateDeleteContentsPage.class);
		Thread.sleep(2000);
		Filecontents.UploadedDocs();
		Thread.sleep(2000);
		Filecontents.download();
		Thread.sleep(2000);
		IsDownload = PageFactory.initElements(driver, ifDownloadFile.class);
		Boolean B = IsDownload.isFileDownloaded("/Users/nazmulhoque/Downloads/TextFile (3).txt", "TextFile (3).txt");
		System.out.println(B);
		
	}

	// Test Case 6
	// Update the contents of the text document from the OneDrive editor and click
	// on save button to create a new version of the document in OneDrive. And download it
	 @Test(priority = 5)
	public void testUpdateContents() throws InterruptedException {
		Filecontents = PageFactory.initElements(driver, UpdateDeleteContentsPage.class);
		Filecontents.UploadedDocs();
		Filecontents.clickEditor();
		Filecontents.windowhandle();
		Filecontents.download();

		IsDownload = PageFactory.initElements(driver, ifDownloadFile.class);
		Boolean B = IsDownload.isFileDownloaded("/Users/nazmulhoque/Downloads/TextFile (2).txt", "TextFile (2).txt");
		System.out.println(B);
		
	}

	 /*Test Case 7
	 Download the versions after update and compare the contents to make sure they
	 download correctly.
	 @Test(priority = 6)
	public void downloadFileAfterUpdate() throws InterruptedException {

		Filecontents = PageFactory.initElements(driver, UpdateDeleteContentsPage.class);
		Filecontents.UploadedDocs();

		Filecontents.updateFileContents();

		Filecontents.download();

		IsDownload = PageFactory.initElements(driver, ifDownloadFile.class);
		Boolean B = IsDownload.isFileDownloaded("/Users/nazmulhoque/Downloads/TextFile (2).txt", "TextFile (2).txt");
		System.out.println(B);
		}*/

		// Will perform the manual test to compare both files.


	// Test Case 8
	// Delete the document from OneDrive.
	@Test(priority = 7)
	public void deleteFile() throws InterruptedException {

		Filecontents = PageFactory.initElements(driver, UpdateDeleteContentsPage.class);
		Filecontents.UploadedDocs();
		Thread.sleep(3000);
		Filecontents.deleteFile();

	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
