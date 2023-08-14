package Pages;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;
import com.pwc.productcentral.ReadXLSdata;

public class AuthoringPage extends HelperFunctions {
	public AuthoringPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//*[@id=\"globalnav-start-home-collection\"]/coral-masonry-item[2]/div")
	private WebElement sites;
	
	@FindBy(xpath="(//div[contains(@title, 'productcentral')])[2]")
	private WebElement productcentral;
	
	@FindBy(xpath="//div[@title='us']")
	private WebElement us;
	
	@FindBy(xpath="//div[@title='en']")
	private WebElement en;
	
	@FindBy(xpath="//coral-columnview-item[@data-foundation-collection-item-id='/content/pc/us/en/products']")
	private WebElement Products;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/products/change-navigator.thumb.48.48.png?ck=']")
	private WebElement ChangeNavigator;
	
	@FindBy(xpath="//button[@class='betty-ActionBar-item cq-siteadmin-admin-actions-edit-activator foundation-collection-action coral-Button--graniteActionBar coral3-Button coral3-Button--quiet']")
	private WebElement edit;
	
	@FindBy(xpath="//h1[.='Fluid Forecast']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/products/change-navigator/jcr:content/root/container/container/title']")
	private WebElement changeProductsTitle;
	
	@FindBy(xpath="(//input[@name='./jcr:title'])[2]")
	private WebElement titleEdit;
	
	@FindBy(xpath="//button[@icon='edit']")
	private WebElement editButton;
	
	@FindBy(xpath="//button[@class='cq-dialog-header-action cq-dialog-submit coral3-Button coral3-Button--minimal']")
	private WebElement checkButton;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/products/change-navigator/jcr:content/root/container/container/text']")
	private WebElement changeNavigatorDescription;
	
	@FindBy(xpath="//div[@class='cq-RichText-editable coral-RichText-editable coral-RichText coral-DecoratedTextfield-input is-edited webkit chrome']")
	private WebElement navigatorDescriptionEdit;
	
	@FindBy(xpath="//button[@class='cq-dialog-header-action cq-dialog-submit coral3-Button coral3-Button--minimal']")
	private WebElement checkButton2;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewButton;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement actualNavigatorTitle;
	
	@FindBy(xpath="//div[@class='cmp-text']")
	private WebElement actualNavigatorDescription;
	
	@FindBy(xpath="(//coral-columnview-column[@data-foundation-layout-columnview-columnid='/content/pc/us/en'])//coral-columnview-item")
	private static List<WebElement> contentOptions;
	
	@FindBy(xpath="//*[@id=\"coral-id-496\"]/div[1]")
	private WebElement automation;
	@FindBy(xpath="//coral-columnview-item[@data-granite-collection-item-id='/content/pc/us/en/automation/my-products']")
	private WebElement myproduct;
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/my-products/fluid-forecast.thumb.48.48.png?ck=']")
	private WebElement fluidForecast;
	
	@FindBy(xpath="(//div[@class='cmp-for-you__tiles'])/a")
	private static List<WebElement> foryouAssets;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5Assets;
	
	@FindBy(xpath="((//div[@class='cmp-for-you__tiles'])/a)[position()=6 or position()=7 or position()=8 or position()=9 or position()=10]")
	private static List<WebElement> last5Assets;
	
	@FindBy(xpath="//button[@id='showMore']")
	private WebElement viewMoreButton;
	
	@FindBy(xpath="//button[@id='showLess']")
	private WebElement viewLessButton;
	
	@FindBy(xpath="//button[@class='granite-collection-create foundation-toggleable-control coral3-Button coral3-Button--primary']")
	private WebElement createButton;
	
	@FindBy(xpath="(//coral-list-item-content[.='Page'])[1]")
	private WebElement pageButton;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/product-listing-page-template-product-central/thumbnail.png']")
	private WebElement productListingPageTemplate;
	
