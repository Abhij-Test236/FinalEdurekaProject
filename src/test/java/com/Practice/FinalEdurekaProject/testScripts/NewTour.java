package com.Practice.FinalEdurekaProject.testScripts;

import org.testng.annotations.Test;

import com.Practice.FinalEdurekaProject.PageObjects.BillingDetails;
import com.Practice.FinalEdurekaProject.PageObjects.FlightFinder;
import com.Practice.FinalEdurekaProject.PageObjects.Login;
import com.Practice.FinalEdurekaProject.PageObjects.SelectFlights;
import com.Practice.FinalEdurekaProject.utils.Browser;
import com.Practice.FinalEdurekaProject.utils.DataProviderUtil;
import com.Practice.FinalEdurekaProject.utils.EmailUtil;
import com.Practice.FinalEdurekaProject.utils.ExtentReport;
import com.Practice.FinalEdurekaProject.utils.HtmlToPdf;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class NewTour {

	public static WebDriver driver;
	String browser = "Chrome";
	String home="http://newtours.demoaut.com/";
	static ExtentHtmlReporter reporter;
	static ExtentReports extent;
	static ExtentTest logger;
	Browser br = new Browser();
	final static Logger log = Logger.getLogger(NewTour.class.getName());

	@BeforeSuite
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		extent = ExtentReport.initiateReport();
	}
	
	@BeforeMethod
	public void browser() {
		
		driver = br.OpenApp(browser, home);
	}

	@Test(dataProvider = "BookTicket")
	public void bookTicket(String userName, String password, String passCount, String depStation, String month, String date, String arrStation,String cardNumber, String firstName, String lastName) throws InterruptedException, IOException {

		try {
			logger = ExtentReport.createTest(extent, "Book Ticket");
			log.info("-----Login-----");
			log.info("Executing method Login");

			Login sin = new Login(driver);
			sin.EnterUserName(userName);
			sin.EnterPassword(password);
			sin.ClickLoginButton();

			log.info("Login executed");

			FlightFinder flight = new FlightFinder(driver);
			flight.selectTypeOfTrip();
			flight.EnterPassengerCount(passCount);
			flight.EnterDepartingStation(depStation);
			flight.EnterFromDate(month, date);
			flight.EnterArrivalStation(arrStation);
			flight.EnterToDate(month,date);
			flight.ClickContinueButton();

			log.info("Finding the Flights");

			SelectFlights select = new SelectFlights(driver);
			select.clickOnContinueButton();

			log.info("Selected the Flights");

			BillingDetails bill = new BillingDetails(driver);
			bill.EnterFirstName(firstName);
			bill.EnterLastName(lastName);
			bill.EnterCreditCard(cardNumber);
			bill.ClickPurchaseButton();

			log.info("purchased the Flight");

			ExtentReport.generateReportPass(logger, driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		}catch (NoSuchElementException e) {
			log.info("Purchase failed");
			ExtentReport.generateReportFail(logger, driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		}

	}

	@Test(dataProvider = "Login")
	public void validateCredentials(String email, String password) throws IOException {

		try {
			logger = ExtentReport.createTest(extent, "Login");
			log.info("-----Login-----");
			log.info("Executing method Login");

			Login sin = new Login(driver);
			sin.EnterUserName(email);
			sin.EnterPassword(password);
			sin.ClickLoginButton();

			log.info("Login executed");

			ExtentReport.generateReportPass(logger, driver, Thread.currentThread().getStackTrace()[1].getMethodName());

		}catch (NoSuchElementException e) {
			log.info("Login failed");
			ExtentReport.generateReportFail(logger, driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}
	
	@AfterMethod
	public void browserclose() {
		
		log.info("Closing driver...");
		driver.close();
		log.info("Driver closed.");
	}

	@AfterSuite
	public void afterSuite() throws IOException {
		
		extent.flush();
		
		HtmlToPdf pdf = new HtmlToPdf();
		pdf.convertToPDF();
		
		log.info("Sending Email");
		EmailUtil em = new EmailUtil();
		em.sendEmail();
		log.info("Email sent");

	}

	@DataProvider(name = "Login")
	public Object[][] loginData() throws IOException {

		String filepath = "./ExcelSheets/Tests.xlsx";
		String sheetName = "Login";
		DataProviderUtil dp = new DataProviderUtil();
		return dp.Provide(1, 2, 1, 1, filepath, sheetName);

	}

	@DataProvider(name = "BookTicket")
	public Object[][] flightData() throws IOException {

		String filepath = "./ExcelSheets/Tests.xlsx";
		String sheetName = "BookTicket";
		DataProviderUtil dp = new DataProviderUtil();
		return dp.Provide(1, 10, 1, 1, filepath, sheetName);

	}

}
