package org.manoj.shadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// For older Selenium versions (prior to Selenium 4), interacting with Shadow DOM elements typically required using JavaScriptExecutor to execute JavaScript code directly to access the elements. However, the getShadowRoot() method in Selenium 4 provides a more direct and cleaner approach.
public class ShadowDOMExample {
    public static void main(String[] args) {
        // Set up WebDriver (e.g., ChromeDriver)
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

            // 1. Locate the Shadow Host
            WebElement shadowHost = driver.findElement(By.id("content"));

            // 2. Access the Shadow Root
            SearchContext shadowRoot = shadowHost.getShadowRoot();

            // 3. Locate elements within the Shadow DOM
            WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
//            WebElement textElement = shadowRoot.findElement(By.xpath("//p")); // Will not work

            System.out.println("Text inside Shadow DOM: " + textElement.getText());

        } finally {
            driver.quit();
        }
    }
}
