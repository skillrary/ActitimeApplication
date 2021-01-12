package scripts;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC003 {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://demo.actitime.com/login.do");
		File rawFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File("./errorShots/loginPageImage.png");
		FileUtils.copyFile(rawFile,targetFile);
	}
}