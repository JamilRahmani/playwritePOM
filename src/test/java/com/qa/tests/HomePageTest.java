package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;
import com.qa.factory.PlaywrightFactory;
import com.qa.pages.HomePage;

public class HomePageTest extends BaseTest {
	
	
	
	@Test
	public void homePageTitleTest(){
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void homePageURLTest(){
		String actualTitle = homePage.getHomePageURL();
		Assert.assertEquals(actualTitle, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getProductData(){
		return new Object[][] {
			{"Mackbook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	
	@Test(dataProvider = "getProductData")
	public void searchTest(String productName){
		
		String actualSearchHeader= homePage.doSearch(productName);
		Assert.assertEquals(actualSearchHeader, "Search - "+ productName);
	}
	
	

	

}
