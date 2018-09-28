package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibrary.ExcelUtilities;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	public WebElement signin_button;

	@FindBy(id = "email")
	public WebElement emailaddress;

	@FindBy(id = "passwd")
	public WebElement password;

	@FindBy(id = "SubmitLogin")
	public WebElement loginbutton;
	
	@FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
	public WebElement Invalid_email_address_msg;
	

	public void loginUser() throws IOException {
		signin_button.click();
		emailaddress.sendKeys("indrapal");
		password.sendKeys("passwd");
		loginbutton.click();
	}
}
