package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyEducationPOM {
	private WebDriver driver; 
	
	public MyEducationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="toolimage_409")
	private WebElement cDescription; 
	
	@FindBy(xpath="//img[@alt='Description']")
	private WebElement description;
	
	@FindBy(id="course_description_title")
	private WebElement title; 
	
	@FindBy(xpath="//body[contains(@class,'cke_editable_themed ')]")
	private WebElement content;
	
	@FindBy(xpath="//iframe[contains(@class,'cke_wysiwyg_frame ')]")
	private WebElement frameDescription;
	
	@FindBy(id="course_description_submit")
	private WebElement save;
	
	@FindBy(id="toolimage_418")
	private WebElement users;
	
	@FindBy(xpath="//tbody/tr[2]/td/input")
	private WebElement checkBox;
	
	@FindBy(xpath="//button[contains(@class,'dropdown-toggle')]")
	private WebElement details;
	
	@FindBy(xpath="(//a[contains(@onclick,'javascript')])[4]")
	private WebElement unsubscribe;
	
	public void clickCourseDescription() {
		this.cDescription.click(); 
	}
	public void clickDescription() {
		this.description.click();
	}
	public void enterTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}
	public void enterContent(String content) {
		driver.switchTo().frame(frameDescription);
		this.content.clear();
		this.content.sendKeys(content);
		driver.switchTo().defaultContent();
	}
	public void clickSave() {
		this.save.click();
	}
	public void clickUsers() {
		this.users.click();
	}
	public void clickCheckBox() {
		this.checkBox.click();
	}
	public void clickDetails() {
		this.details.click();
	}
	public void clickUnsubscribe() {
		this.unsubscribe.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
}
