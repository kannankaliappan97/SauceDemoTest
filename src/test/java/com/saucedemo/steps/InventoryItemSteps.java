package com.saucedemo.steps;

import com.saucedemo.pages.InventoryItemPage;
import com.saucedemo.pages.InventoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class InventoryItemSteps extends ScenarioSteps {
	
	InventoryItemPage inventoryItemPage;
	
	@Step
	public void isRemoveExists() {
		inventoryItemPage.verifyRemoveButton();
	}
	
	

}
