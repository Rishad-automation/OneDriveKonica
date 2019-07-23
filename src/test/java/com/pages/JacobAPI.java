package com.pages;

public class JacobAPI {
	
	
	public void UploadFileUsingJacobDll()
			throws InterruptedException {

		String workingDir = System.getProperty("user.dir");

		final String jacobdllarch = System.getProperty("sun.arch.data.model")
				.contains("32") ? "jacob-1.18-x86.dll" : "jacob-1.18-x64.dll";
		String jacobdllpath = workingDir + "\" + jacobdllarch;

		File filejacob = new File(jacobdllpath);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH,
				filejacob.getAbsolutePath());
		AutoItX uploadWindow = new AutoItX();

		driver = new FirefoxDriver();
		String filepath = workingDir + "\SeleniumWebdriverUploadFile.html";
		driver.get(filepath);

		Thread.sleep(1000);
		

		driver.findElement(By.id("uploadfile")).click();

		Thread.sleep(1000);

		if (uploadWindow.winWaitActive("File Upload", "", 5)) {
			if (uploadWindow.winExists("File Upload")) {
				uploadWindow.sleep(100);
				uploadWindow.send(filepath);
				uploadWindow.controlClick("File Upload", "", "&Open");

			}
		}
	}

}
