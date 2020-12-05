package com.saucedemo.pages;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CheckoutPage extends PageObject {

	@FindBy(id="first-name")
	WebElement txtFirstName;
	
	@FindBy(id="last-name")
	WebElement txtLastName;
	
	@FindBy(id="postal-code")
	WebElement txtPostCode;
	
	@FindBy(xpath=".//input[@value='CONTINUE']")
	WebElement btnContinue;
	
	@FindBy(linkText="CANCEL")
	WebElement btnCancel;
	
	@FindBy(linkText="FINISH")
	WebElement btnFinish;

	public By lblConfirmOrder =  By.className("complete-header");
	
	public void enterFirstname(String firstName) {
		try {
			typeInto(txtFirstName, firstName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterLastname(String lastName) {
		try {
			typeInto(txtLastName, lastName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterZipCode(String zipCode) {
		try {
			typeInto(txtPostCode, zipCode);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickContinue() {
		try {
			clickOn(btnContinue);
			String url = getDriver().getCurrentUrl();
			assertEquals("https://www.saucedemo.com/checkout-step-two.html", url);
			CartPage.assertInventoryName();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickFinish() {
		try {
			clickOn(btnFinish);
			String url = getDriver().getCurrentUrl();
			assertEquals("https://www.saucedemo.com/checkout-complete.html", url);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyPlacedOrder() {
		try {
			boolean blnFlag = isElementVisible(lblConfirmOrder);
			assertTrue(blnFlag);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
