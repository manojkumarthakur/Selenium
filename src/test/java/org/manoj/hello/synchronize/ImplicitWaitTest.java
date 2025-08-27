package org.manoj.hello.synchronize;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Implicit Wait setting is a Global setting and applies to all elements in the script,
// and it remains in effect for the duration of the WebDriver instance.
// However, implicit wait increases test script execution time. It makes each command wait for the defined time before resuming test execution.

public class ImplicitWaitTest {

    private WebDriver driver;
    private String baseUrl;
    private WebElement element;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.google.com";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl);
        element = driver.findElement(By.xpath("//textarea[@title=\"Search\"]"));
        element.sendKeys("Selenium WebDriver Interview questions");
        element.sendKeys(Keys.RETURN);
        List<WebElement> list = driver.findElements(By.xpath("//h3"));
        System.out.println(list.size());

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
