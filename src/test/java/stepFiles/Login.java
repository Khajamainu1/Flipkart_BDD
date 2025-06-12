package stepFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver = Driver.getDriver();
	
	@Given(": User navigates to the url")
	public void user_navigates_to_the_url() {
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("ll"));
	   System.out.println("Given : url");
	}

	@When(": User enter the valid username and password")
	public void user_enter_the_valid_username_and_password() {
		System.out.println("When : UN/Pwd");
	}

	@When(": Click on login button")
	public void click_on_login_button() {
		System.out.println("And : Login button");
	}

	@Then(": Verify user logged in successfully.")
	public void verify_user_logged_in_successfully() {
		System.out.println("Then : verify");
	}
	
	

	@When(": User enter the invalid username and password")
	public void user_enter_the_invalid_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
