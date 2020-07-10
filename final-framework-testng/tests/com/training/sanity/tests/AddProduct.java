/*To verify whether application allows admin to create category & add product on the created category*/

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UNF_048POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProduct {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private UNF_048POM addproduct;
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		addproduct=new UNF_048POM(driver);
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
    public void addProductTest() throws Exception {
	
		addproduct.Catalog();//Click on Catalog
		addproduct.Categories();//SelectCatagories
		addproduct.AddNew();//Click Add New icon
		addproduct.CategoryName("Sports Uniform");//Enter Valid credentials in Category Name textbox of General tab
		addproduct.DescriptiontextBox("Uniform for Sports");//Enter Valid credentials in Description textbox of General tab
		addproduct.MetaTagTitle("Sports Uniform");//Enter Valid credentials in Meta tag Title textbox of General tab
		addproduct.MetaTagDescription("Uniform for Sports");//Enter Valid credentials in Meta tag Description textbox of General tab
		addproduct.Save();//Success: You have modified categories!
		Thread.sleep(5000);
		addproduct.Catalog();//Click on Catalog
		addproduct.Products();//Select Products
		addproduct.AddNew();//Click Add New icon
		addproduct.ProductName("Sports Wear");//Enter Product name
		addproduct.ProdMetaTag("Sports Wear (8-10)");// Enter Product Meta Tag
		Thread.sleep(3000);
		addproduct.ProdDataTag();//Click on Data tag
		addproduct.Model("SPU-03");//Enter Model
		addproduct.ProdLinkTab();//click Link Tab
		addproduct.ProdCategories("Sports Uniform");//Select category as "Sports Uniform"
		Thread.sleep(3000);
		addproduct.Save();//Save
		
		
	}
}
