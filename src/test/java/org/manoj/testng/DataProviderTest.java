package org.manoj.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][] {
                {"user1", "pass1"},
                {"user2", "pass2"},
                {"invalidUser", "invalidPass"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Testing login with username: " + username + " and password: " + password);
        // Add your actual login test logic here
    }
}
