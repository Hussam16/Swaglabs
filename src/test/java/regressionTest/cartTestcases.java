package regressionTest;

import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.LoginPages;
import PageObjects.ProductsPage;
import framework.BaseTest;

public class cartTestcases extends BaseTest {

	private LoginPages loginPages;
	private ProductsPage productsPage;
	private CartPage cartPage;

	@BeforeMethod
	public void name() {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);

	}

	@Test
	public void verifyCartPageOpened() {
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.addRandomIteamToCart();;
		productsPage.clickCart();
		Assert.assertEquals(cartPage.cartPageOpened(), "Yor Cart");;
	}
	
	
	@Test
	public void removeIteamFromcart() {
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.addRandomIteamToCart();;
		productsPage.clickCart();
		cartPage.cartPageOpened();
		Assert.assertEquals(0, cartPage.removeProduct());;
		
	}
	
	
	
}
