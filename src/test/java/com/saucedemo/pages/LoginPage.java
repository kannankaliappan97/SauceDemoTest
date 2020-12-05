package com.saucedemo.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject{
	
	@FindBy(id="user-name")
	WebElement txtUsername;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login-button")
	WebElement btnLogin;
	
	public void launchApplication() {
		try {
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			open();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterUsername(String username) {
		try {
			typeInto(txtUsername, username);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterPassword(String password) {
		try {
			typeInto(txtPassword, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickLogin() {
		try {
			clickOn(btnLogin);
			String url = getDriver().getCurrentUrl();
			assertEquals("https://www.saucedemo.com/",url);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
