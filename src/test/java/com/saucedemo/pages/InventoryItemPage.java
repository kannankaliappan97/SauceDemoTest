package com.saucedemo.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class InventoryItemPage extends PageObject {
	
	public By btnRemove = By.xpath(".//button[text()='REMOVE']");

	@FindBy(xpath=".//button[text()='<- Back']")
	WebElement btnBack;
	
	public void verifyRemoveButton() {
		try {
			boolean blgFlag = isElementVisible(btnRemove);
			assertTrue(blgFlag);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
