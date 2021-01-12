package scripts;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.HomePage;
import pom.LoginPage;

public class TC005 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		
		String filePath = "./testresources/testdata.xlsx";
		String sheetName = "Sheet1";
		
		FileInputStream fin = new FileInputStream(filePath);
		
		Workbook wb=WorkbookFactory.create(fin);
		String userName=wb.getSheet(sheetName).getRow(1).getCell(0).toString();
		String password=wb.getSheet(sheetName).getRow(1).getCell(1).toString();
		
		LoginPage lp = new LoginPage(driver);
		lp.login(userName, password);
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