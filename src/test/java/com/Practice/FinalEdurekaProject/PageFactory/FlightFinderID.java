package com.Practice.FinalEdurekaProject.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightFinderID {
	
	@FindBy(how = How.XPATH, using = "//input[@value='oneway']")
	public WebElement radioButtonForOnewayTrip ;
	
	@FindBy(how = How.NAME, using = "passCount")
	public WebElement passCount;
	
	@FindBy(how = How.NAME, using = "fromPort")
	public WebElement fromPort;
	
	@FindBy(how = How.NAME, using = "fromMonth")
	public WebElement fromMonth;
	
	@FindBy(how = How.NAME, using = "fromDay")
	public WebElement fromDay;
	
	@FindBy(how = How.NAME, using = "toPort")
	public WebElement toPort;
	
	@FindBy(how = How.NAME, using = "toMonth")
	public WebElement toMonth;
	
	@FindBy(how = How.NAME, using = "toDay")
	public WebElement toDay;
	
	@FindBy(how = How.NAME, using = "findFlights")
	public WebElement findFlights;


}
