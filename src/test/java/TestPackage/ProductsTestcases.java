package TestPackage;

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



	@Test(description = "Add Product To Cart")
	public void addProductTocart() {
		
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);

		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		Assert.assertEquals(productsPage.productPageOpened(), "Products");
		Assert.assertEquals("REMOVE", productsPage.addProductToCart(0));
		productsPage.clickBurgerMenu("Logout");

	}

	// from low to High
	@Test(description = "verify SortOf Products From High to Low(")
	public void verifySortOfProducts() {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
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
		productsPage.clickBurgerMenu("Logout");

	}

	public void verifySortOfProductsFromZtoA() {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
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
		productsPage.clickBurgerMenu("Logout");

	}

	@Test(description = "verify Sort From ZtoA")
	public void verifySortFromZtoA() {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);

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
		productsPage.clickBurgerMenu("Logout");

	}

	@Test(description = "verify Menu Contents")
	public void verifyMenuContents() throws InterruptedException {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.clickBurgerMenu("Logout");
				

	}
	
	@Test(description = "verify The Cart Count")
	public void verifyTheCartCount()  {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.addProductToCart(0);
		System.out.println(productsPage.returnCartItemscount());
		Assert.assertEquals(Integer.parseInt(productsPage.returnCartItemscount())-1, 2);;
		productsPage.clickBurgerMenu("Logout");
		
		
	}
	
	
	@Test(description = "verify Product Removal From Cart")
	public void verifyProductRemovalFromCart() {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.addRandomIteamToCart();;
		productsPage.clickCart();
		productsPage.clickBurgerMenu("Logout");
		
		
	}
	
	@Test(description = "Verify that the ")
	public void VerifyRestAppFunctionility() {
		
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.addProductToCart(0);
		productsPage.addProductToCart(1);
		productsPage.clickBurgerMenu("Reset App State");
		productsPage.clickCloseButton();
		Assert.assertTrue(productsPage.returnEmptyCartCount().isEmpty());
		
	}
	
	
	
	
	
	
	
	
	

}
