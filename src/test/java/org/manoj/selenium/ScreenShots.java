package org.manoj.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShots {
    public static void main(String[] args) {

        /*
        * Capturing a Screenshot of the Visible Viewport:
The most common method to take a screenshot is to capture the currently visible area of the browser window (the viewport). This is achieved using the getScreenshotAs() method from the TakesScreenshot interface.
*
        * */
        // ... (WebDriver initialization)

        WebDriver driver = new ChromeDriver(); // Or other browser driver
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // For Selenium 4 and newer, use FileHandler.copy()
            FileHandler.copy(screenshotFile, new File("screenshot.png"));
            // For older versions, you might need Apache Commons IO FileUtils.copyFile()
            // FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

/*
* Capturing a Screenshot of a Specific Web Element (Selenium 4+):
In Selenium 4 and later, you can directly capture a screenshot of a specific web element using the getScreenshotAs() method on the WebElement object.
* */
        WebElement element = driver.findElement(By.name("username"));
        File elementScreenshot = element.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(elementScreenshot, new File("element_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
