package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.UserPage;
import com.buffalocart.utilities.DateUtility;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.ObjectUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyAccountPageTest extends Base {
    LoginPage login;
    MyAccountPage acc;
    UserPage user;
    ExcelUtility excel = new ExcelUtility();
    DateUtility date = new DateUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 6, enabled = true, description = "TC_006_Verify Home Page Title")
    public void verify_home_page_tilte() {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        List<String> list = excel.readDataFromExcel("LoginPage");
        login.enterUsername(list.get(6));
        extentTest.get().log(Status.PASS, "Username entered successfully");
        login.enterPassword(list.get(7));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        acc = login.clickOnloginButton();
        extentTest.get().log(Status.PASS, "Login Button Clicked successfully");
        List<String> accountPageList = excel.readDataFromExcel("AccountPage");
        String actualHomePageTitle = accountPageList.get(3);
        extentTest.get().log(Status.PASS, "Actual title entered successfully");
        String expectedHomePageTitle = acc.getHomePageTitle();
        extentTest.get().log(Status.PASS, "Expected title entered successfully");
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "invalid Home Page Title");
    }

    @Test(priority = 7, enabled = true, description = "TC_007_Verify date displayed in home page ")
    public void Verify_date_displeyed_in_home_page() {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        List<String> list = excel.readDataFromExcel("LoginPage");
        login.enterUsername(list.get(6));
        extentTest.get().log(Status.PASS, "Username entered successfully");
        login.enterPassword(list.get(7));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        acc = login.clickOnloginButton();
        extentTest.get().log(Status.PASS, "Login Button Clicked successfully");
        acc.clickOnEndTour();
        extentTest.get().log(Status.PASS, "End Tour Button Clicked successfully");
        String actualDate = acc.getMyAccountPageDate();
        String expectedDate = date.dateOfPage();
        Assert.assertEquals(actualDate, expectedDate, "Invalid page date");
    }

    @Test(priority = 8, enabled = true, description = "TC_008_Verify whether user is navigating to login page by clicking on Sign out button")
    public void Verify_whether_user_is_navigating_to_login_page_by_clicking_on_Sign_out_button() {
        extentTest.get().assignCategory("Smoke");
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        List<String> list = excel.readDataFromExcel("LoginPage");
        login.enterUsername(list.get(6));
        extentTest.get().log(Status.PASS, "Username entered successfully");
        login.enterPassword(list.get(7));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        acc = login.clickOnloginButton();
        extentTest.get().log(Status.PASS, "Login Button Clicked successfully");
        acc.clickOnEndTour();
        extentTest.get().log(Status.PASS, "End Tour Button Clicked successfully");
        acc.clickOnAccountName();
        extentTest.get().log(Status.PASS, "Account Name Clicked successfully");
        acc.clickOnSignout();
        extentTest.get().log(Status.PASS, "SignOut Button Clicked successfully");
        String actualLoginTitle = login.getLoginPageTitle();
        List<String> listLoginTitle = excel.readDataFromExcel("LoginPage");
        String expectedLoginTitle = listLoginTitle.get(8);
        Assert.assertEquals(actualLoginTitle, expectedLoginTitle, "Invalid login page Title");
    }

    @Test(priority = 9, enabled = true, description = "TC_009_Verify the Usermanagement sub tabs")
    public void Verify_the_Usermanagement_sub_tabs() {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        List<String> list = excel.readDataFromExcel("LoginPage");
        login.enterUsername(list.get(6));
        extentTest.get().log(Status.PASS, "Username entered successfully");
        login.enterPassword(list.get(7));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        acc = login.clickOnloginButton();
        extentTest.get().log(Status.PASS, "Login Button Clicked successfully");
        acc.clickOnEndTour();
        extentTest.get().log(Status.PASS, "End Tour Button Clicked successfully");
        acc.clickOnUserManagement();
    }
}
