package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Pagebase;

public class CartPage extends Pagebase {

	private By removeLink = By.cssSelector("button[class='btn_secondary cart_button']");
	private By cartPageTitle = By.cssSelector("div[class='subheader']");
	private By contShoppingButtoun = By.cssSelector("a[class='btn_secondary']");
	private By checkOutButton = By.cssSelector("a[class='btn_action checkout_button']");
	private By checkOutTitle = By.cssSelector("div[class='subheader']");

	private By continueButton = By.cssSelector("input[class='btn_primary cart_button']");
	private By requiredFieldMessage = By.cssSelector("h3[data-test='error']");
	
	private By firstNameField=By.cssSelector("input[id='first-name']");
	private By lastNameField=By.cssSelector("input[id='last-name']");
	private By zipcodeField=By.cssSelector("input[id='postal-code']");

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String cartPageOpened() {

		return waitForElement(cartPageTitle).getText();

	}

	public int removeProduct() {

		WebElement removeLinksIsVisable = waitForElement(removeLink);
		removeLinksIsVisable.click();
		return returnSizeofElementList(removeLink);

	}

	public void clickContinueShoppingButton() {

		clickButton(contShoppingButtoun);

	}

	public String clickCheckOut() {

		clickButton(checkOutButton);
		return getMessage(checkOutTitle);

	}

	public String clickContinueVerifyMessage() {

		clickButton(continueButton);
		return getMessage(requiredFieldMessage);

	}

	public void clickContinue() {

		clickButton(continueButton);
		

	}
	
	public void enterFirstname(String fristname) {

		enterTxt(firstNameField, fristname);

	}

	public void enterLasttname(String lastName) {

		enterTxt(lastNameField, lastName);

	}

	public void enterZipcode(String zipcode) {

		enterTxt(zipcodeField, zipcode);

	}

}
