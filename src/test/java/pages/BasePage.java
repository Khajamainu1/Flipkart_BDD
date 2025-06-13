package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Driver;

public class BasePage {

	protected void click(WebElement element, String elementName) {
		element.click();
		System.out.println(elementName + " is clicked");
	}

	protected String getText(WebElement element) {
		return element.getText().trim();
	}

	protected void sendKeys(WebElement element, String value, String elementName) {
		element.sendKeys(value);
		System.out.println(value + " is entered in the " + elementName + " field");
	}

	protected void clickUsingJavaScript(WebElement element, String elementName) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("arguments[0].click()", element);
		System.out.println(elementName + " is clicked");
	}

	protected void visibilityOfElementLocatedBy(By by) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	protected void presenceOfElementLocatedBy(By by) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}

	protected void elementToBeClickable(By by) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	protected void scrollDown(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
		executor.executeScript("arguments[0].scrollIntoView()", element);
	}

	protected void scrollUp(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
		executor.executeScript("arguments[0].scrollIntoView()", element);
	}

	protected void selectDropDownOption(WebElement element, String valueToBeSelected, String dropDownName) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(valueToBeSelected);
		System.out.println(valueToBeSelected + "is selected from the " + dropDownName + " dropdown");
	}
	
	protected void mouseOverToElement(WebElement element, String elementName) {
	    Actions actions = new Actions(Driver.getDriver());
	    actions.moveToElement(element).perform();
	    System.out.println("Mouse hovered over " + elementName);
	}
}
