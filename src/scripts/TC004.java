package scripts;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.LoginPage;

public class TC004 {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://demo.actitime.com/login.do");
		FileUtils.copyFile(new LoginPage(driver).getLoginButton().getScreenshotAs(OutputType.FILE),
				new File("./errorShots/loginButtonImage.png"));
	}
}