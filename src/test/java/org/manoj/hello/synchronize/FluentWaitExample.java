package org.manoj.hello.synchronize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
/*
* Fluent Wait in Selenium is a type of explicit wait that provides a more flexible and customizable approach to
*  handling dynamic web elements and synchronization issues in automated tests. It allows you to define
*  the maximum amount of time to wait for a condition to be met, the frequency at which to check for that
* condition (polling interval), and which specific exceptions to ignore during the waiting period.
 * */
public class FluentWaitExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Initialize FluentWait
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)) // Maximum wait time
                .pollingEvery(Duration.ofMillis(500)) // Polling interval
                .ignoring(org.openqa.selenium.NoSuchElementException.class); // Exception to ignore

        // Wait for an element to be present and clickable
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("myDynamicElement"));
            }
        });
        element.click();

        WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        });
        foo.sendKeys("");

        WebElement element1= wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath(""));
            }
        });
        element1.click();


//        Another example of fluent wait

        //Declare and initialise a fluent wait
        FluentWait fluentWait = new FluentWait(driver);
//Specify the timout of the wait
        fluentWait.withTimeout(Duration.ofMillis(5000));
//Sepcify polling time
//        fluentWait.pollingEvery(250, TimeUnit.MILLISECONDS);
        fluentWait.pollingEvery(Duration.ofMillis(250));
//Specify what exceptions to ignore
        fluentWait.ignoring(NoSuchElementException.class);

//This is how we specify the condition to wait on.
//This is what we will explore more in this chapter
        wait.until(ExpectedConditions.alertIsPresent());


        driver.quit();
    }
}
