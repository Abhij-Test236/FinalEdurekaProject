package com.Practice.FinalEdurekaProject.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Practice.FinalEdurekaProject.PageFactory.FlightFinderID;
import com.Practice.FinalEdurekaProject.testScripts.NewTour;

public class FlightFinder {
	
	FlightFinderID page = new FlightFinderID();
	WebDriver driver1;
	final static Logger log = Logger.getLogger(NewTour.class.getName());

	public FlightFinder(WebDriver driver) {
		driver1 = driver;

		PageFactory.initElements(driver, page);
	}
	
	public void selectTypeOfTrip() {
		
		page.radioButtonForOnewayTrip.click();
		
	}
	
	public void EnterPassengerCount(String pass) {
		
		Select drpPassCount = new Select(page.passCount);
		drpPassCount.selectByVisibleText(pass);
		log.info("Selected passenger count");
	}
	
	public void EnterDepartingStation(String station) {
		
		Select drpfromPort = new Select(page.fromPort);
		drpfromPort.selectByVisibleText(station);
		log.info("Selected departure station");
	}
	
	public void EnterFromDate(String month, String date) {
		
		Select drpFromMonth = new Select(page.fromMonth);
		drpFromMonth.selectByVisibleText(month);
		
		Select drpFromDate = new Select(page.fromDay);
		drpFromDate.selectByVisibleText(date);
		
		log.info("Selected departure date");
	}
	
	public void EnterToDate(String month, String date) {
		
		Select drpToMonth = new Select(page.toMonth);
		drpToMonth.selectByVisibleText(month);
		
		Select drpToDate = new Select(page.toDay);
		drpToDate.selectByVisibleText(date);
		
		log.info("Selected departure date");
	}
	
	public void EnterArrivalStation(String station) {
		
		Select drptoPort = new Select(page.toPort);
		drptoPort.selectByVisibleText(station);
		log.info("Selected arrival station");
	}
	
	public void ClickContinueButton() {
		
		page.findFlights.click();
		log.info("Clicked Continue button");
	}

}
