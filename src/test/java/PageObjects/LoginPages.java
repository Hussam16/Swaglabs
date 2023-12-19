package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.Pagebase;

public class LoginPages extends Pagebase {

	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	private By message = By.cssSelector("h3[data-test='error']");

	public LoginPages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void navigateSwagLabs() {

		driver.navigate().to("https://www.saucedemo.com/v1/index.html");

	}

	public void signInUsernamePassword(String email, String Pass) {

		enterTxt(userName, email);
		enterTxt(password, Pass);
		clickButton(loginButton);
		

	}

	public String lockedUser(String email, String Pass) {

		enterTxt(userName, email);
		enterTxt(password, Pass);
		 clickButton(loginButton);
		 return getMessage(message);
		

	}
	
	
	public String signUsernameOnly(String email) {
		enterTxt(userName, email);
		clickButton(loginButton);
		return getMessage(message);
		

	}

	public String signpasswrodOnly(String pass) {
		enterTxt(password, pass);
		clickButton(loginButton);
		return getMessage(message) ;
		

	}

	public String clickSignButtononly() {
		clickButton(loginButton);
		return getMessage(message);
	}
	
	public void refreshLoginPage() {
		refreshPage();
		
	}

}
