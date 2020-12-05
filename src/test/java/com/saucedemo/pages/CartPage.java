package com.saucedemo.pages;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {

	@FindBy(linkText="REMOVE")
	WebElement btnRemove;
	
	@FindBy(linkText="Continue Shopping")
	WebElement btnContinue;
	
	@FindBy(linkText="CHECKOUT")
	WebElement btnCheckout;
	
	@FindBy(className="inventory_item_name")
	public static WebElement lblName;
	
	public static void assertInventoryName() {
		try {
			String nameAtCart = lblName.getText();
			assertEquals(InventoryPage.inventoryName, nameAtCart);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickCheckout() {
		try {
			clickOn(btnCheckout);
			String url = getDriver().getCurrentUrl();
			assertEquals("https://www.saucedemo.com/checkout-step-one.html", url);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickProduct() {
		try {
			clickOn(lblName);
			String url = getDriver().getCurrentUrl();
			Assert.assertThat(url, CoreMatchers.containsString("https://www.saucedemo.com/inventory-item.html?"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
