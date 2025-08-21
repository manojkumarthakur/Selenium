package org.manoj.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

// NoSuchWindowException if window is closed manually
//  For handling native system windows (e.g., file upload dialogs), you need to use external tools like AutoIT or Robot class in Java.
public class WindowHandles {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

// Step 1: Open LinkedIn login page
        driver.get("https://www.linkedin.com/login");

// Step 2: Store the parent window handle
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Handle: " + parentWindow);

// Step 3: Click on the "Sign in with Google" button
        driver.findElement(By.xpath("//span[text()='Continue with Google']")).click();

// Step 4: Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All Window Handles: " + allWindowHandles);
        System.out.println("All Window Handles size: " + allWindowHandles.size());


// Step 5: Iterate through the window handles and switch to the child window (Google login window)
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindow)) {
                // Switch to Google login window
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to Google Login Window: " + driver.getTitle());

                // Step 6: Perform actions in the Google login window (e.g., enter email and password)
                driver.findElement(By.id("identifierId")).sendKeys("your-email@gmail.com");
                driver.findElement(By.xpath("//span[text()='Next']")).click();

                // Assuming you have a wait to handle loading and next steps, you would perform further login steps here
                break;
            }
        }
        Thread.sleep(2000);
        // NoSuchWindowException if window is closed manually
        driver.close();
        Thread.sleep(2000);
// Step 7: After completing the Google login, switch back to the LinkedIn window
        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to Parent Window: " + driver.getTitle());
        Thread.sleep(2000);
        driver.quit();
    }
}
