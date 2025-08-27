package org.manoj.hello.synchronize;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OtherTimeoutsExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Duration duration = Duration.ofSeconds(30);
        /*PageLoadTimeout Command
This command establishes the time WebDriver must wait for a page to completely load before triggering an error.
In case the timeout set is negative, the page load time can be indefinite.*/
        driver.manage().timeouts().pageLoadTimeout(duration);
        /*SetScriptTimeout Command
This command establishes the time WebDriver will wait for an asynchronous script to finish executing before triggering an error.
 Like the previous command, the script will run indefinitely if the timeout is set to a negative value.*/
        driver.manage().timeouts().scriptTimeout(duration);

        /*Sleep Command
Thread Sleep command is rarely used because it is quite ineffective. It causes WebDriver to wait for a specific time (and does not let it run faster even if the specified condition is met).
    In fact, Selenium wait commands are considered the smarter, more effective alternative to the Sleep command.*/

        Thread.sleep(5000);
    }
}
