package com.learning.tests;

import static com.learning.constants.FrameworkConstants.ASSERTION_FOR;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learning.annotations.FrameworkAnnotation;
import com.learning.driver.DriverManager;
import com.learning.enums.AuthorType;
import com.learning.enums.CategoryType;
import com.learning.pages.LoginPage;
import com.learning.testdata.TestData;
import com.learning.utils.DataProviderUtils;
import com.learning.utils.VerificationUtils;

public class LoginTest extends BaseTest {

    @FrameworkAnnotation(author = {AuthorType.RAJAT, AuthorType.NISHANT},
            category = {CategoryType.BVT, CategoryType.REGRESSION})
    @Test(groups = {"BVT","REGRESSION"},description = "To check whether the User can not login with Invalid Credentials",
            dataProvider = "getTestData", dataProviderClass = DataProviderUtils.class)
    public void errorInvalidCredentials(TestData testData) {

        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication(testData.getUsername(), testData.getPassword());
        String errorInvalidCreds =  loginPage.getErrorMessage();

//        Assert.assertEquals(errorInvalidCreds, testData.getExpectedError(),
//                "Assertion for Invalid credentials Error message");

        VerificationUtils.validateResponse(errorInvalidCreds,testData.getExpectedError(),
                ASSERTION_FOR +" -  <b> <u> Invalid credentials Error message </b> </u>");

    }


    /**
     * --------------------------------------------------------------------- (2nd time)
     */
//    @FrameworkAnnotation(author = { AuthorType.RAJAT, AuthorType.NISHANT},
//            category = {  CategoryType.BVT,CategoryType.REGRESSION })
//    @Test(description = "To check whether the User can not login with Invalid Credentials",
//    dataProvider = "getInvalidLoginData",dataProviderClass = DataProviderUtils.class)
    public void REFERENCE_errorInvalidCredentials(String username, String password, String expectedError) {

        LoginPage loginPage = new LoginPage();
//        loginPage.setUsername("Admin");
//        loginPage.setPassword("admin1234");
//        loginPage.setUsername(username);
//        loginPage.setPassword(password);
//        loginPage.clickLogin();

//          Method Chaining
//        loginPage
//                .setUsername(username)
//                .setPassword(password)
//                .clickLogin();
        loginPage.loginToApplication(username, password);

        String errorInvalidCreds = DriverManager.getDriver().findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorInvalidCreds, expectedError,
                "Assertion for Invalid credentials Error message");
    }


    /**
     * --------------------------------------------------------------------- (1st time)
     */

    // @Test(description = "To check whether the User can not login with Invalid Credentials")
    public void REFERENCE__errorInvalidCredentials() {
//        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//        driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
//        driver.findElement(By.id("btnLogin")).click();
        // holdScript(3);

//        Driver.threadLocal.get().findElement(By.id("txtUsername")).sendKeys("Admin");
//        Driver.threadLocal.get().findElement(By.id("txtPassword")).sendKeys("admin1234");
//        Driver.threadLocal.get().findElement(By.id("btnLogin")).click();

//        DriverManager.getDriver().findElement(By.id("txtUsername")).sendKeys("Admin");
//        DriverManager.getDriver().findElement(By.id("txtPassword")).sendKeys("admin1234");
//        DriverManager.getDriver().findElement(By.id("btnLogin")).click();

//        LoginPage loginPage =new LoginPage();
//        loginPage.setUsername("Admin");
//        loginPage.setPassword("admin1234");
//        loginPage.clickLogin();

//        String errorInvalidCreds =  Driver.driver.findElement(By.id("spanMessage")).getText();
        //   String errorInvalidCreds =  Driver.threadLocal.get().findElement(By.id("spanMessage")).getText();
        String errorInvalidCreds = DriverManager.getDriver().findElement(By.id("spanMessage")).getText();


        //        Assert.assertEquals(errorInvalidCreds, "Invalid credentials",
//                "Assertion for Invalid credentials Error message");
        Assert.assertEquals(errorInvalidCreds, "无效的凭证",
                "Assertion for Invalid credentials Error message");


    }
}
