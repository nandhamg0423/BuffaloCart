package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPasswordPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ResetPasswordPageTest extends Base {
    LoginPage login;
    HomePage home;
    ResetPasswordPage reset;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 5, enabled = true, description = "TC_005_Reset Password Error Message")
    public void Verify_error_message_displyed_on_Reset_Password_page_with_invalid_email_id() throws IOException {
        extentTest.get().assignCategory("Regression");
        login=new LoginPage(driver);
        reset=login.clickOnForgot();
        extentTest.get().log(Status.PASS, "Forgot link Clicked");
        reset.invalidEmailForForgot("agsfdrrrr@gmail.com");
        extentTest.get().log(Status.PASS, "Invalid email id entered successfully");
        reset.resetButton();
        extentTest.get().log(Status.PASS, "Reset button clicked successfully");
        List<String> list = excel.readDataFromExcel("LoginPage");
        String expected=list.get(10);
        String actual=reset.getResetErrorMessage();
        extentTest.get().log(Status.PASS, "Actual reset password error got successfully");
        Assert.assertEquals(actual,expected,"Not error message");
    }
}
