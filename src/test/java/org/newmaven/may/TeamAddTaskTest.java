package org.newmaven.may;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TeamAddTaskTest {
	WebDriver driver;
	String driverPath = "/Users/elenaboneva/eclipse-workspace/may/driver/chromedriver";
	LoginPage login;
	WebDriverWait wait_until;
	String LoginButtonXpad = "//html/body/div[1]/div/form/div[2]/div[3]/button";
	String AdminUserXpad = "/html/body/div[2]/div[1]/ul[3]/li[1]/a";
	String TeamButtonXpad = "/html/body/div[2]/div[1]/ul[2]/li[4]/a";
	String AddTaskButtonXpad = "/html/body/div[2]/div[2]/div[2]/div[1]/div[3]/a[2]";
	String NewTaskXpad = "/html/body/div[2]/div[3]/form/div[3]/div[1]";
	
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
		wait_until = new WebDriverWait(driver, 10);
		// Login as Admin
		login.loginToFluxday("admin@fluxday.io", "password", LoginButtonXpad);
		Assert.assertTrue(driver.findElement(By.xpath(AdminUserXpad)).getText()
				.contains("Admin User"));
		// Click on Team
		login.clickButton(TeamButtonXpad);
		// First add task button check
		wait_until.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AddTaskButtonXpad)));
		Assert.assertTrue(driver.findElement(By.xpath(AddTaskButtonXpad)).getText()
				.contains("Add task"));
		// Click on First add task button
		login.clickButton(AddTaskButtonXpad);
		wait_until.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NewTaskXpad)));
		// Check Create Task button
		Assert.assertTrue(driver.findElement(By.xpath(NewTaskXpad)).getText()
				.contains("Task"));
	}

	@AfterTest
	public void quitDriver() {
		//Thread.sleep(5000);
		driver.quit();
	}

}

