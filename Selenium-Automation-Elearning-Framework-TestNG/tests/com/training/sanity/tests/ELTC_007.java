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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_007 {

	private WebDriver driver;
	private String baseUrl;
	private HomePagePOM homePagePOM;
	private MyCoursesPOM myCoursesPOM;
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
		screenShot.captureScreenShot("1 Login");
		myCoursesPOM.clickCreateCourse();
		screenShot.captureScreenShot("2 MyCourse");
		myCoursesPOM.EnterCourseName("newpodium");
		myCoursesPOM.clickAdvSettigs();
		myCoursesPOM.selectCourseCode();
		myCoursesPOM.selectDropDown();
		myCoursesPOM.enterCourseCode("23");
		myCoursesPOM.selectLang();
		myCoursesPOM.selectLangDropDown();
		myCoursesPOM.clickCreate();
		screenShot.captureScreenShot("3 My Courses");
		myCoursesPOM.clickIntro();
		myCoursesPOM.enterText("this is an selenium course");
		myCoursesPOM.clickSave();
		screenShot.captureScreenShot("4 Intro Updated");
	}
}
