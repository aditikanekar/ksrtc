package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
By singInButton=By.xpath("//*[text()=\" Sign In\"]");

By phoneNumber=By.xpath("//*[text()=\"080-26252625\"]");

WebDriver driver ;
public void verifyPhoneNumber() {
	Assert.assertTrue(driver.findElement(phoneNumber).isDisplayed());
}

public void clickSignIn() {
	driver.findElement(singInButton).click();
}

}
