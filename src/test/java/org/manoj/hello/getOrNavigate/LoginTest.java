package org.manoj.hello.getOrNavigate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// https://www.browserstack.com/guide/driver-get-in-selenium
// https://www.geeksforgeeks.org/software-testing/difference-between-get-and-navigate-in-selenium/

/*
Factors           ->              get()               ||                    navigate()

Interface Part -> The get function is a part of the Webdriver interface. || The navigate function is a part of the Navigation interface.

Wait for webpage load -> The get function waits until the webpage is loaded properly and available to return control. || The navigate function does not wait for the webpage to be loaded properly.

History tracking feature -> The get function does not have the history tracking feature, thus enabling the user not to go back. ||  The navigate function has a history tracking feature. Thus, the user can go back to the previous web page too.
Cookies/ Session	->Clear after each use	||  Maintain/ Retain cookies and sessions from the previous state.
*
* */
public class LoginTest {

    public static void main(String[] args) {

//        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();



        try {

            // Load the login page

            driver.get("https://www.bstackdemo.com/signin");
//            driver.navigate().to("https://www.bstackdemo.com/signin");



            // Interact with the login form

            WebElement username = driver.findElement(By.id("react-select-2-input"));

            WebElement password = driver.findElement(By.id("react-select-3-input"));

            WebElement loginButton = driver.findElement(By.id("login-btn"));



            username.sendKeys("demouser" + Keys.ENTER);

            password.sendKeys("testingisfun99" + Keys.ENTER);

//            loginButton.click();
            Thread.sleep(2000);

//            driver.navigate().to("https://www.bstackdemo.com");
            driver.get("https://www.bstackdemo.com");

            Thread.sleep(2000);


            driver.navigate().back();

            Thread.sleep(2000);

            // Validate successful login

//            String title = driver.getTitle();

//            if (title.equals("StackDemo")) {
//
//                System.out.println("Login successful!");
//
//            } else {
//
//                System.out.println("Login failed!");
//
//            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

            driver.quit();

        }

    }

}
