package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibrary.ExcelUtilities;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search_query_top']")
	public WebElement search_field;

	@FindBy(xpath = "//button[@name='submit_search']")
	public WebElement submit_search_icon;

	@FindBy(xpath = "//p[@class='alert alert-warning']")
	public WebElement search_alert_msg;

	
}
