package com.Practice.FinalEdurekaProject.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Practice.FinalEdurekaProject.PageFactory.SelectFlightsID;
import com.Practice.FinalEdurekaProject.testScripts.NewTour;

public class SelectFlights {
	
	SelectFlightsID page = new SelectFlightsID();
	WebDriver driver1;
	final static Logger log = Logger.getLogger(NewTour.class.getName());
	

	public SelectFlights(WebDriver driver) {
		driver1 = driver;

		PageFactory.initElements(driver, page);
	}
	
	public void clickOnContinueButton() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver1;
		jse.executeScript("window.scrollBy(0,125)", "");
		
		page.continueButton.click();
	}

}
