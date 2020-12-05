package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CartSteps extends ScenarioSteps {
	
	CartPage cartPage;
	
	@Step
	public void proceedCheckout() {
		cartPage.assertInventoryName();
		cartPage.clickCheckout();
	}
	
	@Step
	public void goToProduct() {
		cartPage.clickProduct();
	}

}
