package com.saucedemo.steps;

import com.saucedemo.pages.CheckoutPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckoutSteps extends ScenarioSteps {
	
	CheckoutPage checkoutPage;
	
	@Step
	public void enterAddress(String firstName, String lastName, String zipCode ) {
		checkoutPage.enterFirstname(firstName);
		checkoutPage.enterLastname(lastName);
		checkoutPage.enterZipCode(zipCode);
		checkoutPage.clickContinue();
	}
	
	@Step
	public void finishOrder() {
		checkoutPage.clickFinish();
	}
	
	@Step
	public void assertOrder() {
		checkoutPage.verifyPlacedOrder();
	}

}
