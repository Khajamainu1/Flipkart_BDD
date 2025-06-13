package pages;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.google.common.util.concurrent.Uninterruptibles;

import driver.Driver;

public class LoginPage extends BasePage {
	
	public LoginPage()
	{
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	WebDriver driver = Driver.getDriver();
	
	@FindBy(xpath="//input[@type='text']")
	WebElement txt_phoneNumber;
	
	@FindBy(xpath="//button[text()='Request OTP']")
	WebElement btn_requestOTP;
	
	@FindBy(xpath = "//span[text()='Please enter valid Email ID/Mobile number']")
	WebElement msg_errorMsg;
	
	@FindBy(xpath = "//span[text()='Login']")
	WebElement btn_login;
	
	public void clickLogin()
	{
		mouseOverToElement(btn_login, "Login button");
		clickUsingJavaScript(btn_login, "Login button");
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(4));
	}
	
	public void enterPhoneNumber(String number)
	{
		sendKeys(txt_phoneNumber, number,  "Phone Number");
	}

	
	public void clickRequestOTPButton()
	{
		click(btn_requestOTP, "Request OTP button");
	}
	
	public void validateErrorMessage() {
	    visibilityOfElementLocatedBy(By.xpath("//span[text()='Please enter valid Email ID/Mobile number']"));
	    String expectedMsg = "Please enter valid Email ID/Mobile number";
	    String actualMsg = getText(msg_errorMsg);
	    assertEquals(expectedMsg, actualMsg);
	}
}
