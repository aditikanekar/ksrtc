package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
	
	By username =By.xpath("//*[text()=\"User Name\"]");
	
	By password =By.xpath("//*[text()=\"Password\"]");
	
	By loginButton=By.xpath("//*[@id=\"submitBtn\"]");
	
	public void verifyLoginUrl() {
	     Assert.assertEquals("https://ksrtc.in/oprs-web/login/show.do", driver.getCurrentUrl());
	        
	 	
	}
	
}
