package Sino.Myriad;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupTeardown {
WebDriver driver;
	@BeforeSuite
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
	}
	@Test
	public void birnger() {
		driver.findElement(By.name("q")).sendKeys("reddit"+Keys.ENTER);
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
