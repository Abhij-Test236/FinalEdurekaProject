package com.Practice.FinalEdurekaProject.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Practice.FinalEdurekaProject.PageFactory.LoginID;
import com.Practice.FinalEdurekaProject.testScripts.NewTour;


public class Login {

	LoginID page = new LoginID();
	WebDriver driver1;
	final static Logger log = Logger.getLogger(NewTour.class.getName());
	public static WebDriverWait wait;

	public Login(WebDriver driver) {
		driver1 = driver;

		PageFactory.initElements(driver, page);
	}

	public void EnterUserName(String usernametext) {
		
		wait = new WebDriverWait(driver1, 60);
		wait.until(ExpectedConditions.elementToBeClickable(page.login));
		
		page.username.sendKeys(usernametext);
		log.info("Entered user name");
	}

	public void EnterPassword(String passwordtext) {
		page.password.sendKeys(passwordtext);
		log.info("Entered password");
	}

	public void ClickLoginButton() {
		page.login.click();
		log.info("Clicked Login button");
	}

}
