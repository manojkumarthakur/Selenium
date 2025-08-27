package org.manoj.hello.getOrNavigate;

import org.openqa.selenium.WebDriver;
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
public class GetExample {

    public static void main(String[] args) throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();



        // Get to the initial URL

        driver.get("https://www.bstackdemo.com/");

        System.out.println("Page Title 1: " + driver.getTitle());
        Thread.sleep(2000);


        // Get to another page

        driver.get("https://www.bstackdemo.com/signin");

        System.out.println("Page Title 2: " + driver.getTitle());

        Thread.sleep(2000);


        // Navigate back to the previous page

        driver.navigate().back();

        System.out.println("After Back: " + driver.getTitle());

        Thread.sleep(2000);


        // Navigate forward

        driver.navigate().forward();

        System.out.println("After Forward: " + driver.getTitle());



        // Refresh the page

        driver.navigate().refresh();

        System.out.println("Page Refreshed: " + driver.getTitle());



        driver.quit();

    }

}