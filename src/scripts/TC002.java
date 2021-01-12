package scripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.HomePage;
import pom.LoginPage;

public class TC002 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.get("https://demo.actitime.com/login.do");
		LoginPage lp = new LoginPage(driver);
		lp.login("admin", "manager");
		HomePage hp = new HomePage(driver);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		if(hp.verifyHomePageTitle()) {
			System.out.println("PASSED");
		} else {
			System.out.println("FAILED");
		}
		driver.quit();
	}
}