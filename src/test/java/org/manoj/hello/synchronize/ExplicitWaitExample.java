package org.manoj.hello.synchronize;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Explicit wait in Selenium is a synchronization mechanism that allows the WebDriver to wait for a specific condition
to occur before proceeding with the next step in the code. Unlike Implicit waits, which apply globally,
explicit waits are applied only to specific elements or conditions, making them more flexible and precise.*/
public class ExplicitWaitExample {
    // created reference variable for WebDriver
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {

// initializing driver variable using FirefoxDriver
        driver=new ChromeDriver();
// launching gmail.com on the browser
        driver.get("https://gmail.com");
// maximized the browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void test() throws InterruptedException {
// saving the GUI element reference into a "element" variable of WebElement type
        WebElement element = driver.findElement(By.id("Email"));
// entering username
        element.sendKeys("dummy@gmail.com");
        element.sendKeys(Keys.RETURN);
// entering password
        driver.findElement(By.id("Passwd")).sendKeys("password");
// clicking signin button
        driver.findElement(By.id("signIn")).click();
// explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))),
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath("")))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
// click on the compose button as soon as the "compose" button is visible
        driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
    }

    @AfterMethod
    public void teardown() {
// closes all the browser windows opened by web driver
        driver.quit();
    }

}