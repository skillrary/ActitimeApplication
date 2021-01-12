package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement usernameTextField;
	
	@FindBy(name="pwd")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginButton;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPasswordLink;
	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}
	
	public void login(String username, String password) {
		getUsernameTextField().clear();
		getUsernameTextField().sendKeys(username);
		
		getPasswordTextField().clear();
		getPasswordTextField().sendKeys(password);
		
		getLoginButton().click();
	}
}
