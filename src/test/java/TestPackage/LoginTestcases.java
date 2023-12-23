package TestPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.LoginPages;
import PageObjects.ProductsPage;
import framework.BaseTest;

public class LoginTestcases extends BaseTest {

	private LoginPages loginPages;
	private ProductsPage productsPage; 


	@Test
	public void sucessfulLogin() {

		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		loginPages.navigateSwagLabs();
		loginPages.signInUsernamePassword("standard_user", "secret_sauce");
		Assert.assertEquals(productsPage.productPageOpened(), "Products");
		productsPage.clickBurgerMenu("Logout");

	}

	@Test
	public void verifyErrorLoginMessage() {
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		loginPages.navigateSwagLabs();
		Assert.assertEquals(loginPages.signUsernameOnly("standard_user"), "Epic sadface: Password is required");
		loginPages.refreshLoginPage();
		Assert.assertEquals(loginPages.signpasswrodOnly("standard_user"), "Epic sadface: Username is required");
		loginPages.refreshLoginPage();
		Assert.assertEquals(loginPages.clickSignButtononly(), "Epic sadface: Username is required");

		
	}
	
	@Test
	public void lockedLogin() {
		
		loginPages = new LoginPages(driver);
		productsPage = new ProductsPage(driver);
		loginPages.navigateSwagLabs();
		Assert.assertEquals(loginPages.lockedUser("locked_out_user", "secret_sauce"), "Epic sadface: Sorry, this user has been locked out.");
		

	}
	
	
	
	

}