	@FindBy(xpath="//coral-button-label[.='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath="//coral-tab-label[.='Product Central']")
	private WebElement productCentralTab;
	
	@FindBy(xpath="//select[@name='./documentCategory']//option")
	private static List<WebElement> documentCategoryTag;
	
	@FindBy(xpath="(//button[@class='coral-Select-button coral-MinimalButton'])[1]")
	private WebElement documentCategoryTag2;
	
	@FindBy(xpath="(//button[@class='coral-Select-button coral-MinimalButton'])[3]")
	private WebElement productFeatureTag2;
	
	@FindBy(xpath="//button[@class='coral-Select-button coral-MinimalButton is-active is-above']")
	private WebElement portfolioTag2;
	
	@FindBy(xpath="//select[@name='./productFeatureTag']//option")
	private static List<WebElement> productFeatureTags;
	
	@FindBy(xpath="//ul[@class='coral-SelectList is-visible is-below']//li")
	private static List<WebElement> portfolioTags;
	
	@FindBy(xpath="(//button[@role='combobox'])[4]")
	private WebElement portfolioTags2;
	
	@FindBy(xpath="//div[@title='Products']")
	private WebElement products;
	
	@FindBy(xpath="//div[@title='Change Navigator']")
	private WebElement changeNavigatorLink;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=1]")
	private WebElement firstPositionAuthor;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=2]")
	private WebElement secondPositionAuthor;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=3]")
	private WebElement thirdPositionAuthor;
	
	@FindBy(xpath="(((//coral-columnview-column-content[@role='presentation'])[7])//coral-columnview-item)[position()=4]")
	private WebElement forthPositionAuthor;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=1]")
	private WebElement firstTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=2]")
	private WebElement secondTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=3]")
	private WebElement thirdTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=4]")
	private WebElement forthTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=5]")
	private WebElement fifthTitle;
	
	@FindBy(xpath="((//div[@class='cmp-document-tiles'])//div//a)[position()=6]")
	private WebElement sixthTitle;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/products/change-navigator/offering-overview.thumb.48.48.png?ck=1665588252']")
	private WebElement offerinfOverviewImage;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/products/change-navigator/terms---conditions.thumb.48.48.png?ck=']")
	private WebElement termsAndConditionsImage;
	
	@FindBy(xpath="//a[@href='/us/en/products/change-navigator/offering-overview.html']")
	private WebElement offeringOverviewLink;
	
	@FindBy(xpath="((//div[@class='cmp-all-resources__cards-page ap-page-container'])//div//a)[position()=1 or position()=2 or position()=3 or position()=4 or position()=5]")
	private static List<WebElement> first5resources;
	
	@FindBy(xpath="((//coral-columnview-column-content[@role='presentation'])[4])//coral-columnview-item//div")
	private static List<WebElement> contentOptions2;
	
	@FindBy(name= "j_username")
	private WebElement username;
	@FindBy(name="j_password")
	private WebElement password;
	@FindBy(id="submit-button")
	private WebElement signInButton;
	
	@FindBy(xpath="//input[@id='initEmail']")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Next']")
	private WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/sitemapfortesting/jcr:content/root/container/container/sitemap']")
	private WebElement sitemap;
	
	@FindBy(xpath="//button[@icon='wrench']")
	private WebElement settingIcon;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/homepage-demo.thumb.48.48.png?ck=']")
	private WebElement homepageDemo;
	
	@FindBy(xpath="/html/body/div[1]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[3]/button/coral-icon")
	private WebElement properties;
	
	@FindBy(xpath="//coral-checkbox[@name='./hideInSitemap']")
	private WebElement hidesitemapCheckbox;
	
	@FindBy(xpath="//button[@id='shell-propertiespage-doneactivator']")
	private WebElement saveAndClose;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/sitemapfortesting.thumb.48.48.png?ck=']")
	private WebElement sitemapImage;
	
	@FindBy(xpath="/html/body/div[1]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[2]/button/coral-icon")
	private WebElement edit2;
	
	@FindBy(xpath="//button[@data-layer='Preview']")
	private WebElement previewButton2;
	
	@FindBy(xpath="//*[@id=\"Content\"]/div[1]/coral-actionbar/coral-actionbar-secondary/coral-actionbar-item[1]/button")
	private WebElement editButton2;
	
	@FindBy(xpath="/html/body/div[1]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[11]/button")
	private WebElement quickPublish;
	
	@FindBy(xpath="/html/body/div[2]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[11]/button/coral-icon")
	private WebElement Publish;
	
	@FindBy(xpath="//div[@class='cmp-sitemap__title']//a//h1")
	private static List<WebElement> sitemapContents;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/legal/jcr:content/root/container/container/legal_product_tiles']")
	private WebElement legalTilesAuth;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entries']")
	private static List<WebElement> legalTiles;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel/coral-panel-content/div/div/div/div/coral-multifield/coral-multifield-item[1]/coral-multifield-item-content/div/div/foundation-autocomplete/div/div/span")
	private WebElement legalTilesAuthFirstCheckbox;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/legal/data-processing-addendum.thumb.48.48.png']")
	private WebElement dataProcessingImg;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/legal/maintenance---support.thumb.48.48.png']")
	private WebElement maintenanceImg;
	
	@FindBy(xpath="//button[@class='granite-pickerdialog-submit coral3-Button coral3-Button--primary']")
	private WebElement selectButton;
	
	@FindBy(xpath="//button[@title='Done']")
	private WebElement checkIcon;
	
	@FindBy(xpath="//a[@href='/us/en/automation/products/cloud/offering-overview.html']")
	private WebElement offeringOverviewLink2;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/products/cloud/offering-overview/jcr:content/root/container/container/title']")
	private WebElement offeringOverviewLink2auth;
	
	@FindBy(xpath="(//input[@name='./jcr:title'])[2]")
	private WebElement titleField;
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement contentTitle;
	
	@FindBy(xpath="(//button[@data-layer='Edit'])[2]")
	private WebElement editButtonContent;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/products/cloud/offering-overview/jcr:content/root/container/container/pdfviewer']")
	private WebElement offeringOverviewPdfauth;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel[1]/coral-panel-content/div/div/div/div/foundation-autocomplete/div/div/span/button")
	private WebElement pdfOptions;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/general/content-pdf/PDF%20Template%20for%20AEM%20Testing.pdf.thumb.48.48.png']")
	private WebElement pdfImage;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/homepage-demo/jcr:content/root/container/container/tiles']")
	private WebElement homepageTileauth;
	
	@FindBy(xpath="(//h3[@class='coral-Collapsible-header'])[1]")
	private WebElement collapseHeader;
	
	@FindBy(xpath="//input[@name='./tilesList/item0/./title']")
	private WebElement titleofTile;
	
	@FindBy(xpath="//textarea[@name='./tilesList/item0/./description']")
	private WebElement descriptionofTile;
	
	@FindBy(xpath="(//div[@class='cmp-tiles__entry-title'])[1]")
	private WebElement firstTitleofTile;
	
	@FindBy(xpath="div[@class='cmp-tiles__products-link']")
	private static List<WebElement> loginToMyProductsLinks;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel/coral-panel-content/div/div/div/div[1]/foundation-autocomplete/div/div/span/button")
	private WebElement checkforOptions;
	

	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/my-products.thumb.48.48.png']")
	private WebElement myproductImage;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation.thumb.48.48.png']")
	private WebElement automationImage;
	
	@FindBy(xpath="//button[@trackingelement='edit']")
	private WebElement editnextToPreview;
	
	@FindBy(xpath="//div[@title='Products']")
	private WebElement productsPackage;
	
	@FindBy(xpath="//div[@title='Cloud']")
	private WebElement cloudPackage;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo.thumb.48.48.png?ck=']")
	private WebElement resellerdemoImage;
	
	@FindBy(xpath="//coral-icon[@icon='globeClock']")
	private WebElement managePublication;
	
	@FindBy(xpath="//button[@icon='globeStrike']")
	private WebElement unpublish;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo.thumb.48.48.png?ck=1675950972000']")
	private WebElement resellerdemoImageforUnpublish;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement unpublishButton;
	
	@FindBy(xpath="//button[@variant='warning']")
	private WebElement continueButton;
	
	@FindBy(xpath="//coral-columnview-preview-content[@role='presentation']")
	private static List<WebElement> publishInformation;
	
	@FindBy(xpath="//div[@title='Reseller Demo']")
	private WebElement resellerDemo;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo/check-in.thumb.48.48.png?ck=']")
	private WebElement checkinImg;
	
	@FindBy(xpath="//button[@trackingelement='quick publish']")
	private WebElement quickPublish2;
	
	@FindBy(xpath="//button[@class='coral3-Button coral3-Button--primary']")
	private WebElement publish2;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo/microsoft-alliance.thumb.48.48.png?ck=']")
	private WebElement microsoftImg;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/reseller-demo/dragos-alliance.thumb.48.48.png?ck=']")
	private WebElement dragosImg;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/homepage-demo.thumb.48.48.png?ck=']")
	private WebElement homepagedemoImg;
	
	@FindBy(xpath="(//time[@role='presentation'])[2]")
	private WebElement publishedDate;
	
	@FindBy(xpath="//div[@data-path='/content/pc/us/en/automation/products/cloud/offering-overview/jcr:content/root/container/container/pdfviewer']")
	private WebElement contentEdit;
	
	@FindBy(xpath="//*[@id=\"coral-id-655\"]/coral-panel-content/div/div/div/div/foundation-autocomplete/div/div/span/button")
	private WebElement contentOptions3;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/en_us/products/check-in/myproducts/CLEAR%20%2b%20Check-In%20User%20Flow_OFRO%20Approved.pdf.thumb.48.48.png']")
	private WebElement priceWaterPdf;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__pdf-info']")
	private WebElement lastUpdatedDate;
	
	@FindBy(xpath="//div[@class='coral3-Card-wrapper']")
	private static List<WebElement> pdfInfo;
	
	@FindBy(xpath="(//div[@class='coral3-Card-wrapper'])//foundation-time")
	private static List<WebElement> pdfInfo2;
	
	@FindBy(xpath="//img[@src='/content/dam/productcentral/en_us/products/check-in/myproducts/API%201-Pager%20Overview%20Slide.pdf.thumb.48.48.png']")
	private WebElement pdfTemplate;
	
	@FindBy(xpath="/html/body/coral-dialog[2]/div[2]/form/coral-dialog-content/div/coral-tabview/coral-panelstack/coral-panel[1]/coral-panel-content/div/div/div/div/foundation-autocomplete/div/div/span/button")
	private WebElement setIcon;
	
	@FindBy(xpath="//img[@src='/conf/pc/settings/wcm/templates/content-page-template-product-central/thumbnail.png']")
	private WebElement contentPageTemplate;
	
	@FindBy(xpath="//input[@name='./jcr:title']")
	private WebElement titleField2;
	
	@FindBy(xpath="(//li[@class='coral-SelectList-item coral-SelectList-item--option'])[1]")
	private WebElement firstOptionofDocCat;
	
	@FindBy(xpath="//li[.='Bookkeeping Connect']")
	private WebElement firstOptionofProCat;
	
	@FindBy(xpath="//li[@data-value='productcentral:portfolio/customer-engagement']")
	private WebElement firstOptionofPortCat;
	
	@FindBy(xpath="(//button[@class='foundation-layout-inline2-item foundation-wizard-control coral3-Button coral3-Button--primary'])[2]")
	private WebElement createButton2;
	
	@FindBy(xpath="//coral-button-label[.='Done']")
	private WebElement doneButton;
	
	@FindBy(xpath="//div[@title='Release Notes [Root]']")
	private WebElement releaseNotes;
	
	@FindBy(xpath="//coral-button-label[.='Add']")
	private WebElement addButton;
	
	@FindBy(xpath="(//input[@name='./jcr:title'])[2]")
	private WebElement releaseTitle;
	
	@FindBy(xpath="//div[@data-fielddescription='Enter Release Note Description']")
	private WebElement releaseDescription;
	
	@FindBy(xpath="//input[@name='./releaseNotes/item0/./cq:lastReplicated']")
	private WebElement releaseDate;
	
	@FindBy(xpath="//span[@class='cmp-release-notes__card-subtitle']")
	private WebElement releaseDateonPreview;
	
	@FindBy(xpath="//a[@class='cmp-release-notes__card-title']")
	private WebElement releaseTitleonPreview;
	
	@FindBy(xpath="//div[@class='cmp-release-notes__card-description']")
	private WebElement releaseDescriptiononPreview;
	
	@FindBy(xpath="//div[@title='Product Central Footer']")
	private WebElement authFooter;
	
	@FindBy(xpath="//textarea[@name='./title']")
	private WebElement textareaForFooter;
	
	@FindBy(xpath="//input[@name='./multifield/item0/./title']")
	private WebElement privacyPolicyTitle;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./multifield/item0/./imagepath']")
	private WebElement privacyPolicyLink;
	
	@FindBy(xpath="//input[@name='./multifield/item1/./title']")
	private WebElement termsConditionsTitle;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./multifield/item1/./imagepath']")
	private WebElement termsConditionsLink;
	
	@FindBy(xpath="//input[@name='./multifield/item2/./title']")
	private WebElement cookieTitle;
	
	@FindBy(xpath="//foundation-autocomplete[@name='./multifield/item2/./imagepath']")
	private WebElement cookieLink;
	
	@FindBy(xpath="//div[@class='ap-footer-content']")
	private WebElement footerContent;
	
	@FindBy(xpath="//a[@href='#pageinfo-popover']")
	private WebElement pageInfo;
	
	@FindBy(xpath="//button[@title='View as Published']")
	private WebElement viewasPublish;
	
	@FindBy(xpath="//button[@title='Publish Template']")
	private WebElement publishTemplate;
	
	@FindBy(xpath="(//button[@role='combobox'])[3]")
	private WebElement pcTags;
	
	@FindBy(xpath="(//foundation-time[@type='datetime'])[50]")
	private WebElement pdfDate;
	
	@FindBy(xpath="//img[@src='/content/pc/us/en/automation/sitemapfortesting.thumb.48.48.png?ck=']")
    private WebElement sitemapImg;
	
	
	
	

	
	
	
	static Logger logger=Logger.getLogger("AuthoringPage");
	
	
	
	
	
	ReadXLSdata read1=new ReadXLSdata();
	
	
	
	String expectedNavigatorTitle="new title";
	String expectedNavigatorDescription="New Description";
	





	public void aemTitle() {Assert.assertEquals(Driver.getDriver().getTitle(), "AEM Start", "AEM title verification has been failed");}
	
    public void setSites() {
    	sites.click();
    	productcentral.click();
    	us.click();
    	en.click();
    	HelperFunctions.staticWait(10);
    	automation.click();
    	myproduct.click();
    	fluidForecast.click();
    	HelperFunctions.staticWait(3);
		edit.click();
		 Set<String> allWindows4=Driver.getDriver().getWindowHandles();
	        List<String> windowsList4=new ArrayList<>(allWindows4);
	        Driver.getDriver().switchTo().window(windowsList4.get(1));
	        HelperFunctions.staticWait(15);
	        Driver.getDriver().switchTo().frame(0);
	        //HelperFunctions.clickWithWait(pageTitle);
	        int count=foryouAssets.size();
	        System.out.println(count);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	        
	  
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        if(viewMoreButton.isDisplayed()) {
	        	for(WebElement eachAsset: first5Assets) {
	        		if(eachAsset.isDisplayed()) {
	        			Assert.assertTrue(true);
	        		}
	        	}
	        	for(WebElement eachAsset2:last5Assets) {
	        		if(!eachAsset2.isDisplayed()) {
	        			Assert.assertTrue(true);
	        		}
	        	}
	        }else {
	        	Assert.assertTrue(false);
	        }
	        
	
	      
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
	        executor.executeScript("arguments[0].click();", viewMoreButton);
	        if(viewLessButton.isDisplayed()) {
	        	for(WebElement eachAsset: first5Assets) {
	        		if(eachAsset.isDisplayed()) {
	        			Assert.assertTrue(true);
	        		}
	        	}
	        	for(WebElement eachAsset2:last5Assets) {
	        		if(eachAsset2.isDisplayed()) {
	        			Assert.assertTrue(true);
	        		}
	        	}
	        }else {
	        	Assert.assertTrue(false);
	        }
	        
	        
	        
	        
	        
    
    
    	}
	
	

    public void setChangeProductsTitle() {
		Actions a = new Actions(Driver.getDriver());
		a.doubleClick(changeProductsTitle).build().perform();
		HelperFunctions.staticWait(3);
		Set<String> allWindows5=Driver.getDriver().getWindowHandles();
        List<String> windowsList5=new ArrayList<>(allWindows5);
        Driver.getDriver().switchTo().window(windowsList5.get(1));
        System.out.println(changeProductsTitle.getText());
        
	}
	public void setTitleEdit() {
		Set<String> allWindows5=Driver.getDriver().getWindowHandles();
        List<String> windowsList5=new ArrayList<>(allWindows5);
        Driver.getDriver().switchTo().window(windowsList5.get(1));
		titleEdit.click();
		titleEdit.clear();
		titleEdit.sendKeys(expectedNavigatorTitle);
		HelperFunctions.staticWait(3);
		
	}
	
	public void setCheckButton() {checkButton.click();HelperFunctions.staticWait(3);}
	
	public void setChangeNavigatorDescription() {
        Driver.getDriver().switchTo().defaultContent();
        Actions a = new Actions(Driver.getDriver());
		a.doubleClick(changeNavigatorDescription).build().perform();
		HelperFunctions.staticWait(3);
	}
	public void setNavigatorDescriptionEdit() {
		Set<String> allWindows5=Driver.getDriver().getWindowHandles();
        List<String> windowsList5=new ArrayList<>(allWindows5);
        Driver.getDriver().switchTo().window(windowsList5.get(1));
        HelperFunctions.staticWait(3);
		navigatorDescriptionEdit.click();
		navigatorDescriptionEdit.clear();
		navigatorDescriptionEdit.sendKeys(expectedNavigatorDescription);
		HelperFunctions.staticWait(3);
	}
	
	public void setCheckButton2() {checkButton2.click();HelperFunctions.staticWait(3);}
	
	public void setPreviewButton() {previewButton.click();}

    public void setActualNavigatorTitle() {
    	Driver.getDriver().switchTo().frame(0);
    	Assert.assertEquals(actualNavigatorTitle.getText(),expectedNavigatorTitle,"Actual and expected Navigator Title do not match");
	}

    public void setActualNavigatorDescription() {
		Assert.assertEquals(actualNavigatorDescription.getText(),expectedNavigatorDescription,"Actual and expected Navigator description do not match");
	}
    public void setDocCategory() throws Exception {
  
       /* read1.setExcelFile("./testdata.xlsx", "QA");
 		email.sendKeys(read1.getCellData("DATA", 1));
 		next.click();
 		pass.sendKeys(read1.getCellData("VALUE", 1));
 		submit.click();
 	    HelperFunctions.staticWait(5);
 	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
 js.executeScript("window.open()");
 	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
 	    Driver.getDriver().switchTo().window(tabs.get(1));
 	    Driver.getDriver().get(read1.getCellData("VALUE", 17));*/
 	   // HelperFunctions.waitForPageToLoad(5);
    	createButton.click();
    	pageButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productListingPageTemplate.click();
    	nextButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productCentralTab.click();
    	 HelperFunctions.staticWait(3);
		
        	
    	 FileInputStream file = new FileInputStream("C:\\Users\\GLBL_RDP_USER_01\\eclipse-workspace\\ProductCentralProject-STG-SanityAutomation\\testdata.xlsx");
    	 XSSFWorkbook workbook = new XSSFWorkbook(file);
    	 XSSFSheet sheet = workbook.getSheetAt(1); 
    	 int columnIndex = 2; 

    	 HelperFunctions.staticWait(3);
    	 JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    	 executor.executeScript("arguments[0].click();", portfolioTags2);

    	 HashSet<String> cellValues = new HashSet<String>();
    	 for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
    	     XSSFRow row = sheet.getRow(rowNum);
    	     if(row == null) continue;
    	     XSSFCell cell = row.getCell(columnIndex);
    	     if(cell == null) continue;
    	     cellValues.add(cell.getStringCellValue());
    	 }

    	 for (WebElement element : portfolioTags) {
    	     if (element.isDisplayed() && element.isEnabled()) {
    	         String elementText = element.getText();
    	         if (elementText != null && !elementText.isEmpty()) {
    	             boolean elementFound = false;
    	             for (String cellValue : cellValues) {
    	                 if (cellValue.equalsIgnoreCase(elementText)) {
    	                     elementFound = true;
    	                     break;
    	                 }
    	             }
    	             Assert.assertTrue(elementFound, "element text: " + elementText + " not found in the column: " + columnIndex);
    	         } else {
    	             System.out.println("Element text is empty or null, skipping the element");
    	         }
    	     } else {
    	         System.out.println("Element is not interactable or not visible, skipping the element");
    	     }
    	 }
            /* HelperFunctions.staticWait(3);
             JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
             executor2.executeScript("arguments[0].click();", pcTags);
             HelperFunctions.staticWait(3);
             int columnIndex2 = 1;
             HashSet<String> cellValues2 = new HashSet<String>();
             for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                 XSSFRow row = sheet.getRow(rowNum);
                 if(row == null) continue;
                 XSSFCell cell = row.getCell(columnIndex2);
                 if(cell == null) continue;
                 cellValues2.add(cell.getStringCellValue());
             }
             for (WebElement element2 : productFeatureTags) {
                 if(element2.isDisplayed() && element2.isEnabled()){
                     String elementText2 = element2.getText();
                     if(elementText2!=null && !elementText2.isEmpty()){
                         Assert.assertTrue(cellValues2.contains(elementText2), "element text: " + elementText2 + " not found in the column: " + columnIndex2);
                     }else{
                         System.out.println("Element text is empty or null, skipping the element");
                     }
                 }else{
                     System.out.println("Element is not interactable or not visible, skipping the element");
                 }
             }
             HelperFunctions.staticWait(3);
             int columnIndex3 = 0;
             HashSet<String> cellValues3 = new HashSet<String>();
             for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                 XSSFRow row = sheet.getRow(rowNum);
                 if(row == null) continue;
                 XSSFCell cell = row.getCell(columnIndex3);
                 if(cell == null) continue;
                 cellValues3.add(cell.getStringCellValue());
             }
             for (WebElement element3 : documentCategoryTag) {
                 if(element3.isDisplayed() && element3.isEnabled()){
                     String elementText3 = element3.getText();
                     if(elementText3!=null && !elementText3.isEmpty()){
                         Assert.assertTrue(cellValues3.contains(elementText3), "element text: " + elementText3 + " not found in the column: " + columnIndex3);
                     }else{
                         System.out.println("Element text is empty or null, skipping the element");
                     }
                 }else{
                     System.out.println("Element is not interactable or not visible, skipping the element");
                 }
             }*/
           
    }
  
    	
    
    public void setCombination() throws Exception {
    	read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));
	    HelperFunctions.waitForPageToLoad(3);
    	//sites.click();
    	//productcentral.click();
    	//us.click();
    	//en.click();
    	createButton.click();
    	pageButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productListingPageTemplate.click();
    	nextButton.click();
    	HelperFunctions.waitForPageToLoad(5);
    	productCentralTab.click();
    	
    	for(WebElement each: documentCategoryTag) {
    		if(each.getText().contains("Hosted Software Terms")) {
    			each.click();
    			break;
    		}
    	}
    	
    	
    	
    	
    }
    
    public void setHyperlinks() throws Exception {
    	
    	read1.setExcelFile("./testdata.xlsx", "QA");
    	/*read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));*/
	    HelperFunctions.waitForPageToLoad(3);
	    productsPackage.click();
	    HelperFunctions.staticWait(3);
	    cloudPackage.click();
	    HelperFunctions.staticWait(3);
	    String expectedTitle="Offering Overview";
    	String expectedTitle2="Terms & Conditions";
    	String expectedTitle3="Maintenance & Support";
    	String expectedTitle4="Documentation";
    	Assert.assertTrue(firstPositionAuthor.getText().contains(expectedTitle));
    	Assert.assertTrue(secondPositionAuthor.getText().contains(expectedTitle2));
    	Assert.assertTrue(thirdPositionAuthor.getText().contains(expectedTitle3));
    	Assert.assertTrue(forthPositionAuthor.getText().contains(expectedTitle4));
    	HelperFunctions.staticWait(3);
	    //ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs2.get(1));
	   // Driver.getDriver().get(read1.getCellData("VALUE", 21));
	    JavascriptExecutor js2 = ((JavascriptExecutor) Driver.getDriver());
        js2.executeScript("window.open()");
	    ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs2.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 21));
	    HelperFunctions.waitForPageToLoad(3);
	    Assert.assertTrue(firstTitle.getText().contains(expectedTitle));
	    Assert.assertTrue(secondTitle.getText().contains(expectedTitle2));
	    Assert.assertTrue(thirdTitle.getText().contains(expectedTitle3));
	    Assert.assertTrue(forthTitle.getText().contains(expectedTitle4));
    	
    	
    	
    	
    }
    
    
    public void setSitemap() throws Exception {
    	HelperFunctions.waitForPageToLoad(5);
    	read1.setExcelFile("./testdata.xlsx", "QA");
		/*email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 16));
	    HelperFunctions.waitForPageToLoad(5);*/
	    sitemap.click();
	    HelperFunctions.staticWait(3);
	    settingIcon.click();
	    HelperFunctions.staticWait(3);
	    //ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs7.get(1));
	    checkforOptions.click();
	    HelperFunctions.staticWait(3);
	    myproductImage.click();
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", myproductImage);
        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", myproductImage);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", selectButton);
	   
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	    HelperFunctions.staticWait(3);
	    for(WebElement each: sitemapContents) {
	    	if(each.getText().contains("Fluid Forecast")&& each.getText().contains("Disclosure Checklist")
	    			&&!each.getText().contains("Products") ) {
	    		String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
	    		Assert.assertTrue(true);
	    	}else {
	    		String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
	    	//	Assert.assertTrue(false);
	    	}
	    }
	    HelperFunctions.staticWait(3);
	    editnextToPreview.click();
	    HelperFunctions.staticWait(3);
	    sitemap.click();
	    HelperFunctions.staticWait(3);
	    settingIcon.click();
	    HelperFunctions.staticWait(3);
	    //ArrayList<String> tabs8 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs8.get(1));
	    checkforOptions.click();
	    HelperFunctions.staticWait(3);
	    automationImage.click();
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", automationImage);
        JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", automationImage);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();", selectButton);
	   
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	    HelperFunctions.staticWait(3);
	    for(WebElement each: sitemapContents) {
	    	if(each.getText().contains("Products")&& each.getText().contains("Reseller Demo")) {
	    		String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
	    		Assert.assertTrue(true);
	    	}else {
	    		String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
	    	//	Assert.assertTrue(false);
	    	}
	    }
	    
	    
    	
    	
    	
    }
    
 public void setHideSitemap() throws Exception {
	    HelperFunctions.waitForPageToLoad(5);
    	read1.setExcelFile("./testdata.xlsx", "QA");
		/*email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));
	    HelperFunctions.waitForPageToLoad(5);*/
	    homepageDemo.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(5);
	    properties.click();
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(3);
	    hidesitemapCheckbox.click();
	    HelperFunctions.staticWait(5);
	    saveAndClose.click();
	    HelperFunctions.waitForPageToLoad(5);
	    JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", homepageDemo);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", homepageDemo);
        HelperFunctions.staticWait(5);
        JavascriptExecutor executor7 = (JavascriptExecutor) Driver.getDriver();
        executor7.executeScript("arguments[0].click();",  sitemapImg);
        HelperFunctions.staticWait(5);
        quickPublish.click();
          HelperFunctions.staticWait(5);
          JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();",  publish2);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor11 = (JavascriptExecutor) Driver.getDriver();
        executor11.executeScript("arguments[0].click();", homepageDemo);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor8 = (JavascriptExecutor) Driver.getDriver();
        executor8.executeScript("arguments[0].click();",  sitemapImg);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
        executor9.executeScript("arguments[0].click();",  sitemapImg);
        HelperFunctions.staticWait(3);
        edit.click();
        ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs2.get(1));
        HelperFunctions.waitForPageToLoad(5);
        previewButton2.click();
        String expectedContent="Homepage Demo";
        for(WebElement eachContent: sitemapContents) {
            System.out.println(eachContent.getText());
            if(!eachContent.getText().contains(expectedContent)) {
            	String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
                Assert.assertTrue(true);
            }else {
            	String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
              //  Assert.assertTrue(false);
            }
        }
    	
    }
 
 public void setTilesAuthorization() throws Exception {
	 HelperFunctions.waitForPageToLoad(5);
	 HelperFunctions.staticWait(3);
	 read1.setExcelFile("./testdata.xlsx", "QA");
		/*email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
     js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 19));*/   
		for(WebElement eachTile: legalTiles) {
			if(eachTile.getText().contains("Offering Overview")&& eachTile.getText().contains("Maintenance & Support")&& eachTile.getText().contains("Data Processing Addendum")
    				) {
				String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
				//Assert.assertTrue(false);
			}
		}
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", legalTilesAuth);
        settingIcon.click();
        HelperFunctions.staticWait(3);
       // ArrayList<String> tabs5 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs5.get(1));
	    legalTilesAuthFirstCheckbox.click();
	    HelperFunctions.staticWait(3);
	  //  ArrayList<String> tabs6 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs6.get(1));
	    dataProcessingImg.click();
	    HelperFunctions.staticWait(3);
	    selectButton.click();
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    for(WebElement eachTile: legalTiles) {
			if(eachTile.getText().contains("Offering Overview")&& eachTile.getText().contains("Data Processing Addendum")&& eachTile.getText().contains("Data Processing Addendum")
    				) {
				String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
				//Assert.assertTrue(false);
			}
		}
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();", legalTilesAuth);
        settingIcon.click();
        HelperFunctions.staticWait(3);
       // ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs7.get(1));
	    legalTilesAuthFirstCheckbox.click();
	    HelperFunctions.staticWait(3);
	   // ArrayList<String> tabs8 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs8.get(1));
	    maintenanceImg.click();
	    HelperFunctions.staticWait(3);
	    selectButton.click();
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    for(WebElement eachTile: legalTiles) {
			if(eachTile.getText().contains("Offering Overview")&& eachTile.getText().contains("Maintenance & Support")&& eachTile.getText().contains("Data Processing Addendum")
    				) {
				String successMessage = "Contents contain relevant title";
	            logger.info(successMessage);
				Assert.assertTrue(true);
			}else {
				String errorMessage = "Contents do not contain relevant title";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
				//Assert.assertTrue(false);
			}
		}
	    HelperFunctions.staticWait(3);
	    
	    
	    
 }
 
 public void setContentAuthorization() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "STG");
