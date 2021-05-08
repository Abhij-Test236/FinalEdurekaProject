package com.Practice.FinalEdurekaProject.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	static ExtentHtmlReporter reporter;
	static ExtentReports extent;

	public static ExtentReports initiateReport() {
		reporter = new ExtentHtmlReporter("./ExtentReport.html");
		// reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

	public static ExtentTest createTest(ExtentReports extent, String desc) {
		ExtentTest logger;
		logger = extent.createTest(desc);
		return logger;
	}

	public static void generateReportPass(ExtentTest logger, WebDriver driver, String casename) throws IOException {

		String path = ScreenShot.getScreenshot(driver);
		logger.log(Status.PASS, casename);
		logger.pass(casename + " Passed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}

	public static void generateReportFail(ExtentTest logger, WebDriver driver, String casename) throws IOException {
		String path = ScreenShot.getScreenshot(driver);
		logger.log(Status.FAIL, casename);
		logger.fail(casename + " Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
}
