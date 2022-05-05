package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
public class LoginPageTest extends Base {
    LoginPage login;
    MyAccountPage acc;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1, enabled = true, description = "TC_001_Verify Login Page Title")
    public void verify_Loginpage_Title() {
        extentTest.get().assignCategory("Regression");
        List<String> list = excel.readDataFromExcel("LoginPage");
        String expectedLoginPageTitle = list.get(8);
        extentTest.get().log(Status.PASS, "Login Title selected successfully");
        String actualLoginPageTitle = "Login - Demo POS";
        extentTest.get().log(Status.PASS, "Actual data got successfully");
        Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle, "Invalid Login Page Title");
        extentTest.get().log(Status.PASS, "Login successfully");
    }

    @Test(priority = 2, enabled = true, description = "TC_002_Verify user login with valid user credentials")
    public void verify_user_login_with_valid_user_credentials() {
        extentTest.get().assignCategory("Smoke");
        extentTest.get().assignCategory("Regression");
        List<String> list = excel.readDataFromExcel("LoginPage");
        login = new LoginPage(driver);
        login.enterUsername(list.get(6));
        extentTest.get().log(Status.PASS, "Username entered successfully");
        login.enterPassword(list.get(7));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        acc = login.clickOnloginButton();
        extentTest.get().log(Status.PASS, "Login Button Clicked successfully");
        acc = new MyAccountPage(driver);
        String actualUserAccountTitle = acc.getUserAccountName();
        List<String> homepageTitleList = excel.readDataFromExcel("AccountPage");
        String expectedUserAccountTitle = homepageTitleList.get(1);
        Assert.assertEquals(actualUserAccountTitle, expectedUserAccountTitle, "Invalid UserAccount Name");
    }

    @Test(priority = 3, dataProvider = "user_credentials", enabled = true, groups = {"Regression"}, description = "TC_003_Verify the error message displayed for user login with invalid credentials")
    public void verify_the_error_message_displayed_for_user_login_with_invalid_credentials(String uname, String pword) {
        extentTest.get().assignCategory("Regression");
        login = new LoginPage(driver);
        login.enterUsername(uname);
        extentTest.get().log(Status.PASS, "Username entered successfully");
        login.enterPassword(pword);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        login.clickOnRememberMeCheckBox();
        extentTest.get().log(Status.PASS, "Checkbox clicked successfully");
        acc = login.clickOnloginButton();
        extentTest.get().log(Status.PASS, "ILogin button clicked successfully");
        String expectedErrorMessage = "These credentials do not match our records.";
        String actualErrorMessage = login.getLoginFailedMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Logged In-Having Error in Login");
    }

    @DataProvider(name = "user_credentials")
    public Object[][] userLoginData() {
        Object[][] data = excel.getData("Login_invalidCredetials");
        return data;
    }

    @Test(priority = 4, enabled = true, description = "TC_004_Verify whetehr the user is able to click on 'Remember me' checkbox")
    public void verify_whether_the_user_is_able_to_click_on_Remember_me_checkbox() {
        extentTest.get().assignCategory("Regression");
        List<String> list = excel.readDataFromExcel("LoginPage");
        login = new LoginPage(driver);
        login.clickOnRememberMeCheckBox();
        extentTest.get().log(Status.PASS, "Checkbox clicked successfully");
        Boolean checkBoxSelectionStatus = login.getRememberMeCheckBoxSelectionStatus();
        Assert.assertTrue(checkBoxSelectionStatus, "Remember me checkbox not selected");
        extentTest.get().log(Status.PASS, "Remember me selected successfully");
    }

    @Test(priority = 14, enabled = true, description = "TC_014_Verify user login with newly added user")
    public void verify_user_login_with_newly_added_user() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("Regression");
        List<String> list = excel.readDataFromExcel("AccountPage");
        System.out.println(list);
        login.enterUsername(list.get(18));
        extentTest.get().log(Status.PASS, "Registered username entered successfully");
        login.enterPassword(list.get(19));
        extentTest.get().log(Status.PASS, "Registered Password entered successfully");
        acc = login.clickOnloginButton();
        extentTest.get().log(Status.PASS, "Login Button Clicked successfully");
        String actualUserAccountTitle = acc.getUserAccountName();
        List<String> homepageTitleList = excel.readDataFromExcel("AccountPage");
        String expectedUserAccountTitle = homepageTitleList.get(20);
        Assert.assertEquals(actualUserAccountTitle, expectedUserAccountTitle, "Invalid UserAccount Name");
    }
}
