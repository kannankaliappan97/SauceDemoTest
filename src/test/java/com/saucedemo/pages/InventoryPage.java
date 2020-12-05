package com.saucedemo.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class InventoryPage extends PageObject{
	public static String inventoryName;
	
	@FindBy(className="product_sort_container")
	WebElement lstFilter;

	@FindBy(xpath=".//*[@class='btn_primary btn_inventory']")
	List<WebElement> btnAddToCart;
	
	@FindBy(xpath=".//*[@class='btn_primary btn_inventory']//preceding::div[@class='inventory_item_name']")
	List<WebElement> lblProductName;
	
	@FindBy(xpath=".//*[@data-icon='shopping-cart']")
	WebElement btnCart;
	
	public void selectFilter(String filter) {
		try {
			selectFromDropdown(lstFilter, filter.trim());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addProductToCart() {
		try {
			int len = btnAddToCart.size();
			for(int i=0; i<len;) {
				inventoryName = lblProductName.get(i).getText();
				clickOn(btnAddToCart.get(i));
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getCart() {
		try {
			clickOn(btnCart);
			String url = getDriver().getCurrentUrl();
			assertEquals("https://www.saucedemo.com/cart.html", url);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
