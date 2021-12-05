package org.newmaven.may;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	WebDriver driver;
	By email=By.id("user_email");
	By password=By.id("user_password");
	By title=By.id("task_name");
	By description=By.id("task_description");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Set mail address
	public void setMail(String mailAddress) {
		driver.findElement(email).sendKeys(mailAddress);
	}
	
	//Set password
	public void setPassword(String mailPassword) {
		driver.findElement(password).sendKeys(mailPassword);
	}
	
	//Login to fluxday
	public void loginToFluxday(String mailAddress, String mailPassword, String ButtonXpad) {
		this.setMail(mailAddress);
		this.setPassword(mailPassword);
		this.clickButton(ButtonXpad);
	}
	
	//Click on button
	public void clickButton(String Xpad) {
		By logoutButton=By.xpath(Xpad);
		driver.findElement(logoutButton).click();
	}
	
	
	//Set Title
	public void setTitle(String Title) {
		driver.findElement(title).sendKeys(Title);
	}
	
	
	//Set Description
	public void setDescription(String Description) {
		driver.findElement(description).sendKeys(Description);
	}
	
	
	//Create task
	public void createTask(String Title, String Description, String ButtonXpad) {
			this.setTitle(Title);
			this.setDescription(Description);
			this.clickButton(ButtonXpad);
	}
}
	
	