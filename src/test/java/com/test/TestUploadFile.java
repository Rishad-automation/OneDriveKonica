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
	public void setUp() throws InterruptedException {
		initialization();

		OneDriveLoginPage loginPage = PageFactory.initElements(driver, OneDriveLoginPage.class);
		//UploadFIlesPage upload = PageFactory.initElements(driver, UploadFIlesPage.class);
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

	@Test(priority = 1)
	public void testZeroByte() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		upload = PageFactory.initElements(driver, UploadFIlesPage.class);
		Thread.sleep(3000);
		upload.uploadFileButton();

		Thread.sleep(3000);
		upload.zeroFilesClick();
		upload.textFilesClick();
		upload.handleAlertZeroFile();
		upload.handleAlertTextFile();
		upload.selectUploadedDocs();
		upload.scrollPageDown(driver);
		upload.textFileSize();

	}

	//@Test(priority = 2)
	public void testContents() {
		Filecontents = PageFactory.initElements(driver, UpdateDeleteContentsPage.class);
		Filecontents.UploadedDocs();
		Filecontents.updateFileContents();
	}

	//@Test(priority = 3)
	public void downloadFileBeforeUpdate() {

		Filecontents = PageFactory.initElements(driver, UpdateDeleteContentsPage.class);
		Filecontents.UploadedDocs();
		Filecontents.download();
		
		IsDownload = PageFactory.initElements(driver, ifDownloadFile.class);
		Boolean B = IsDownload.isFileDownloaded("/Users/nazmulhoque/Downloads/TextFile (2).txt", "TextFile (2).txt");
		System.out.println(B);

		// Assert.assertTrue(isFileDownloaded("/Users/nazmulhoque/Downloads/TextFile
		// (2).txt", "TextFile (2).txt"), "File Downloaded");

	}

	//@Test(priority = 4)
	public void downloadFileAfterUpdate() {

		Filecontents = PageFactory.initElements(driver, UpdateDeleteContentsPage.class);
		Filecontents.UploadedDocs();

		Filecontents.updateFileContents();

		Filecontents.download();

		IsDownload = PageFactory.initElements(driver, ifDownloadFile.class);
		Boolean B = IsDownload.isFileDownloaded("/Users/nazmulhoque/Downloads/TextFile (2).txt", "TextFile (2).txt");
		System.out.println(B);
		
		// Will perform the manual test to compare both files.

	}

	//@Test(priority = 5)
	public void deleteFile() {

		Filecontents = PageFactory.initElements(driver, UpdateDeleteContentsPage.class);
		Filecontents.UploadedDocs();
		Filecontents.deleteFile();

	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
