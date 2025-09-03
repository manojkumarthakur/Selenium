package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/*
* In Selenium WebDriver's PageFactory,
*  @FindBy, @FindBys, and @FindAll are annotations used to locate web elements within a Page Object.
*
* In summary:
@FindBy targets a single element with a single locator strategy.
@FindBys requires all specified locator strategies to be true for an element to be found (AND logic).
@FindAll requires at least one of the specified locator strategies to be true for an element to be found (OR logic).
* */
public class HomePage {

    /*
    * @FindBy: This annotation is used to locate a single web element using a single criterion.
    * It specifies how to find an element, such as by ID, name, class name, XPath, or CSS selector.
     * */
    @FindBy(id = "username")
    WebElement usernameField;
    List<WebElement> usernameFields;


    /*
    *@FindBys: This annotation is used when a web element or a list of web elements needs to match all of the
    * specified criteria. It represents an "AND" conditional relationship between multiple @FindBy annotations.
    * The element(s) must satisfy every condition provided within the @FindBys annotation.
    * */
    @FindBys({
            @FindBy(className = "input-field"),
            @FindBy(name = "password")
    })
    WebElement passwordInput;
    List<WebElement> passwordInputs;


    /*
    *@FindAll: This annotation is used when a web element or a list of web elements needs
    * to match at least one of the specified criteria. It represents an "OR" conditional relationship between
    *  multiple @FindBy annotations. The element(s) can satisfy any of the conditions provided within the
    * @FindAll annotation.
    * */
    @FindAll({
            @FindBy(id = "submitButton"),
            @FindBy(className = "primary-button")
    })
    WebElement actionButton;
    List<WebElement> actionButtons;

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