/*		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
  js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 20));*/
	    HelperFunctions.waitForPageToLoad(5);
	    offeringOverviewLink2auth.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    HelperFunctions.staticWait(2);
	  //  ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs7.get(1));
	    titleField.click();
	    HelperFunctions.staticWait(2);
	    titleField.clear();
	    HelperFunctions.staticWait(2);
	    titleField.sendKeys("test");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	  //  Set<String> allWindows4=Driver.getDriver().getWindowHandles();
     //   List<String> windowsList4=new ArrayList<>(allWindows4);
      //  Driver.getDriver().switchTo().window(windowsList4.get(1));
        
        Driver.getDriver().switchTo().frame(0);
	 String expectedTitle="test";
	 String actualTitle=contentTitle.getText();
	 Assert.assertEquals(expectedTitle, actualTitle);
	 if (!actualTitle.equals(expectedTitle)) {
         String errorMessage = "Titles do not match";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
     }else {
         String successMessage = "Titles match";
         logger.info(successMessage);
     }
	 Driver.getDriver().switchTo().defaultContent();
	 HelperFunctions.staticWait(3);
	 editButtonContent.click();
	 HelperFunctions.staticWait(2);
	 offeringOverviewLink2auth.click();
	 HelperFunctions.staticWait(2);
	 settingIcon.click();
	 HelperFunctions.staticWait(2);
	  //  ArrayList<String> tabs8 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs7.get(1));
	    titleField.click();
	    HelperFunctions.staticWait(2);
	    titleField.clear();
	    HelperFunctions.staticWait(2);
	    titleField.sendKeys("Offering Overview");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	  //  Set<String> allWindows5=Driver.getDriver().getWindowHandles();
   //  List<String> windowsList5=new ArrayList<>(allWindows5);
   //  Driver.getDriver().switchTo().window(windowsList5.get(1));
     
     Driver.getDriver().switchTo().frame(0);
	 String expectedTitle2="Offering Overview";
	 String actualTitle2=contentTitle.getText();
	// Assert.assertEquals(expectedTitle2, actualTitle2);
	 if (!actualTitle2.equals(expectedTitle2)) {
         String errorMessage = "Titles do not match";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
     }else {
         String successMessage = "Titles match";
         logger.info(successMessage);
     }
	 
	 
 
	    
	    
	    
	    
 }
 
 public void setHomepageTileAuthorization() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	/*	email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 10));*/
	    HelperFunctions.waitForPageToLoad(5);
	    homepageTileauth.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    HelperFunctions.staticWait(2);
	   // ArrayList<String> tabs7 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	   // Driver.getDriver().switchTo().window(tabs7.get(1));
	    collapseHeader.click();
	    HelperFunctions.staticWait(2);
	    titleofTile.click();
	    HelperFunctions.staticWait(2);
	    titleofTile.clear();
	    HelperFunctions.staticWait(2);
	    titleofTile.sendKeys("Tile 1");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	  //  Set<String> allWindows4=Driver.getDriver().getWindowHandles();
      //  List<String> windowsList4=new ArrayList<>(allWindows4);
      //  Driver.getDriver().switchTo().window(windowsList4.get(1));
        
        Driver.getDriver().switchTo().frame(0);
	 String expectedTitle="Tile 1";
	 String actualTitle=firstTitleofTile.getText();
	// Assert.assertEquals(expectedTitle, actualTitle);
	 if (!actualTitle.equals(expectedTitle)) {
         String errorMessage = "Titles do not match ";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
     }else {
         String successMessage = "Titles match";
         logger.info(successMessage);
     }
	 Driver.getDriver().switchTo().defaultContent();
	 HelperFunctions.staticWait(2);
	 editButtonContent.click();
	 HelperFunctions.staticWait(2);
	 homepageTileauth.click();
	 HelperFunctions.staticWait(2);
	    settingIcon.click();
	  //  ArrayList<String> tabs9 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  //  Driver.getDriver().switchTo().window(tabs9.get(1));
	    collapseHeader.click();
	    HelperFunctions.staticWait(2);
	    titleofTile.click();
	    HelperFunctions.staticWait(2);
	    titleofTile.clear();
	    HelperFunctions.staticWait(2);
	    titleofTile.sendKeys("Legal");	
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    previewButton2.click();
	 //   Set<String> allWindows5=Driver.getDriver().getWindowHandles();
   //  List<String> windowsList5=new ArrayList<>(allWindows5);
   //  Driver.getDriver().switchTo().window(windowsList5.get(1));
	    HelperFunctions.staticWait(3);
     Driver.getDriver().switchTo().frame(0);
     HelperFunctions.staticWait(3);
	 String expectedTitle2="Legal";
	 String actualTitle2=firstTitleofTile.getText();
	// Assert.assertEquals(expectedTitle2, actualTitle2);
	 if (!actualTitle2.equals(expectedTitle2)) {
         String errorMessage = "Titles do not match ";
         logger.error(errorMessage);
         throw new Exception(errorMessage);
     }else {
         String successMessage = "Titles match";
         logger.info(successMessage);
     }
	    
	    
	    
	    
 }
 
 public void setDisplayingLogintomyProductLink() throws Exception {
	/* read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 2));
	    HelperFunctions.waitForPageToLoad(5);*/
	    
	    for(WebElement eachLink: loginToMyProductsLinks) {
	    	if(eachLink.getText().contains("Login to My Products")) {
	    		String errorMessage = "Login to My Products link is not displayed";
	            logger.error(errorMessage);
	            throw new Exception(errorMessage);
	    		//Assert.assertTrue(false);
	    	}else {
	    		Assert.assertTrue(true);
	    		String successMessage = "Login to My Products link is displayed";
	            logger.info(successMessage);
	    	//	logger.error("Login to My Products link is not displayed ");
	    	}
	    }
	 
	 
	 
 }
 public void setUnpublishWorkflow() throws Exception {
 	
 	read1.setExcelFile("./testdata.xlsx", "STG");
	/*	email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
     js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 17));*/
	    HelperFunctions.waitForPageToLoad(5);
	    resellerdemoImage.click();
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", resellerdemoImage);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", resellerdemoImage);
        HelperFunctions.staticWait(3);
	    managePublication.click();
	    HelperFunctions.waitForPageToLoad(5);
        HelperFunctions.staticWait(5);
	    unpublish.click();
	    HelperFunctions.staticWait(5);
	    nextButton.click();
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();", resellerdemoImageforUnpublish);
	    unpublishButton.click();
	    HelperFunctions.staticWait(3);
	    continueButton.click();
		 //   ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		 //   Driver.getDriver().switchTo().window(tabs2.get(1));
		    Driver.getDriver().get(read1.getCellData("VALUE", 17));
		    HelperFunctions.waitForPageToLoad(5);
	    JavascriptExecutor executor7 = (JavascriptExecutor) Driver.getDriver();
        executor7.executeScript("arguments[0].click();", resellerdemoImage);
        HelperFunctions.staticWait(3);
        for(WebElement eachInfo: publishInformation) {
        	System.out.println(eachInfo.getText());
        	if(eachInfo.getText().contains("Not published")) {
        		Assert.assertTrue(true);
        		String successMessage = "Page is unpublished ";
                logger.info(successMessage);
        	}else {
        		 String errorMessage = "Page is supposed to be unpublished but it does not show 'Not published' ";
                 logger.error(errorMessage);
                 throw new Exception(errorMessage);
        		//Assert.assertTrue(false);
        		//logger.error("Page is supposed to be unpublished but it does not show 'Not published' ");
        	}
        }
        JavascriptExecutor executor8 = (JavascriptExecutor) Driver.getDriver();
        executor8.executeScript("arguments[0].click();", resellerdemoImage);
        resellerDemo.click();
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor9 = (JavascriptExecutor) Driver.getDriver();
        executor9.executeScript("arguments[0].click();", checkinImg);
        HelperFunctions.staticWait(3);
        for(WebElement eachInfo: publishInformation) {
        	System.out.println(eachInfo.getText());
        	if(eachInfo.getText().contains("Not published")) {
        		String successMessage = "Publish info contains unpublished ";
                logger.info(successMessage);
        		Assert.assertTrue(true);
        	}else {
        		String errorMessage = "Publish info does not contain unpublished ";
                logger.error(errorMessage);
                throw new Exception(errorMessage);
        		//Assert.assertTrue(false);
        		//logger.error("Page is supposed to be unpublished but it does not show 'Not published' ");
        	}
        }
        
        HelperFunctions.staticWait(3);
        quickPublish2.click();
        publish2.click();
        JavascriptExecutor executor10 = (JavascriptExecutor) Driver.getDriver();
        executor10.executeScript("arguments[0].click();", checkinImg);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor11 = (JavascriptExecutor) Driver.getDriver();
        executor11.executeScript("arguments[0].click();", microsoftImg);
        JavascriptExecutor executor12 = (JavascriptExecutor) Driver.getDriver();
        executor12.executeScript("arguments[0].click();", microsoftImg);
        JavascriptExecutor executor13 = (JavascriptExecutor) Driver.getDriver();
        executor13.executeScript("arguments[0].click();", microsoftImg);
        HelperFunctions.staticWait(3);
        quickPublish2.click();
        HelperFunctions.staticWait(3);
        publish2.click();
        JavascriptExecutor executor14 = (JavascriptExecutor) Driver.getDriver();
        executor14.executeScript("arguments[0].click();", microsoftImg);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor15 = (JavascriptExecutor) Driver.getDriver();
        executor15.executeScript("arguments[0].click();", dragosImg);
        JavascriptExecutor executor16 = (JavascriptExecutor) Driver.getDriver();
        executor16.executeScript("arguments[0].click();", dragosImg);
        JavascriptExecutor executor17 = (JavascriptExecutor) Driver.getDriver();
        executor17.executeScript("arguments[0].click();", dragosImg);
        HelperFunctions.staticWait(3);
        quickPublish2.click();
        HelperFunctions.staticWait(3);
        publish2.click();
        JavascriptExecutor executor18 = (JavascriptExecutor) Driver.getDriver();
        executor18.executeScript("arguments[0].click();", dragosImg);
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor19 = (JavascriptExecutor) Driver.getDriver();
        executor19.executeScript("arguments[0].click();", resellerdemoImage);
        JavascriptExecutor executor20 = (JavascriptExecutor) Driver.getDriver();
        executor20.executeScript("arguments[0].click();", resellerdemoImage);
        JavascriptExecutor executor21 = (JavascriptExecutor) Driver.getDriver();
        executor21.executeScript("arguments[0].click();", resellerdemoImage);
        HelperFunctions.staticWait(3);
        quickPublish2.click();
        HelperFunctions.staticWait(3);
        publish2.click();
        HelperFunctions.staticWait(3);
        for(WebElement eachInfo: publishInformation) {
        	System.out.println(eachInfo.getText());
        	if(!eachInfo.getText().contains("Not published")) {
        		Assert.assertTrue(true);
        	}else {
        		Assert.assertTrue(false);
        	}
        }
        
	    
	    
 }
 public void setUpdatedDate() throws Exception {
	 	
	 	read1.setExcelFile("./testdata.xlsx", "QA");
		/*	email.sendKeys(read1.getCellData("DATA", 1));
			next.click();
			pass.sendKeys(read1.getCellData("VALUE", 1));
			submit.click();
		    HelperFunctions.staticWait(5);
		    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
	     js.executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		    Driver.getDriver().switchTo().window(tabs.get(1));
		    Driver.getDriver().get(read1.getCellData("VALUE", 17));*/
		    HelperFunctions.waitForPageToLoad(5);
		    homepagedemoImg.click();
		    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
	        executor1.executeScript("arguments[0].click();", homepagedemoImg);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	        executor2.executeScript("arguments[0].click();", homepagedemoImg);
		    HelperFunctions.staticWait(3);
		    quickPublish.click();
		    HelperFunctions.staticWait(3);
		    publish2.click();
		    HelperFunctions.staticWait(3);
		    
		   
		      Calendar cal = Calendar.getInstance();
		      String month=new SimpleDateFormat("MMMMMMMMM").format(cal.getTime());
		      System.out.println(month);
		      String year=new SimpleDateFormat("YYYY").format(cal.getTime());
		      System.out.println(year);
		      String dayoftheweek=new SimpleDateFormat("EEEEE").format(cal.getTime());
		      System.out.println(dayoftheweek);
		      String dayoftheyear=new SimpleDateFormat("d").format(cal.getTime());
		      System.out.println(dayoftheyear);
		      String value = publishedDate.getAttribute("title");
		      System.out.println(value);
		      if(value.contains(month)&&value.contains(year)&&value.contains(dayoftheweek)&&value.contains(dayoftheyear)) {
		    	  String successMessage = "The date of publishing is correct";
		            logger.info(successMessage);
		    	  Assert.assertTrue(true);
		      }else {
		    	  String errorMessage = "The date of publishing is NOT correct";
	                logger.error(errorMessage);
	                throw new Exception(errorMessage);
		    	 // Assert.assertTrue(false);
		    	//  logger.error("The date of publishing is NOT correct");
		      }
		     
		      
    
    
 }
 
 public void setUpdatedDateFromAssets() throws Exception {
	 
	 read1.setExcelFile("./testdata.xlsx", "STG");
	
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(3);
	    HelperFunctions.scrollToElement(pdfDate);
	    HelperFunctions.staticWait(2);
	    String originalDate = pdfDate.getAttribute("value");
        String desiredFormat = "MM/dd/yyyy";
        SimpleDateFormat originalSDF = new SimpleDateFormat("yyyy-MM-dd");
        Date date = originalSDF.parse(originalDate);
        SimpleDateFormat desiredSDF = new SimpleDateFormat(desiredFormat);
        String formattedDate = desiredSDF.format(date);
        System.out.println(formattedDate);
        HelperFunctions.staticWait(2);
	    Driver.getDriver().get(read1.getCellData("VALUE", 20));
	    HelperFunctions.waitForPageToLoad(5);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
	    priceWaterPdf.click();
	    HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	 //   HelperFunctions.staticWait(2);
	 //   Driver.getDriver().switchTo().frame(0);
	 //   System.out.println(lastUpdatedDate.getText());
	 //   String expectedDate=read1.getCellData("VALUE", 33);
	 //   Assert.assertEquals(lastUpdatedDate.getText(), expectedDate);
	 //   HelperFunctions.staticWait(2);
	 //   Driver.getDriver().switchTo().defaultContent();
	    editButtonContent.click();
	    HelperFunctions.staticWait(2);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
        pdfTemplate.click();
        HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    String date2 = lastUpdatedDate.getText();
	    System.out.println(date2);
	    Assert.assertTrue(date2.contains(formattedDate));
	 /*read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
  js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 20));
	    HelperFunctions.waitForPageToLoad(5);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
	    priceWaterPdf.click();
	    HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    System.out.println(lastUpdatedDate.getText());
	    String expectedDate=read1.getCellData("VALUE", 33);
	    Assert.assertEquals(lastUpdatedDate.getText(), expectedDate);
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().defaultContent();
	    editButtonContent.click();
	    HelperFunctions.staticWait(2);
	    contentEdit.click();
	    HelperFunctions.staticWait(2);
	    settingIcon.click();
	    setIcon.click();
	    HelperFunctions.staticWait(2);
        pdfTemplate.click();
        HelperFunctions.staticWait(2);
	    selectButton.click();
	    HelperFunctions.staticWait(2);
	    checkIcon.click();
	    HelperFunctions.staticWait(2);
	    previewButton2.click();
	    HelperFunctions.staticWait(2);
	    Driver.getDriver().switchTo().frame(0);
	    System.out.println(lastUpdatedDate.getText());
	    System.out.println(lastUpdatedDate.getText().replace("/", "-"));
	    String expectedDate2=read1.getCellData("VALUE", 32);
	    Assert.assertEquals(lastUpdatedDate.getText(), expectedDate2);*/
	   
	  
	    
 }
 public void setUpdatedDateFromAssets2() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get("https://auth-productcentral-qa.products.pwc.com/assets.html/content/dam/productcentral/general/content-pdf");
	    HelperFunctions.waitForPageToLoad(5);
	  	    for(WebElement each: pdfInfo) {
	  	    	//System.out.println(each.getText());
	  	    	 
	  	    		for(WebElement each2:pdfInfo2) {
	  	    			if(each.getText().contains("PDF Template for AEM Testing")) {
	  	    				System.out.println(each2.getAttribute("value"));
	  	    				break;
	  	    			}
	  	    			
	  	    		}
	  	    	}
	  	    
	    
	   // String expectedDate2="Last updated 01/09/2023";
	   // Assert.assertEquals(lastUpdatedDate.getText(), expectedDate2);
	    
 }
 public void setUpdatedDateVisibility() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "STG");
	
	    HelperFunctions.waitForPageToLoad(5);
	    previewButton2.click();
	    Driver.getDriver().switchTo().frame(0);
	    HelperFunctions.staticWait(2);
	    if(lastUpdatedDate.isDisplayed()) {
	    	String successMessage = "Last updated date is visible";
            logger.info(successMessage);
	    	Assert.assertTrue(true);
	    }else {
	    	String errorMessage = "Last updated date is not visible";
            logger.error(errorMessage);
            throw new Exception(errorMessage);
	    	//Assert.assertTrue(false);
	    }
	 
	    
	    
	    
	    
	    
 }
 public void setCatCombination() throws Exception {
	 HelperFunctions.waitForPageToLoad(5);
	 read1.setExcelFile("./testdata.xlsx", "QA");
	/*	email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 23));*/
	    HelperFunctions.staticWait(5);
	    createButton.click();
	    HelperFunctions.staticWait(2);
	    pageButton.click();
	    HelperFunctions.staticWait(2);
	    contentPageTemplate.click();
	    HelperFunctions.staticWait(2);
	    nextButton.click();
	    HelperFunctions.waitForPageToLoad(5);
	    titleField2.click();
	    HelperFunctions.staticWait(2);
	    titleField2.sendKeys("content 3");
	    HelperFunctions.staticWait(2);
	    productCentralTab.click();
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
        executor1.executeScript("arguments[0].click();", documentCategoryTag2);
       
	    HelperFunctions.staticWait(3);
	    
	    firstOptionofDocCat.click();
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
        executor2.executeScript("arguments[0].click();", productFeatureTag2);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", firstOptionofProCat);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor4 = (JavascriptExecutor) Driver.getDriver();
        executor4.executeScript("arguments[0].click();", portfolioTag2);
	    HelperFunctions.staticWait(3);
	    JavascriptExecutor executor5 = (JavascriptExecutor) Driver.getDriver();
        executor5.executeScript("arguments[0].click();", firstOptionofPortCat);
        HelperFunctions.staticWait(3);
        createButton2.click();
        HelperFunctions.staticWait(3);
        JavascriptExecutor executor6 = (JavascriptExecutor) Driver.getDriver();
        executor6.executeScript("arguments[0].click();", doneButton);
       // doneButton.click();
        HelperFunctions.staticWait(3);
	  	    
 }
 public void setReleaseNotes() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
	/*	email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 7));*/
	    HelperFunctions.waitForPageToLoad(5);
	    editButtonContent.click();
	    HelperFunctions.staticWait(3);
	    HelperFunctions.scrollToElement(releaseNotes);
        HelperFunctions.staticWait(3);
        releaseNotes.click();
        HelperFunctions.staticWait(3);
        settingIcon.click();
        HelperFunctions.staticWait(3);
        String title="version1";
        releaseTitle.click();
        releaseTitle.clear();
        releaseTitle.sendKeys(title);
        HelperFunctions.staticWait(3);
        releaseDate.click();
        releaseDate.clear();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        releaseDate.sendKeys(dateFormat.format(date));
        JavascriptExecutor executor3 = (JavascriptExecutor) Driver.getDriver();
        executor3.executeScript("arguments[0].click();", releaseDescription);
        String description="some description";
        releaseDescription.clear();
        releaseDescription.sendKeys(description);
        HelperFunctions.staticWait(3);
        checkIcon.click();
        HelperFunctions.staticWait(3);
        previewButton2.click();
        HelperFunctions.staticWait(3);
        Driver.getDriver().switchTo().frame(0);
        HelperFunctions.scrollToElement(releaseTitleonPreview);
        HelperFunctions.staticWait(3);
        String actualDate=releaseDateonPreview.getText();
        String expectedDate=dateFormat.format(date);
       // Assert.assertEquals(actualDate, expectedDate);
        if (!actualDate.equals(expectedDate)) {
            String errorMessage = "Dates do not match";
              logger.error(errorMessage);
              throw new Exception(errorMessage);
        }else {
            String successMessage = "Dates match";
              logger.info(successMessage);
        } 
        HelperFunctions.staticWait(3);
        String actualTitle=releaseTitleonPreview.getText();
        String expectedTitle=title;
       // Assert.assertEquals(actualTitle, expectedTitle);
        if (!actualTitle.equals(expectedTitle)) {
            String errorMessage = "Titles do not match";
              logger.error(errorMessage);
              throw new Exception(errorMessage);
        }else {
            String successMessage = "Titles match";
              logger.info(successMessage);
        } 
        HelperFunctions.staticWait(3);
        String actualDescription=releaseDescriptiononPreview.getText();
        String expectedDescription=description;
       // Assert.assertEquals(actualDescription,expectedDescription);
        if (!actualDescription.equals(expectedDescription)) {
            String errorMessage = "Descriptions do not match";
              logger.error(errorMessage);
              throw new Exception(errorMessage);
        }else {
            String successMessage = "Descriptions match";
              logger.info(successMessage);
        } 
        
        
        
	   
	    
 }
 public void setAuthFooter() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "STG");
	
	    HelperFunctions.waitForPageToLoad(5);
	    HelperFunctions.staticWait(5);
	    HelperFunctions.scrollToElement(authFooter); 
        HelperFunctions.staticWait(3);
        HelperFunctions.scrollToElement(authFooter); 
	    HelperFunctions.staticWait(3);
	    authFooter.click();
	    HelperFunctions.staticWait(3);
	    settingIcon.click();
	    HelperFunctions.staticWait(3);
	    textareaForFooter.click();
	    textareaForFooter.clear();
	    String mockFooter=read1.getCellData("VALUE", 40);
	    textareaForFooter.sendKeys(mockFooter);
	    HelperFunctions.staticWait(3);
	    privacyPolicyTitle.click();
	    privacyPolicyTitle.clear();
	    privacyPolicyTitle.sendKeys("Privacy policy");
	    HelperFunctions.staticWait(3);
	    checkIcon.click();
	    HelperFunctions.staticWait(3);
	    pageInfo.click();
	    HelperFunctions.staticWait(3);
	    publishTemplate.click();
	    HelperFunctions.staticWait(3);
	    unpublishButton.click();
	    HelperFunctions.staticWait(5);
	  	 //   ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	  	 //   Driver.getDriver().switchTo().window(tabs2.get(1));
	  	    Driver.getDriver().get(read1.getCellData("VALUE", 41));
	  	    HelperFunctions.waitForPageToLoad(5);
	  	    fluidForecast.click();
	  	  HelperFunctions.staticWait(3);
	  	   JavascriptExecutor executor1 = (JavascriptExecutor) Driver.getDriver();
	        executor1.executeScript("arguments[0].click();", fluidForecast);
	        HelperFunctions.staticWait(3);
	        JavascriptExecutor executor2 = (JavascriptExecutor) Driver.getDriver();
	        executor2.executeScript("arguments[0].click();", fluidForecast);
	  	  HelperFunctions.staticWait(3);
	  	  quickPublish2.click();
	  	 HelperFunctions.staticWait(3);
	  	 publish2.click();
	  	 HelperFunctions.staticWait(3);
		  	 //   ArrayList<String> tabs3 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		  	 //   Driver.getDriver().switchTo().window(tabs3.get(1));
		  	    Driver.getDriver().get(read1.getCellData("VALUE", 7));
		  	    HelperFunctions.waitForPageToLoad(5);
	  
		  	Driver.getDriver().switchTo().frame(0);
		  	HelperFunctions.staticWait(3);
		  	 HelperFunctions.scrollToElement(footerContent); 
	        HelperFunctions.staticWait(3);
	        Assert.assertTrue(footerContent.getText().contains(mockFooter));
	        HelperFunctions.staticWait(3);
	 
		  	 //   ArrayList<String> tabs4 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
		  	 //   Driver.getDriver().switchTo().window(tabs4.get(1));
		  	    Driver.getDriver().get(read1.getCellData("VALUE", 27));
		  	    HelperFunctions.waitForPageToLoad(5);
		  	    HelperFunctions.staticWait(5);
		  	    HelperFunctions.scrollToElement(authFooter);
		        HelperFunctions.staticWait(3);
		        HelperFunctions.scrollToElement(authFooter);  
			    HelperFunctions.staticWait(3);
			    authFooter.click();
			    HelperFunctions.staticWait(3);
			    settingIcon.click();
			    HelperFunctions.staticWait(3);
			    textareaForFooter.click();
			    textareaForFooter.clear();
			    String footer=read1.getCellData("VALUE", 31);
			    textareaForFooter.sendKeys(footer);
			    HelperFunctions.staticWait(3);
			    checkIcon.click();
			    HelperFunctions.staticWait(3);
			    pageInfo.click();
			    HelperFunctions.staticWait(3);
			    publishTemplate.click();
			   // HelperFunctions.staticWait(3);
			   // unpublishButton.click();
			    HelperFunctions.staticWait(5);
	        
	    
	    
	    
	    
	    
 
 
 
 }
 
 public void setNeedTechnicalSupport() throws Exception {
	 read1.setExcelFile("./testdata.xlsx", "QA");
		email.sendKeys(read1.getCellData("DATA", 1));
		next.click();
		pass.sendKeys(read1.getCellData("VALUE", 1));
		submit.click();
	    HelperFunctions.staticWait(5);
	    JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
  js.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(1));
	    Driver.getDriver().get(read1.getCellData("VALUE", 7));
	    HelperFunctions.waitForPageToLoad(5);
	    
	    
 
 
 
 }
 
    
    
    

}
