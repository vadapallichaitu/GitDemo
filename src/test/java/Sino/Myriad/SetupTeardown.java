package Sino.Myriad;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupTeardown {
WebDriver driver;
ExtentReports extent;
	@BeforeSuite
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
	}
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setReportName("Automation Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "chaitu");
	}
	@Test
	public void birnger() {
		ExtentTest test=extent.createTest("birnger");
		driver.findElement(By.name("q")).sendKeys("reddit"+Keys.ENTER);
		test.addScreenCaptureFromPath("s");
		extent.flush();
	}
	@AfterSuite
	public void Teardown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
