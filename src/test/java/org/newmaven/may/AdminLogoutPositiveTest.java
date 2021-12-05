package org.newmaven.may;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminLogoutPositiveTest {

	WebDriver driver;
	String driverPath = "/Users/elenaboneva/eclipse-workspace/may/driver/chromedriver";
	LoginPage login;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.fluxday.io/users/sign_in");

	}

	@Test
	public void testLoginAsAdmin() {
		login = new LoginPage(driver);
		login.loginToFluxday("admin@fluxday.io", "password", "//html/body/div[1]/div/form/div[2]/div[3]/button");
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul[3]/li[1]/a")).getText()
				.contains("Admin User"));
		login.clickButton("/html/body/div[2]/div[1]/ul[3]/li[2]/a");
		Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[1]/div/form/div[2]/div[3]/button")).getText()
				.contains("Login"));
	}

	@AfterTest
	public void quitDriver() throws InterruptedException {
		//Thread.sleep(5000);
		driver.quit();
	}

}
