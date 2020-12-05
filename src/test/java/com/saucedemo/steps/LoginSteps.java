package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {
	
	LoginPage loginPage;
	@Step
	public void loginToTheApplication(String username, String password) {
		try {
			loginPage.launchApplication();
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
			loginPage.clickLogin();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
