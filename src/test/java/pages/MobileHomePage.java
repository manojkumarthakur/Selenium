package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/*
*
* For Mobile application
* */
public class MobileHomePage {

    //All the below strategy can be used on single WebElement
    @FindBy(id = "com.safe.android.debug:id/nav_dashboard") // For Web view html/Browser
    @AndroidFindBy(id = "com.safe.android.debug:id/nav_dashboard") //For Native Android
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Dashboard'") // For Native iO
     WebElement we_sampelWebElement;


    @AndroidFindBy(id = "nav_search")
    @iOSXCUITFindBy(accessibility = "Search")
    WebElement we_searchButton;

    protected AppiumDriver driver;

    public MobileHomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }


}
