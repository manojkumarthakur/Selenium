package org.manoj.testng;

import org.testng.annotations.*;


public class GroupsTest {

    @Test(groups = {"smoke", "regression"})
    public void testLogin() {
        // Test login functionality
        System.out.println("smoke" + "regression");
    }

    @Test(groups = {"sanity"})
    public void testHomePageLoad() {
        // Test home page loading
        System.out.println("sanity");
    }

    @Test(groups = {"regression", "database"})
    public void testDataIntegrity() {
        // Test data integrity
        System.out.println("regression" + "database");
    }
}
