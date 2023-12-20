package framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagebase {

	protected WebDriver driver;
	private WebDriverWait wait;
	private Select select;

	public Pagebase(WebDriver driver) {

		this.driver = driver;
	}

	protected void enterTxt(By locator, String txt) {

		WebElement webElement = waitForElement(locator);
		webElement.sendKeys(txt);
	}

	protected void clickButton(By locator) {

		WebElement webElement = waitForElement(locator);
		webElement.click();
	}

	protected WebElement waitForElement(By locator) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	private WebElement waitForElementVisabilty(By locator) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	protected List<WebElement> waitForElementsVisabilty(By locator) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	protected String getMessage(By locator) {

		WebElement element = waitForElementVisabilty(locator);

		return element.getText();

	}

	protected String getWebElementxt(WebElement webElement) {

		return webElement.getText();

	}

	protected void refreshPage() {

		driver.navigate().refresh();

	}

	protected boolean isDisplayed(By locator) {

		WebElement element = waitForElementVisabilty(locator);
		return element.isDisplayed();

	}

	protected Select selectDropDown(By locator, String text) {

		WebElement element = waitForElementVisabilty(locator);
		return select = new Select(element);
	}
	
	protected int returnSizeofElementList(By loctor) {
		
	 return	driver.findElements(loctor).size();
		
		
	}
	
	

}
