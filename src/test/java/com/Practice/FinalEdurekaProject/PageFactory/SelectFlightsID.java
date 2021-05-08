package com.Practice.FinalEdurekaProject.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectFlightsID {

	@FindBy(how = How.XPATH, using = "//input[@name='reserveFlights']")
	public WebElement continueButton ;

}
