package TestPackage;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.CartPage;
import PageObjects.LoginPages;
import PageObjects.ProductsPage;
import framework.BaseTest;

public class cartTestcases extends BaseTest {

	private LoginPages loginPages;
	private ProductsPage productsPage;
	private CartPage cartPage;

	@Test
	public void verifyCartPageOpened() {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		// productsPage.productPageOpened();
		productsPage.addRandomIteamToCart();
		;
		productsPage.clickCart();
		System.out.println(cartPage.cartPageOpened());
		assertTrue(cartPage.cartPageOpened().equalsIgnoreCase("Your Cart"));
		productsPage.clickBurgerMenu("Logout");
	}

	@Test
	public void removeIteamFromcart() {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);

		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("performance_glitch_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.addRandomIteamToCart();
		;
		productsPage.clickCart();
		cartPage.cartPageOpened();
		Assert.assertEquals(0, cartPage.removeProduct());
		productsPage.clickBurgerMenu("Logout");

	}

	@Test
	public void verifyContinueShoppingButton() {

		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);

		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.addRandomIteamToCart();
		;
		productsPage.clickCart();
		cartPage.cartPageOpened();
		cartPage.clickContinueShoppingButton();
		Assert.assertEquals(productsPage.productPageOpened(), "Products");
		productsPage.clickBurgerMenu("Logout");

	}

	@Test
	public void checkOutTheorder() {

		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);

		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.addRandomIteamToCart();
		;
		productsPage.clickCart();
		Assert.assertEquals(cartPage.clickCheckOut(), "Checkout: Your Information");
		productsPage.clickBurgerMenu("Logout");

	}

	@Test
	public void fillCheckoutDetials() {

		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);

		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		productsPage.productPageOpened();
		productsPage.addRandomIteamToCart();
		;
		productsPage.clickCart();
		cartPage.clickCheckOut();

		Assert.assertEquals(cartPage.clickContinueVerifyMessage(), "Error: First Name is required");
		cartPage.enterFirstname("Hussam");

		Assert.assertEquals(cartPage.clickContinueVerifyMessage(), "Error: Last Name is required");

		cartPage.enterLasttname("Abd El Fattah");
		Assert.assertEquals(cartPage.clickContinueVerifyMessage(), "Error: Postal Code is required");

		cartPage.enterZipcode("44444");
		cartPage.clickContinue();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(cartPage.checkOutOverviewOpened(), "Checkout: Overview", "Title is not Matching");
		cartPage.clickFininshButton();
		softAssert.assertEquals(cartPage.verifyThanksMessage(), "THANK YOU FOR YOUR ORDER");
		softAssert.assertAll();

		productsPage.clickBurgerMenu("Logout");

	}

}
