package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPasswordPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class ResetPasswordPageTest extends Base {
    LoginPage login;
    ResetPasswordPage reset;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 5, enabled = true, description = "TC_005_Verify error meesage displyed on  Reset Password page with invalid email id")
    public void verify_error_message_displyed_on_Reset_Password_page_with_invalid_email_id(){
        extentTest.get().assignCategory("Regression");
        extentTest.get().assignCategory("Sanity");
        login=new LoginPage(driver);
        reset=login.clickOnForgotLink();
        extentTest.get().log(Status.PASS, "Forgot link Clicked");
        reset.enterEmailid("agsfdrrrr@gmail.com");
        extentTest.get().log(Status.PASS, "Invalid email id entered successfully");
        reset.clickOnResetButton();
        extentTest.get().log(Status.PASS, "Reset button clicked successfully");
        List<String> list = excel.readDataFromExcel("LoginPage");
        System.out.println(list);
        String actualErrorMessage=reset.getResetErrorMessage();
        String expectedErrorMessage=list.get(10);
        extentTest.get().log(Status.PASS, "Actual reset password error got successfully");
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Invalid error message displayed");
    }
}
