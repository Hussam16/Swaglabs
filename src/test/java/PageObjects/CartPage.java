package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Pagebase;

public class CartPage extends Pagebase {

	private By removeLink = By.cssSelector("button[class='btn_secondary cart_button']");
	private By cartPageTitle = By.cssSelector("div[class='subheader']");

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String cartPageOpened() {

		return waitForElement(cartPageTitle).getText();

	}

	public int removeProduct() {

		WebElement removeLinksIsVisable = waitForElement(removeLink);
		System.out.println("xxxxxxxxxxxxxxxxxx"+returnSizeofElementList(removeLink));
		removeLinksIsVisable.click();
		return returnSizeofElementList(removeLink);
		


	}
}
