package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Functionalities.CommonFunctions;
import com.pages.HomePage;
import com.pages.LoginPage;

import dataproviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class logintest {
	ConfigFileReader configFileReader;
	CommonFunctions commonFn=new CommonFunctions();
	HomePage homePage= new HomePage();
	LoginPage loginPage=new LoginPage();
	private String sTestCaseName;

	private int iTestCaseRow;
	
	WebDriver driver;
	
	 @BeforeTest
	    public void testBrowser() {
		 configFileReader= new ConfigFileReader();
	       WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();   
	        driver.manage().window().maximize();
	        String url = configFileReader.getApplicationUrl();
	        
	       driver.get(url);
	         //CommonFunctions.isloadComplete(driver);
	        
	    }

	 @Test(dataProvider="Authentication")
	 public void testcase() throws Exception {
		 //verify Phone Number
		 homePage.verifyPhoneNumber();
		 
		 homePage.clickSignIn();
		 
		 loginPage.verifyLoginUrl();
		 
	 }
	 
	 @DataProvider(name = "data")
	  public Object[][] dataSupplier() throws IOException {
	    File file = new File("details.xlsx");
	    FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheetAt(0);
	    wb.close();
	    int lastRowNum = sheet.getLastRowNum() ;
	    int lastCellNum = sheet.getRow(0).getLastCellNum();
	    Object[][] obj = new Object[lastRowNum][1];
	    for (int i = 0; i < lastRowNum; i++) {
	      Map<Object, Object> datamap = new HashMap<>();
	      for (int j = 0; j < lastCellNum; j++) {
	        datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
	      }
	      obj[i][0] = datamap;
	    }
	    return  obj;
	  }
	 
	 @AfterTest
	 public void closeTest() {
		 driver.quit();  
	 }
}
