package com.spicejet;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search extends Base{
	
	public WebDriver driver;
	public Search(WebDriver driver) {
		this.driver = driver;
	}
	//select Travel type
	public void travelType(String type) {
		
		if (type == "oneway") {			
			driver.findElement(By.xpath("//input[@value='OneWay']")).click();
			}
		else if (type =="roundtrip") {
			driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
		}
		else if(type =="multicity") {
			driver.findElement(By.xpath("//input[@value='TripPlanner']")).click();
		}
	}
	
	//Enter Departure City
	public void departureCity(String City) {
		driver.findElement(By.xpath("//input[contains(@id,'originStation1')]")).sendKeys(City);
	}
	
	//Enter Arrival City
	public void destinationCity(String City) {
		driver.findElement(By.xpath("(*//a[@value='"+City+"'])[2]")).click();
	}
	
	//Enter Travel Month
	public void travelMonth(String month) {
		driver.findElement(By.cssSelector("input[id$='view_date1']")).click();
		while(!driver.findElement(By.className("ui-datepicker-month")).getText().contains(month)) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
	}
	
	//Enter Departure Date
	public void departureDate(String Date) {
		List<WebElement> dates = driver.findElements(By.className("ui-state-default"));
		int count = dates.size();
		for(int i=0;i<count;i++) {
			String day = dates.get(i).getText();
			if (day.equalsIgnoreCase(Date)) {
				dates.get(i).click();
				break;
			}
		}
	}

	//Enter Return Date
	public void returnDate(String Date) {
		driver.findElement(By.cssSelector("input[id$='view_date2']")).click();
		List<WebElement> dates1 = driver.findElements(By.className("ui-state-default"));
		int count1 = dates1.size();
		for(int i=0;i<count1;i++) {
			String day1 = dates1.get(i).getText();
			if (day1.equalsIgnoreCase(Date)) {
				dates1.get(i).click();
				break;
			}
		}
	}
	//Enter Passenger count
		public void passengerCount(String count) {
			driver.findElement(By.id("divpaxinfo")).click();			
			driver.findElement(By.id("adultDropdown")).click();
			driver.findElement(By.cssSelector("[value='"+count+"']")).click();
		    driver.findElement(By.id("divpaxinfo")).click();
		    	}
		
	//Search for Flights
		public void flightSearch() {
			driver.findElement(By.cssSelector("input[type='submit']")).click();
		}
}
