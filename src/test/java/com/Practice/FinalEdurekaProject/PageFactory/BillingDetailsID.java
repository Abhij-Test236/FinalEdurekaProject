package com.Practice.FinalEdurekaProject.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingDetailsID {
	
	@FindBy(how = How.NAME, using = "passFirst0")
	public WebElement passFirst ;
	
	@FindBy(how = How.NAME, using = "passLast0")
	public WebElement passLast ;
	
	@FindBy(how = How.NAME, using = "creditnumber")
	public WebElement creditNumber ;
	
	@FindBy(how = How.NAME, using = "buyFlights")
	public WebElement purchaseButton;

}
