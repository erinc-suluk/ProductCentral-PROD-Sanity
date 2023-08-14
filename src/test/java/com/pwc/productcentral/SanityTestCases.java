package com.pwc.productcentral;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.AuthoringPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.HomePageTemplatePage;
import Pages.LegalPage;
import Pages.LoginPageObjects;

import Pages.ProductListingPage;
import Pages.ProductPage;
import Pages.ResellerPage;
import Pages.SecurityPage;
import Pages.UMSPage;


public class SanityTestCases extends BasePage {
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	public static ConfigurationsReader read;
	String platform = null;
	LoginPageObjects lpo=new LoginPageObjects();
	HomePage hp=new HomePage();
	ProductListingPage plp=new ProductListingPage();
	HomePageTemplatePage hpt=new HomePageTemplatePage();
	ResellerPage rp=new ResellerPage();
	LegalPage lp=new LegalPage();
	SecurityPage sp=new SecurityPage();
	ProductPage pp=new ProductPage();
	AuthoringPage ap=new AuthoringPage();
	UMSPage ums=new UMSPage();
	screenshotUtil ssu=new screenshotUtil();
	private ExtentTest test;
	
	
	
	Logger logger=Logger.getLogger("SanityTestCases");
	
	ReadXLSdata read1=new ReadXLSdata();
	
	


	
	@BeforeSuite
	public void setUp() {
		 PropertyConfigurator.configure(".\\log4j.properties");
		 read = new ConfigurationsReader();
		 platform = read.getPlatform();
		 read.platformName();
		 String reportFilePrefix="Sanity Automation Report for Product Central";
		 File[] files=new File(".").listFiles((dir,name)->name.startsWith(reportFilePrefix));
		 if(files!=null) {
			 for(File file: files) {
				 file.delete();
			 }
		 }
		 String reportFileName=reportFilePrefix + ".html";
		 htmlReporter = new ExtentHtmlReporter(reportFileName);
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	    
	     
	}
		
	@BeforeMethod
	public void initTest() throws Exception {
	    Driver.getDriver();
	    read1.setExcelFile("./testdata.xlsx", "PRO");
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().deleteAllCookies();
		HelperFunctions.setWaitTime();
		
		
	}
	
	
	/*******************************************************Sanity Test Case********************************************************/
	
	
	
	
	
