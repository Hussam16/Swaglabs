package PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import framework.Pagebase;

public class ProductsPage extends Pagebase {

	private By productLabel = By.cssSelector("div[class='product_label']");
	private By cartButton = By.cssSelector("button[class='btn_primary btn_inventory']");
	private By dropDownSort = By.cssSelector("select[class='product_sort_container']");
	private By burgerMenu = By.cssSelector("div[class='bm-burger-button']");
	private By menuList = By.cssSelector("a[class='bm-item menu-item']");
	private By cartIcon = By.cssSelector("span[class='fa-layers-counter shopping_cart_badge']");
	private By emptyCartIcon=By.cssSelector("svg[data-icon='shopping-cart']");
	private By productPrice=By.cssSelector("div[class='inventory_item_price']");
	private By closeButton= By.xpath("//button[contains(text(),'Close Menu')]");

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public String getRandomProductPrice() {
		
		List<WebElement> listElements = driver.findElements(productPrice);
		Random random = new Random();
		int randomIndex = random.nextInt(listElements.size());
		WebElement price = listElements.get(randomIndex);
		String productPrice=price.getText();
		List<WebElement> listButtons = driver.findElements(cartButton);
		listButtons.get(randomIndex).click();
		
		return productPrice.replace("$", "");
		
		
		

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String productPageOpened() {

		return getMessage(productLabel);

	}

	public String addProductToCart(int productIndex) {

		List<WebElement> listElements = driver.findElements(cartButton);

		WebElement addCartButton = listElements.get(productIndex);
		addCartButton.click();
		return getWebElementxt(addCartButton);

	}

	public void addRandomIteamToCart() {

		List<WebElement> listElements = driver.findElements(cartButton);
		Random random = new Random();
		int randomIndex = random.nextInt(listElements.size());
		WebElement addCartButton = listElements.get(randomIndex);
		addCartButton.click();

	}

	public Select returnDropDownOptions() {

		return selectDropDown(dropDownSort, null);

	}

	public void clickBurgerMenu(String link) {

		clickButton(burgerMenu);
		List<WebElement> listContents = waitForElementsVisabilty(menuList);

		for (int i = 0; i < listContents.size(); i++) {

			if (listContents.get(i).getText().equalsIgnoreCase(link)) {

				listContents.get(i).click();
				break;

			}

		}

		// TODO Auto-generated method stub

	}

	public String returnCartItemscount() {
		// TODO Auto-generated method stub
		return getMessage(cartIcon);
	}
	
	public String returnEmptyCartCount() {
		return getMessage(emptyCartIcon);
	}

	public void clickCart() {
		clickButton(cartIcon);

	}





	public void clickCloseButton() {
		// TODO Auto-generated method stub
		clickButton(closeButton);
		
	}

}
