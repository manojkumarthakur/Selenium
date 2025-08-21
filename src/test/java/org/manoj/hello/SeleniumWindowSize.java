package org.manoj.hello;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumWindowSize {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://selenium.dev");

        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //maximise windows
//  maximize() provides a larger view while keeping the standard window interface visible.
//  fullscreen() provides the largest possible view by removing all surrounding window elements.
//        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        Check the dimension basically  width and height
        Dimension d = driver.manage().window().getSize();
        //        Check the position of initial point x and y
        Point point = driver.manage().window().getPosition();

//        For FullScreen width:  1512 and height: 945
        System.out.println("For FullScreen width:  " + d.width + " and height: " + d.height);
        System.out.println("For FullScreen x:  " + point.x + " and y: " + point.y);


//        For maximise width:  1200 and height: 830
//        System.out.println("For maximise width:  "+ d.width + " and height: " + d.height);

//        Set the position and then set the desired size of browser windows.
//        driver.manage().window().setPosition(new Point(0, 0));
//        driver.manage().window().setSize(new Dimension(1512, 945));

//        minimises the window
//        driver.manage().window().minimize();


        Thread.sleep(5000);
//        Thread.sleep(10000);

        driver.quit();
    }
}
