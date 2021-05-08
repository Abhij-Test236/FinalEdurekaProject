package com.Practice.FinalEdurekaProject.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Practice.FinalEdurekaProject.PageFactory.BillingDetailsID;
import com.Practice.FinalEdurekaProject.testScripts.NewTour;

public class BillingDetails {
	
	BillingDetailsID page = new BillingDetailsID();
	WebDriver driver1;
	final static Logger log = Logger.getLogger(NewTour.class.getName());

	public BillingDetails(WebDriver driver) {
		driver1 = driver;

		PageFactory.initElements(driver, page);
	}
	
	public void EnterFirstName(String firstName) {
		page.creditNumber.sendKeys(firstName);
		log.info("Entered First Name");
	}
	
	public void EnterLastName(String lastName) {
		page.creditNumber.sendKeys(lastName);
		log.info("Entered Last Name");
	}
	
	public void EnterCreditCard(String cardNumber) {
		page.creditNumber.sendKeys(cardNumber);
		log.info("Entered card Number");
	}
	
	public void ClickPurchaseButton() {
		page.purchaseButton.click();
		log.info("Clicked Purachase button");
	}
	
	

}
