package Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class UMSPage extends HelperFunctions {
	public UMSPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		} 
	
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="(//button[.='Add User'])[2]")
	private WebElement addUser;
	
	@FindBy(xpath="(//button[.='Add User'])[1]")
	private WebElement addUser2;
	
	@FindBy(xpath="//input[@name='emailAddress']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="(//div[@class='ap-field-validation-error ng-star-inserted'])[position()=1]")
	private WebElement firstErrorMessage;
	
	@FindBy(xpath="(//div[@class='ap-field-validation-error ng-star-inserted'])[position()=2]")
	private WebElement secondErrorMessage;
	
	@FindBy(xpath="(//div[@class='ap-field-validation-error ng-star-inserted'])[position()=3]")
	private WebElement thirdErrorMessage;
	
	@FindBy(xpath="(//i[@alt='toggle icon'])[1]")
	private WebElement selectUserLevel;
	
	@FindBy(xpath="//label[.='User']")
	private WebElement userLabel;
	
	@FindBy(xpath="//label[.='Admin']")
	private WebElement adminLabel;
	
	@FindBy(xpath="(//i[@alt='toggle icon'])[2]")
	private WebElement selectProducts;
	
	@FindBy(xpath="//div[@class='ap-dropdown-select disabled']")
	private WebElement selectProducts2;
	
	@FindBy(xpath="//div[@class='ap-checkbox']")
	private static List<WebElement> checkBoxes;
	
	@FindBy(xpath="//label[@class='ap-option-label']")
	private static List<WebElement> checkBoxes2;
	
	@FindBy(xpath="(//mat-expansion-panel-header[starts-with(@id, \"mat-expansion-panel-header\")])[2]")
	private WebElement checkProducts;
	
	@FindBy(xpath="(//span[.='Product 2'])[1]")
	private WebElement product2;
	

	
	@FindBy(xpath="/html/body/app-root/app-ums-landing/html/body/div/div[1]/div[3]/mat-accordion/mat-expansion-panel/div/div/table[2]/tr[2]/td[4]/button")
	private WebElement otherProductUsers;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchUsers;
	
	@FindBy(xpath="//span[.=' close']")
	private WebElement closeUsers;
	
	@FindBy(xpath="//div[@class='cdk-virtual-scroll-content-wrapper']//tbody//tr//td")
	private static List<WebElement> allUsers;
	
	@FindBy(xpath="(//table[@class='ng-tns-c58-13'])[2]//td[3]")
	private static List<WebElement> features;
	
	@FindBy(xpath="(//table[@class='ng-tns-c58-13'])[2]//td[2]")
	private static List<WebElement> products;
	
	@FindBy(xpath="((//table[starts-with(@class, \"ng-tns\")])[9])//tr")
	private static List<WebElement> productsRows;
	
	@FindBy(xpath="/html/body/app-root/app-ums-landing/html/body/div/div[1]/div[3]/mat-accordion/mat-expansion-panel/div/div/table[2]/tr[1]/td[4]/button")
	private WebElement checkinusers;
	
	@FindBy(xpath="(//span[.='Check-in'])[2]")
	private WebElement checkinTitle;
	
	@FindBy(xpath="//td[@class='emailAdd']")
	private WebElement emailForVerification;
	
	@FindBy(xpath="//div[@class='table ap-table-div']")
	private WebElement resultTable;
	
	
	
	
	
	
	
	static Logger logger=Logger.getLogger("UMSPage");
	ReadXLSdata read1=new ReadXLSdata();
	
	public void setErrorMessages() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		//pass.sendKeys(read1.getCellData("VALUE", 1));
		//submit.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		addUser.click();
		HelperFunctions.staticWait(3);
		if(emailAddress.getText().trim().isEmpty()&&firstName.getText().trim().isEmpty()&&lastName.getText().trim().isEmpty()) {
			boolean a=saveButton.getAttribute("aria-disabled").equals("true");
			Assert.assertTrue(a);
		}
		HelperFunctions.staticWait(3);
		emailAddress.click();
		Faker faker = new Faker();
		emailAddress.sendKeys(faker.internet().emailAddress());
		HelperFunctions.staticWait(3);
		saveButton.click();
		String errorMessage1="First name is required";
		String errorMessage2="Last name is required";
		String errorMessage3="User level selection is required";
		//Assert.assertEquals(firstErrorMessage.getText(), errorMessage1);
		if (!firstErrorMessage.getText().equals(errorMessage1)) {
	           String errorMessage = "Error message does not appear";
	             logger.error(errorMessage);
	             throw new Exception(errorMessage);
	       }else {
	           String successMessage = "Error message appears";
	             logger.info(successMessage);
	       } 
		//Assert.assertEquals(secondErrorMessage.getText(), errorMessage2);
		if (!secondErrorMessage.getText().equals(errorMessage2)) {
	           String errorMessage = "Error message does not appear";
	             logger.error(errorMessage);
	             throw new Exception(errorMessage);
	       }else {
	           String successMessage = "Error message appears";
	             logger.info(successMessage);
	       } 
		//Assert.assertEquals(thirdErrorMessage.getText(), errorMessage3);
		if (!thirdErrorMessage.getText().equals(errorMessage3)) {
	           String errorMessage = "Error message does not appear";
	             logger.error(errorMessage);
	             throw new Exception(errorMessage);
	       }else {
	           String successMessage = "Error message appears";
	             logger.info(successMessage);
	       } 
		
		
		
		
		
	}
	public void setAssigningMultipleProducts() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		//pass.sendKeys(read1.getCellData("VALUE", 1));
		//submit.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		addUser.click();
		HelperFunctions.staticWait(3);
		emailAddress.click();
		emailAddress.sendKeys(read1.getCellData("VALUE", 24));
		firstName.click();
		firstName.sendKeys(read1.getCellData("VALUE", 25));
		lastName.click();
		lastName.sendKeys(read1.getCellData("VALUE", 26));
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		for(WebElement each:checkBoxes) {
			each.click();	
		}
		for(WebElement each:checkBoxes) {
		Assert.assertTrue(each.isSelected());
		}
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
           executor.executeScript("arguments[0].click();", saveButton);
		//saveButton.click();
		//String actualUrl=Driver.getDriver().getCurrentUrl();
		//System.out.println(Driver.getDriver().getCurrentUrl());
		//String expectedUrl="https://ums-productcentral-qa.pwc.com/home";
		//Assert.assertEquals(actualUrl,expectedUrl);
		
		
		
		
		
		
	}
	
	public void setAdminForMultipleCompanies() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		//pass.sendKeys(read1.getCellData("VALUE", 1));
		//submit.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		addUser.click();
		HelperFunctions.staticWait(3);
		emailAddress.click();
		HelperFunctions.staticWait(3);
		emailAddress.sendKeys(read1.getCellData("VALUE", 24));
		HelperFunctions.staticWait(3);
		firstName.click();
		HelperFunctions.staticWait(3);
		firstName.clear();
		firstName.sendKeys(read1.getCellData("VALUE", 25));
		HelperFunctions.staticWait(3);
		lastName.click();
		HelperFunctions.staticWait(3);
		lastName.clear();
		HelperFunctions.staticWait(3);
		lastName.sendKeys(read1.getCellData("VALUE", 26));
		HelperFunctions.staticWait(3);
		selectUserLevel.click();
		HelperFunctions.staticWait(3);
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		for(WebElement each:checkBoxes) {
			each.click();	
			break;
		}
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		 JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
         executor.executeScript("arguments[0].click();", saveButton);
		//saveButton.click();
		//String actualUrl=Driver.getDriver().getCurrentUrl();
		//System.out.println(Driver.getDriver().getCurrentUrl());
		//String expectedUrl="https://ums-productcentral-qa.pwc.com/home";
		//Assert.assertEquals(actualUrl,expectedUrl);
		HelperFunctions.staticWait(3);
		addUser2.click();
		HelperFunctions.staticWait(3);
		emailAddress.click();
		HelperFunctions.staticWait(3);
		emailAddress.sendKeys(read1.getCellData("VALUE", 24));
		HelperFunctions.staticWait(3);
		firstName.click();
		HelperFunctions.staticWait(3);
		firstName.clear();
		firstName.sendKeys(read1.getCellData("VALUE", 25));
		HelperFunctions.staticWait(3);
		lastName.click();
		HelperFunctions.staticWait(3);
		lastName.clear();
		HelperFunctions.staticWait(3);
		lastName.sendKeys(read1.getCellData("VALUE", 26));
		HelperFunctions.staticWait(3);
		selectUserLevel.click();
		HelperFunctions.staticWait(3);
		userLabel.click();
		HelperFunctions.staticWait(3);
		/*selectProducts.click();
		for(WebElement each:checkBoxes) {
			each.click();	
			break;
		}
		selectProducts.click();
		HelperFunctions.staticWait(3);
		saveButton.click();
		Assert.assertEquals(actualUrl,expectedUrl);*/
		
		HelperFunctions.staticWait(3);
		 JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", saveButton);
		
		
		
	}
	
	
	
	
	
	public void setAdminRights() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		//pass.sendKeys(read1.getCellData("VALUE", 1));
		//submit.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		addUser.click();
		HelperFunctions.staticWait(3);
		emailAddress.click();
		emailAddress.sendKeys(read1.getCellData("VALUE", 24));
		firstName.click();
		firstName.sendKeys(read1.getCellData("VALUE", 25));
		lastName.click();
		lastName.sendKeys(read1.getCellData("VALUE", 26));
		selectUserLevel.click();
		adminLabel.click();
		HelperFunctions.staticWait(3);
		boolean a=selectProducts2.getAttribute("class").equals("ap-dropdown-select disabled");
		Assert.assertTrue(a);
		
		
		
		
		
		
	}
	public void setDisplayingContentBasedOnLicence() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		read1.setExcelFile("./testdata.xlsx", "STG");
		email.sendKeys(read1.getCellData("VALUE", 44));
		next.click();
		//pass.sendKeys(read1.getCellData("VALUE", 1));
		//submit.click();
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(3);
		addUser.click();
		HelperFunctions.staticWait(3);
		String email="admin@gmail.com";
		emailAddress.click();
		emailAddress.sendKeys(email);
		firstName.click();
		firstName.sendKeys("adminadmin");
		lastName.click();
		HelperFunctions.staticWait(3);
		lastName.clear();
		lastName.sendKeys("company");
		selectUserLevel.click();
		userLabel.click();
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		for(int i=0;i<checkBoxes2.size();i++) {
			if(checkBoxes2.get(i).getText().equalsIgnoreCase("Check-in")) {
				checkBoxes2.get(i).click();
			}
		}
		HelperFunctions.staticWait(3);
		selectProducts.click();
		HelperFunctions.staticWait(3);
		 JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
	        executor3.executeScript("arguments[0].click();", saveButton);
		//saveButton.click();
	
		HelperFunctions.staticWait(3);
		checkProducts.click();
		HelperFunctions.staticWait(3);
		JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
	    js.executeScript("arguments[0].scrollIntoView(true);", checkinTitle);
	    HelperFunctions.staticWait(3);
	    checkinusers.click();
	    HelperFunctions.staticWait(3);
	    searchUsers.click();
	    searchUsers.sendKeys(email);
	    HelperFunctions.staticWait(3);
	    String actualUser=emailForVerification.getText();
	  //  Assert.assertEquals(actualUser, email);
	    if (!actualUser.equals(email)) {
	           String errorMessage = "Email verification failed";
	             logger.error(errorMessage);
	             throw new Exception(errorMessage);
	       }else {
	           String successMessage = "Email verification is successful";
	             logger.info(successMessage);
	       } 
	    HelperFunctions.staticWait(3);
	    closeUsers.click();
	    HelperFunctions.staticWait(3);
		checkProducts.click();
		HelperFunctions.staticWait(3);
		JavascriptExecutor js2 = ((JavascriptExecutor) Driver.getDriver());
	    js2.executeScript("arguments[0].scrollIntoView(true);", otherProductUsers);
	    HelperFunctions.staticWait(3);
	    otherProductUsers.click();
	    HelperFunctions.staticWait(3);
	    searchUsers.click();
	    searchUsers.sendKeys(email);
	    HelperFunctions.staticWait(3);
	//    Assert.assertTrue(resultTable.getText().isBlank());
	    Assert.assertFalse(resultTable.getText().equalsIgnoreCase(email));
		
			
	}
	

	
	

}
