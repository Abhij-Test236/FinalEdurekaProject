package com.Practice.FinalEdurekaProject.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	WebDriver driver;

	public WebDriver OpenApp(String BrowserName, String url) {

		LaunchBrowser(BrowserName);
		OpenURL(url);
		return driver;
	}

	public void OpenURL(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void LaunchBrowser(String browsername) {

		if (browsername.equals("Chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-notifications");
			
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver(options);

		} else if (browsername.equals("IE")) {

			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

	}

}
