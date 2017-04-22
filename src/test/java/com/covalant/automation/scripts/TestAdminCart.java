package com.covalant.automation.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.covalant.automation.pages.AdminLoginPage;
import com.covalant.automation.pages.AppLoginPage;
import com.covalant.automation.pages.CartPage;
import com.covalant.automation.pages.DashboardPage;
import com.covalant.automation.pages.HomePage;

public class TestAdminCart extends BaseTestCase {

	
	public HomePage homePage ;
	public CartPage cartPage ;
	public AppLoginPage appLoginPage;
	public AdminLoginPage adminLoginPage;
	public DashboardPage dashboardPage;
	
	@Test
	public void testAdminProduct(){
		
		homePage = new HomePage();
		homePage.openApp();
		homePage.clickOnShoppingcart();
		
		cartPage = new CartPage();
		String actual = cartPage.getCartMessage();
		String expected = "Your shopping cart is empty!";	
		Assert.assertEquals(actual, expected);
		
		homePage.openAppLoginPage();
		
		appLoginPage = new AppLoginPage();
		appLoginPage.login_app(appUser, appPass);
		
		String actualError = appLoginPage.getErrorMessage();
		String expectedError = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualError, expectedError);
		
		
		homePage.openAdminurl();
		
		adminLoginPage = new AdminLoginPage();
		adminLoginPage.login(user, pass);
		
		dashboardPage = new DashboardPage();
		String actualOrders = dashboardPage.getOrdersNumber();
		String expectedOrders = "0";
		
		Assert.assertEquals(actualOrders, expectedOrders);
	}
}
