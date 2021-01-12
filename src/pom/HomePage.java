package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	String pageTitle = "actiTIME - Enter Time-Track";
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}	
	
	public boolean verifyHomePageTitle() {
		return driver.getTitle().equals(pageTitle);
	}
}
