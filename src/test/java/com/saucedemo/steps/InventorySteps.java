package com.saucedemo.steps;

import com.saucedemo.pages.InventoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class InventorySteps extends ScenarioSteps {
	
	InventoryPage inventoryPage;
	
	@Step
	public void applyFilter(String filter) {
		inventoryPage.selectFilter(filter);		
	}
	
	@Step
	public void addToCart() {
		inventoryPage.addProductToCart();		
	}
	
	@Step
	public void getCart() {
		inventoryPage.getCart();
	}

}