	@Test
	public void WEB_1() throws Exception{
		String testName = "Verify the user should see different footer items if logged in";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 2));
            pp.setFooterWithoutLogin(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_2() throws Exception{
		String testName = "Verify the user should see different footer items if logged in";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin3();
    	    pp.setFooterWithLogin(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	

	
	@Test
	public void WEB_3() throws Exception{
		String testName = "Verify when the user clicks on any item the specified asset/page must be loaded in the new tab";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setNewTabAssets(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	
	@Test
	public void WEB_4() throws Exception{
		String testName = "Verify if user is logged in, then My Products heading in the sitemap is visible";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setMyProductSitemap(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_5() throws Exception{
		String testName = "Verify the tags accompany the items which are assets";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setTagsAccompany(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_6() throws Exception{
		String testName = "Verify that this page should appear to all Site Visitors that are logged in but do not have the right level of permissions to access the page";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setErrorPage(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_7() throws Exception{
		String testName = "Verify there are 2 filters with minor differences between Global and My Products search";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setMyProductSearch(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_8() throws Exception{
		String testName = "Verify the all resources component is presenting a list of 5 assets that are relevant to the product on the product landing page";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setResourcesBasedonProducts(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	
	
	
	@Test
	public void WEB_9() throws Exception{
		String testName = "Verify all the sections on the header";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    BasePage.setAllSectionsOnHeader(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_10() throws Exception{
		String testName = "Verify the scroll functionality";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    BasePage.setScrollFunctionality(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	@Test
	public void WEB_11() throws Exception{
		String testName = "Verify on clicking 'login to my products' tile the user is navigated to the PC login page";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setLoginToMyProductLink(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	
	@Test
	public void WEB_12() throws Exception{
		String testName = "Verify the filter does not support multi-select";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setNotSupportMultiSelect(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	
	@Test
	public void WEB_13() throws Exception{
		String testName = "Verify the pages does not have broken images";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            BasePage.setAllImages(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_14() throws Exception{
		String testName = "Verify on click on load more, another 5 assets must be loaded";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setLoadMoreButton(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	
	
	@Test
	public void WEB_15() throws Exception{
		String testName = "Verify that dropdown list will display the Product & document category as per the latest Tag taxonomy document";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 2));
            hp.setDropdownList();
    	    hp.setDropdownList2(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_16() throws Exception{
		String testName = "Verify that pagination is removed from My resources section on My products template";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
    	    pp.setDisplayResources(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_17() throws Exception{
		String testName = "Verify last updated date will also be reflected under the title";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setDateFormat(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	

	@Test
	public void WEB_18() throws Exception{
		String testName = "Breadcrumb must be visible to user";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 9));
            lp.setBreadcrumb(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	
	@Test
	public void WEB_19() throws Exception{
		String testName = "Verify clicking on the tile will navigate the user to the content page in the same tab";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 6));
            plp.setContentPageSameTab(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_20() throws Exception{
		String testName = "Verify that the value of the filters are based on the tags/properties of the search results";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setSearchResult(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_21() throws Exception{
		String testName = "Verify that page title is visible on page and it displays the name of the product";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 8));
            rp.setPageTitleAndProducts(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	
	@Test
	public void WEB_22() throws Exception{
		String testName = "Verify the content pages will be tagged accordingly";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 9));
            lp.setContentPageTags(test); 
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_23() throws Exception{
		String testName = "Verify document tile can have 3 lines of description";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 42));
            lp.setDescriptionOfTiles(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
		
	}
	
	@Test
	public void WEB_24() throws Exception{
		String testName = "Verify display a tile per document category";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 42));
            lp.setDisplayTilePerDocumentCat(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	
	@Test
	public void WEB_25() throws Exception{
		String testName = "Verify that user entered keyword remains into search bar either user select suggested product name or not & submitted keyword doesn't match any result";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 14));
            plp.setSearchBarKeywordforNegativeTest(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	
	}
	@Test
	public void WEB_26() throws Exception{
		String testName = "User clicks on the sort by the filter, the user must see two options in the dropdown I,e 1- A-Z "
				+ "(arranges products in ascending order) 2- Z-A (arranges products in descending order)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 42));
	        lp.setFilterOptions(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_27() throws Exception{
		String testName = "Verify breadcrumbs will be populated based on the site hierarchy.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setBreadcrumbsHierarchy(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_28() throws Exception{
		String testName = "Verify this component must contain a link/button for my product page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setAllProductsButtonFunctionality(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
    public void WEB_29() throws Exception{
        String testName = "Verify that the Component is accessibility compliant ";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 47));
            plp.setRelatedLinkSize(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	
	
	
	@Test
    public void WEB_30() throws Exception{
        String testName = "Verify that the user clicks on the profile avatar";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            pp.setClickAvatar(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
    public void WEB_31() throws Exception{
        String testName = "Verify if the user is on PC Homepage and clicks on the pwc logo the PC Homepage should be loaded.";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setOpenHomePagePwcLogo(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
    public void WEB_32() throws Exception{
        String testName = "Verify if the user is login the homepage is their My Product Page.";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            hp.setOpenMyProductPagePwcLogo();
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
    public void WEB_33() throws Exception{
        String testName = "Verify banner is displayed below the global header on a page and is sticky as the user scrolls down";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            pp.setBannerSticky(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	@Test
    public void WEB_34() throws Exception{
        String testName = "Verify end user is able to close the banner using keyboard";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            pp.setBannerClose(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
	
	
	
    @Test
    public void WEB_35() throws Exception{
        String testName = "Verify that when user logs in ,the user should be redirected to the asset they were trying to access";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            pp.setMyProductPageAccessibility(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
    @Test
    public void WEB_36() throws Exception{
        String testName = "Verify that all the content that is within the myproducts (including assets) should not be accessible to the user w/o authentication.";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            //lpo.setLogin2();
            pp.setDocumentsAccesibility(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
    @Test
    public void WEB_37() throws Exception{
        String testName = "Verify that within the modal an eyeball icon is displayed in the product that matches the Site Visitor's current MyProduct product page";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            lpo.setLogin2();
            pp.setFirstTabActive(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
        
    }
   
   
    @Test
	public void WEB_38() throws Exception{
		String testName = "Verify clicking on the tile will navigate the user to the content page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setNavigateContentPage(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
    @Test
	public void WEB_39() throws Exception{
		String testName = "verify on clicking collapsed the left nav should return to its original state, "
				+ "where the user can see the icon/image and the verbiage for the items in the left nav.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseButtonImg(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
    @Test
	public void WEB_40() throws Exception{
		String testName = "Verify that when user click on collapse icon under the left nav,then left nav will collapse and only the icons/image for each item will appear";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseButtonImg(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
    @Test
	public void WEB_41() throws Exception{
		String testName = "Verify that when user click on collapse icon then left navigation component name will be collapsing and after click then expanding";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        BasePage.setCollapseExpandButton(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
    @Test
	public void WEB_42() throws Exception{
		String testName = "Verify the product title and description are visible to the users of the page/site";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 47));
	        plp.setProductTitleandDescriptionVisibility(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
    @Test
	public void WEB_43() throws Exception{
		String testName = "Verify the user is able to see view less button";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setViewLessButton(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
   
	@Test
	public void WEB_44() throws Exception{
		String testName = "Verify document tile can have only 2 line product name anything more than that will be truncated (fit to size )";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.set2LineProductName(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	
	@Test
	public void WEB_45() throws Exception{
		String testName = "Verify that the PDF Viewer to support upgrade of PDF";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 14));
	        plp.setUpgradePDF(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	
	@Test
	public void WEB_46() throws Exception{
		 String testName = "Verify that the title bumps up on the tile replacing the category label.";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setReplacingCategoryLabel(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_47() throws Exception{
		 String testName = "Verify these assets are tagged with appropriate PC docs category tag value";
		    ExtentTest test = extent.createTest(testName);

		    try {
		        Driver.getDriver().get(read1.getCellData("VALUE", 15));
		        lpo.setLogin2();
		        pp.setAssetsTag(test);
		        test.pass("Test passed");
		    } catch (Exception e) {
		        String screenshotPath = takeScreenshot(testName);
		        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		    }
		    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
		        Assert.fail("Test case failed: " + testName);
		    }
		
	}
	@Test
	public void WEB_48() throws Exception{
		String testName = "Verify My products tile will contain a ‘login to my products’ tile";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setTilesHasLoginLink(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_49() throws Exception{
		String testName = "Verify that icon allow expand and collapse and it moves to the bottom";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        hp.setItemsinNeedHelpExpandCollapse(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_50() throws Exception{
		String testName = "Verify the extension for documents.Pdfs, videos file types to be considered.";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setAllResourcesContent(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_51() throws Exception{
		String testName = "Verify that Preferences are only available to logged in users";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setPreferencesModal(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
	
	}
	@Test
	public void WEB_52() throws Exception{
		String testName = "Verify that flow is same in legal for security";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 11));
            sp.setSecurityTiles(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	

	@Test
	public void WEB_53() throws Exception{
		String testName = "Verify on selection, the results are automatically sorted";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 15));
            hp.setSortedResult(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	
	@Test
	public void WEB_54() throws Exception{
		String testName = "Verify that on selection a result, display the relevant product on the page";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 6));
            plp.setSearchBox(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	
	@Test
	public void WEB_55() throws Exception{
		String testName = "Verify that search results are based on keywords";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 6));
            plp.setSearchResult(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	
	@Test
	public void WEB_56() throws Exception{
		String testName = "Verify that no change to the home page or side nav";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 11));
            BasePage.setLeftNavigationItems2(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	
	@Test
	public void WEB_57() throws Exception{
		String testName = "Verify the filter will be a dropdown which will display the My products document categories matching the search results";
        ExtentTest test = extent.createTest(testName);

        try {
            Driver.getDriver().get(read1.getCellData("VALUE", 11));
            hp.setDropdown(test);
            test.pass("Test passed");
        } catch (Exception e) {
            String screenshotPath = takeScreenshot(testName);
            test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
            Assert.fail("Test case failed: " + testName);
        }
	}
	
	@Test
	public void WEB_58() throws Exception{
		String testName = "Verify that author can add maximum 55 Characters (3lines) in the title";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setHeroLines(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_59() throws Exception{
		String testName = "Verify that when user clicks on the video result, it'll open the video player on the same page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 15));
	        lpo.setLogin2();
	        pp.setClickVideo(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_60() throws Exception{
		String testName = "Verify that privacy hub cookies page support authoring rich text,bullets,numbered lists,links(open in a new tab)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 48));
	        //lpo.setLogin2();
	        BasePage.setPrivacyCookiePageItems(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	@Test
	public void WEB_61() throws Exception{
		String testName = "Verify that privacy hub page support authoring rich text,bullets,numbered lists,links(open in a new tab)";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 49));
	        //lpo.setLogin2();
	        BasePage.setPrivacyPageItems(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	@Test
	public void WEB_62() throws Exception{
		String testName = "Verify that when user clicks on the video result, it'll open the video player on the same page";
	    ExtentTest test = extent.createTest(testName);

	    try {
	        Driver.getDriver().get(read1.getCellData("VALUE", 50));
	        //lpo.setLogin2();
	        BasePage.setPrivacyPageItems(test);
	        test.pass("Test passed");
	    } catch (Exception e) {
	        String screenshotPath = takeScreenshot(testName);
	        test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	    if (test.getModel().getStatus().toString().equalsIgnoreCase("fail")) {
	        Assert.fail("Test case failed: " + testName);
	    }
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	

	
	
	/******************************************************************************************************************************/
	public String takeScreenshot(String screenshotName) throws IOException {
        WebDriver driver = Driver.getDriver();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "C:\\Users\\GLBL_RDP_USER_01\\eclipse-workspace\\ProductCentralProject-STG-SanityAutomation\\screenshots\\" + screenshotName + ".png";
        File target = new File(destination);
        FileUtils.copyFile(source, target);
        return destination;
    }
	public void captureScreenshotAndAddToReport(String testName) throws IOException {
	    String screenshotPath = takeScreenshot(testName);
	    ExtentTest test = extent.createTest(testName);
	    test.addScreenCaptureFromPath(screenshotPath);
	}
	@AfterMethod
    public void closeTabs() {
        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
            	Driver.getDriver().switchTo().window(window);
            	Driver.getDriver().close();
            }
        }
        Driver.getDriver().switchTo().window(currentWindow);
         }
	public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Take screenshot if test method fails
            String screenshotPath = takeScreenshot(result.getName() + "_failed");
            test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            // Take screenshot if test method passes
            String screenshotPath = takeScreenshot(result.getName() + "_passed");
            test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        extent.flush();
    }
	public String captureScreen() throws IOException {
		File dir = new File(".//screenshots");
        if (!dir.exists()) {
            dir.mkdir();
        }
         TakesScreenshot screen = (TakesScreenshot) Driver.getDriver();
            File src = screen.getScreenshotAs(OutputType.FILE);
            String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.png'").format(new Date());
            String dest = "C:\\Users\\GLBL_RDP_USER_01\\eclipse-workspace\\ProductCentralProject-STG-SanityAutomation\\screenshots\\" + fileName;
            System.out.println(dest);
            File target = new File(dest);
            FileUtils.copyFile(src, target);
            return dest;
        
		}

      @AfterSuite
	public void closingBrowser() {
		extent.flush();
		//Driver.closeDriver();
	}
	


	

}