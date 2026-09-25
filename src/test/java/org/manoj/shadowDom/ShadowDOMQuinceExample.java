package org.manoj.shadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// For older Selenium versions (prior to Selenium 4), interacting with Shadow DOM elements typically required using JavaScriptExecutor to execute JavaScript code directly to access the elements. However, the getShadowRoot() method in Selenium 4 provides a more direct and cleaner approach.
public class ShadowDOMQuinceExample {
    public static void main(String[] args) {
        // Set up WebDriver (e.g., ChromeDriver)
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://qa.onequince.com/checkout?checkoutId=2a1ddd30-a006-4206-ae5a-df92ebe4973b&checkoutAuthCode=8fd1e4de-14a0-479c-ac08-c3042f8d16ff");

            Thread.sleep(15000);

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation'][contains(@src,'stripecdn.com/stripethirdparty-srv/assets')]")));
            Thread.sleep(5000);
            // 1. Locate the Shadow Host
            WebElement shadowHost = driver.findElement(By.xpath("//div[@id='financial-partner-app-container']/div"));

            // 2. Access the Shadow Root
            SearchContext shadowRoot = shadowHost.getShadowRoot();

            // 3. Locate elements within the Shadow DOM
            WebElement textElement = shadowRoot.findElement(By.cssSelector("#maxo-button-wrapper-1765174388109 > div"));
//            WebElement textElement = shadowRoot.findElement(By.xpath("//p")); // Will not work

            System.out.println("Text inside Shadow DOM: " + textElement.getText());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
