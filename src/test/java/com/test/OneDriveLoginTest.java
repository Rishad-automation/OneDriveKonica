package com.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.OneDriveBase;
import com.healper.UtilitiesFIle;
import com.pages.OneDriveLoginPage;
import com.pages.UploadFIlesPage;



public class OneDriveLoginTest extends OneDriveBase {
	OneDriveLoginPage loginPage;
	public OneDriveLoginTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();}

	@Test()
	public void loginTest() throws InterruptedException {
		loginPage = PageFactory.initElements(driver, OneDriveLoginPage.class);		
		logger = extent.createTest("Login");
		loginPage.signinButton();
		logger.createNode("Click on Sign in Button");
		UtilitiesFIle.signInFrame();
		logger.createNode("Select sin in frame");
		loginPage.typeEmail(prop.getProperty("username"));
		loginPage.NextButton();
		loginPage.typePassword(prop.getProperty("password"));
		loginPage.signinClick();
		
//		UploadFIlesPage upload = PageFactory.initElements(driver, UploadFIlesPage.class);
//		Thread.sleep(3000);
//		upload.uploadFileButton();
//
//		Thread.sleep(3000);
//		upload.zeroFilesClick();
//		upload.textFilesClick();
//		upload.handleAlertZeroFile();
//		upload.handleAlertTextFile();
//		upload.selectUploadedDocs();
//		upload.scrollPageDown(driver);
//		upload.textFileSize();
	}


}
