package com.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ifDownloadFile {
	WebDriver driver;

	public ifDownloadFile() {
		PageFactory.initElements(driver, this);
	}

	// To create a method as 'FileDownloaded' 

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		// downloadPath= "/Users/nazmulhoque/Downloads/TextFile (2).txt";
		// fileName= "TextFile (2).txt";

		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

}
