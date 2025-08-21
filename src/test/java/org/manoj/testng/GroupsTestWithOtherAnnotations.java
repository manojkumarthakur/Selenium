package org.manoj.testng;

import org.testng.annotations.*;

// @BeforeGroups runs before every time a group is encountered in @Test, it run before @BeforeMethod
// @BeforeMethod always runs before any method
// On running from suite.xml, we need to explicitly pass the groups to be used or alwaysRun = true in all @Before and
// @After annotations. Else those will be skipped
public class GroupsTestWithOtherAnnotations {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass(groups = {"smoke", "regression"})
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeGroups({"smoke", "regression"})
    public void beforeGroup(){
        System.out.println("Before Group");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @Test(groups = {"smoke", "regression"})
    public void testLogin() {
        // Test login functionality
        System.out.println("smoke " + "regression");
    }

    @Test(groups = {"sanity"})
    public void testHomePageLoad() {
        // Test home page loading
        System.out.println("sanity");
    }

    @Test(groups = {"regression", "database"})
    public void testDataIntegrity() {
        // Test data integrity
        System.out.println("regression " + "database");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterGroups({"smoke", "regression"})
    public void afterGroup(){
        System.out.println("After Group");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}
