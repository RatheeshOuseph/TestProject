package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;
import com.training.pom.MyCoursesPOM;
import com.training.pom.MyEducationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_009 {

	private WebDriver driver;
	private String baseUrl;
	private HomePagePOM homePagePOM;
	private MyCoursesPOM myCoursesPOM;
	private MyEducationPOM myEducation;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homePagePOM = new HomePagePOM(driver); 
		myCoursesPOM = new MyCoursesPOM(driver);
		myEducation = new MyEducationPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		homePagePOM.sendUserName("ratheesh123");
		homePagePOM.sendPassword("ratheesh123");
		homePagePOM.clickLoginBtn(); 
		screenShot.captureScreenShot("3.1 Login");
		myCoursesPOM.clickCreatedCourse();
		screenShot.captureScreenShot("3.2 Created Course");
		myEducation.clickUsers();
		screenShot.captureScreenShot("3.3 Leaners");
		myEducation.clickCheckBox();
		myEducation.clickDetails();
		myEducation.clickUnsubscribe();
		screenShot.captureScreenShot("3.4 Final");
	}
}
