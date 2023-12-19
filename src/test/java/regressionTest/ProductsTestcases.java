package regressionTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.LoginPages;
import PageObjects.ProductsPage;
import framework.BaseTest;

public class ProductsTestcases extends BaseTest {

	private LoginPages loginPages;
	private ProductsPage productsPage;

	@BeforeMethod
	public void name() {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);

	}

	@Test
	public void addProductTocart() {

		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		Assert.assertEquals(productsPage.productPageOpened(), "Products");
		Assert.assertEquals("REMOVE", productsPage.addProductToCart(0));

	}

	// from low to High
	@Test
	public void verifySortOfProducts() {
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.returnDropDownOptions().selectByVisibleText("Price (low to high)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inventory_container")));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

		boolean lowHigh = Double.parseDouble(prices.get(0).getText().replace("$", "")) < Double
				.parseDouble(prices.get(prices.size() - 1).getText().replace("$", "")) ? true : false;
		Assert.assertTrue(lowHigh);

	}

	public void verifySortOfProductsFromZtoA() {
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.returnDropDownOptions().selectByVisibleText("Name (Z to A)");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inventory_container")));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

		boolean lowHigh = Double.parseDouble(prices.get(0).getText().replace("$", "")) < Double
				.parseDouble(prices.get(prices.size() - 1).getText().replace("$", "")) ? true : false;
		Assert.assertTrue(lowHigh);

	}

	@Test
	public void verifySortFromZtoA() {

		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();

		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		String item1 = productName.get(0).getText();

		productsPage.returnDropDownOptions().selectByVisibleText("Name (Z to A)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inventory_container")));
		List<WebElement> productName2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		String item2 = productName2.get(productName.size() - 1).getText();

		boolean isEqualIgnoreCase = item1.equalsIgnoreCase(item2);
		Assert.assertTrue(isEqualIgnoreCase);

	}

	@Test
	public void verifyMenuContents() throws InterruptedException {
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.clickBurgerMenu("About");
				

	}
	
	@Test
	public void verifyTheCartCount()  {
		
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.addProductToCart(0);
		productsPage.addProductToCart(2);
		Assert.assertTrue(productsPage.returnCartItemscount().equalsIgnoreCase("2"));
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
