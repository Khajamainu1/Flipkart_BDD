package stepFiles;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login {
	
	LoginPage lp = new LoginPage();

	@Given(": User navigates to the url")
	public void user_navigates_to_the_url() {
		
	}

	@When(": User enter the invalid phone number")
	public void user_enter_the_invalid_phone_number() 
	{
		lp.clickLogin();
		lp.enterPhoneNumber("1234567890");
	}

	@When(": Click on request otp button")
	public void click_on_request_otp_button() {
		lp.clickRequestOTPButton();
	}

	@Then(": Verify invalid phone number message is be shown.")
	public void verify_invalid_phone_number_message_is_be_shown() {
		lp.validateErrorMessage();
	}

}
