package com.saucedemo.stepDef;

import java.util.List;

import com.saucedemo.steps.CartSteps;
import com.saucedemo.steps.CheckoutSteps;
import com.saucedemo.steps.InventoryItemSteps;
import com.saucedemo.steps.InventorySteps;
import com.saucedemo.steps.LoginSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

public class CheckoutStepdef {
	
	@Steps
	LoginSteps loginSteps;
	
	@Steps
	InventorySteps inventorySteps;
	
	@Steps
	CartSteps cartSteps;
	
	@Steps
	CheckoutSteps checkoutSteps;
	
	@Steps
	InventoryItemSteps inventoryItemSteps;

	@Given("User logged into the application using {string} and {string}")
	public void user_logged_into_the_application_using_and(String username, String password) {
		loginSteps.loginToTheApplication(username, password);
	}

	@When("User selects the {string}")
	public void user_selects_the(String filter) {
		inventorySteps.applyFilter(filter);
	}

	@When("User adds the item to cart")
	public void user_adds_the_item_to_cart() {
		inventorySteps.addToCart();
		inventorySteps.getCart();
		cartSteps.proceedCheckout();
	}

	@When("User fills address to finish the checkout")
	public void user_fills_address_to_finish_the_checkout(DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		checkoutSteps.enterAddress(list.get(0).get(1).toString(), list.get(1).get(1).toString(), list.get(2).get(1).toString());
		checkoutSteps.finishOrder();	   
	}
	
	@Then("User should see the success message confirming order is placed")
	public void user_should_see_the_success_message_confirming_order_is_placed() {
		checkoutSteps.assertOrder();
	}

	@When("User clicks an item from cart")
	public void user_clicks_an_item_from_cart() {
		inventorySteps.addToCart();
		inventorySteps.getCart();
		cartSteps.goToProduct();
	}

	@Then("User should see the remove button at the item page")
	public void user_should_see_the_remove_button_at_the_item_page() {
		inventoryItemSteps.isRemoveExists();
	}
}
