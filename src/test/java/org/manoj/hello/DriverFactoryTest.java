package org.manoj.hello;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class DriverFactory {
    static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    private DriverFactory(){};
    public static synchronized WebDriver getDriverInstance(String browserName){
        WebDriver driver;
        if (browserName.toLowerCase().equals("chrome")){
            driver = new ChromeDriver();
            webdriver.set(driver); ;
        } else{
            driver = new FirefoxDriver();
            webdriver.set(driver);
        }
        return webdriver.get();
    }
}

public class DriverFactoryTest{
    public static void main(String[] args) {
        WebDriver driver=  DriverFactory.getDriverInstance("Chrome");
        System.out.println(driver instanceof ChromeDriver);
        driver.quit();

        driver=  DriverFactory.getDriverInstance("firefox");
        System.out.println(driver instanceof WebDriver);
        System.out.println(driver instanceof FirefoxDriver);
        driver.close();
    }

}

