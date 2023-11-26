package com.Functionalities;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class CommonFunctions {

	WebDriver driver;
	
	public static boolean isloadComplete(WebDriver driver)
	{
	    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
	            || ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}
	
	
	public static void main(String[] args) {
		


	}
}
