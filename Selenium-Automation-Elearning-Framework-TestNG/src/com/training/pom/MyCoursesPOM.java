package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursesPOM {
	private WebDriver driver; 
	
	public MyCoursesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Create a course")
	private WebElement createCourse; 
	@FindBy(id="title")
	private WebElement courseName; 
	@FindBy(id="advanced_params")
	private WebElement advSettigs;
	@FindBy(className="filter-option-inner-inner")
	private WebElement category;
	@FindBy(xpath="(//a[@role='option'])[4]")
	private WebElement categoryDropDown;
	@FindBy(id="add_course_wanted_code")
	private WebElement courseCode;
	@FindBy(xpath="(//div[@class='filter-option-inner-inner'])[2]")
	private WebElement language;
	@FindBy(xpath="(//a[@role='option'])[10]")
	private WebElement chooseLang;
	@FindBy(id="add_course_submit")
	private WebElement create;
	@FindBy(xpath="(//a[contains(@class,'default')])[2]")
	private WebElement intro;
	@FindBy(xpath="//body[contains(@class,'cke_editable_themed')]")
	private WebElement text;
	@FindBy(xpath="//iframe[contains(@class,'cke_wysiwyg_frame')]")
	private WebElement frame;
	@FindBy(id="introduction_text_intro_cmdUpdate")
	private WebElement save;
	@FindBy(xpath="(//h4[@class='course-items-title'])[2]/a")
	private WebElement createdCourse; 
	
	public void clickCreateCourse() {
		this.createCourse.click(); 
	}
	
	public void EnterCourseName(String courseName) {
		this.courseName.clear(); 
		this.courseName.sendKeys(courseName); 
	}
	
	public void clickAdvSettigs() {
		this.advSettigs.click(); 
	}
	public void selectCourseCode() {
		this.category.click();
	}
	public void selectDropDown() {
		this.categoryDropDown.click();
	}
	public void enterCourseCode(String courseCode) {
		this.courseCode.clear();
		this.courseCode.sendKeys(courseCode);
	}
	public void selectLang() {
		this.language.click();
	}
	public void selectLangDropDown() {
		this.chooseLang.click();
	}
	public void clickCreate() {
		this.create.click();
	}
	public void clickIntro() {
		this.intro.click();
	}
	public void enterText(String text) {
		driver.switchTo().frame(frame);
		this.text.clear();
		this.text.sendKeys(text);
		driver.switchTo().defaultContent();
	}
	public void clickSave() {
		this.save.click();
	}
	public void clickCreatedCourse() {
		this.createdCourse.click();
	}
}
