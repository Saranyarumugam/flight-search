package com.spicejet;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spicejet.Base;
import com.spicejet.Search;

public class SearchFlights extends Base{
	
	public WebDriver driver;
	
	//initialize browser & open Url
	@BeforeMethod
	public void openBrowser() throws IOException {
		driver = initializeDriver();
		
	}

	//Test Oneway flight search
	@Test
	public void oneWayTravel() throws IOException {
		Search search = new Search(driver);
		search.travelType("oneway");
		search.departureCity("MAA");
		search.destinationCity("DEL");
		search.travelMonth("July");
		search.departureDate("10");
		search.passengerCount("3");
		search.flightSearch();
		getScreenShot("oneWayResult");
	}
	
	//Test Roundtrip flight search
	@Test
	public void roundTravel() throws IOException {
		Search search = new Search(driver);
		search.travelType("rountrip");
		search.departureCity("MAA");
		search.destinationCity("DEL");
		search.travelMonth("July");
		search.departureDate("10");
		search.returnDate("20");
		search.passengerCount("4");
		search.flightSearch();
		getScreenShot("ReturnResult");
	}
	
	//close browser after test
	@AfterMethod
	
	public void closBrowser() {
		driver.close();
	}
}
