package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.HomePage;
import pom.LoginPage;

public class TC001 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		LoginPage lp = new LoginPage(driver);
		lp.login("admin", "manager");
		//Thread.sleep(10000);
		HomePage hp = new HomePage(driver);
		if(hp.getLogoutLink().isDisplayed()) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
		}	
		driver.quit();
	}
}
