package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UNF_046POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangeOrder {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private UNF_046POM changeorder;
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		changeorder=new UNF_046POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}
   @Test(priority=2)
   public void changeOrderTest() throws Exception{
	   changeorder.clickCart();//Clicking on Cart
	   changeorder.clickOrder();//clicking on order link
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   changeorder.selectOrdernum();//Selecting the order
	   Thread.sleep(3000);
	   changeorder.clickEdit();//Click on Edit icon
	   Thread.sleep(3000);
	   changeorder.continuecustomer();//Click on Continue button
	   changeorder.removeorder();////remove Order
	   Thread.sleep(3000);
	   changeorder.chooseProduct("SPORTS T-SHIRTS");//Choose Product
	   Thread.sleep(3000);
	   changeorder.EnterQuantity("1");//EnterQuantity
	   changeorder.AddProduct();//Add Product
	   Thread.sleep(3000);
	   changeorder.Continue1();//Continue cart
	   changeorder.paymentAddress();//Continue payment address
	   changeorder.shippingAddress();//shipping address
	   changeorder.SaveCart(); //Save Cart
	   
   }

}
