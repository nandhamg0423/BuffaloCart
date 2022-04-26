package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginPageTest extends Base {
    LoginPage login;
    HomePage home;
    MyAccountPage acc;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1, enabled = true, description = "TC_001_Verify Login Page Title")
    public void verify_Loginpage_Title() throws IOException {
        extentTest.get().assignCategory("Regression");
        List<String> list = excel.readDataFromExcel("LoginPage");
        System.out.println(list);
        String expected = list.get(8);
        extentTest.get().log(Status.PASS, "Login Title selected successfully");
        String actual = "Login - Demo POS";
        extentTest.get().log(Status.PASS, "Actual data got successfully");
        Assert.assertEquals(expected, actual, "Invalid Login Title");
        extentTest.get().log(Status.PASS, "Login successfully");
    }

    @Test(priority = 2, enabled = true, description = "TC_002_Verify Login")
    public void verify_user_login_with_valid_user_credentials() throws IOException {
        extentTest.get().assignCategory("Smoke");
        extentTest.get().assignCategory("Regression");
        List<String> list = excel.readDataFromExcel("LoginPage");
        login = new LoginPage(driver);
        login.enterUsername(list.get(7));
        extentTest.get().log(Status.PASS, "Username selected successfully");
        login.enterPassword(list.get(8));
        extentTest.get().log(Status.PASS, "Password selected successfully");
        acc = login.loginButton();
        extentTest.get().log(Status.PASS, "Login Button Clicked successfully");
    }

    @Test(priority = 3, enabled = true, description = "TC_003_Verify Error Message")
    public void Verify_the_error_message_displayed_for_user_login_with_invalid_credentials() throws IOException {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        List<String> list = excel.readDataFromExcel("LoginPage");
        login.enterUsername(list.get(6));
        extentTest.get().log(Status.PASS, "Invalid Username selected successfully");
        login.enterPassword(list.get(11));
        extentTest.get().log(Status.PASS, "Invalid password selected successfully");
        acc = login.loginButton();
        extentTest.get().log(Status.PASS, "Login Button Clicked successfully");
        System.out.println(list);
        String actual = list.get(9);
        extentTest.get().log(Status.PASS, "Actual password got successfully");
        String expected = login.getFailedMessage();
        Assert.assertEquals(actual, expected, "Not correct message");
        extentTest.get().log(Status.PASS, "Error message found successfully");
    }

    @Test(priority = 4, enabled = true, description = "TC_003_Verify Remember Me")
    public void Verify_whether_the_user_is_able_to_click_on_Remember_me_checkbox() throws IOException {
        extentTest.get().assignCategory("Regression");
        List<String> list = excel.readDataFromExcel("LoginPage");
        login = new LoginPage(driver);
        login.enterUsername(list.get(6));
        extentTest.get().log(Status.PASS, "Username selected successfully");
        login.enterPassword(list.get(7));
        extentTest.get().log(Status.PASS, "Password selected successfully");
        login.rememberMe();
        extentTest.get().log(Status.PASS, "Remember me selected successfully");
        acc = login.loginButton();
        extentTest.get().log(Status.PASS, "Invalid password selected successfully");
    }

}
