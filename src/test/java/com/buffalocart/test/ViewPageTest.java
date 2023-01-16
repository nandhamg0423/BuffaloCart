package com.buffalocart.test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class ViewPageTest extends Base {
    LoginPage login;
    UserPage user;
    MyAccountPage acc;
    AddUserPage userPage;
    EditPage edit;
    ViewPage view;
    Constants con;
    ExcelUtility excel = new ExcelUtility();
    WaitUtility wait=new WaitUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 20, enabled = true, description = "TC_020_Verify  the details displayed on view user page")
    public void verify_the_details_displayed_on_view_user_page() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("Regression");
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
        wait.setImplicitWait(driver);
        extentTest.get().log(Status.PASS, "User Management Clicked successfully");
        user = new UserPage(driver);
        user = acc.clickOnUsersLink();
        extentTest.get().log(Status.PASS, "Users link Clicked successfully");
        userPage = new AddUserPage(driver);
        List<String> listForEdit = excel.readDataFromExcel("AccountPage");
        System.out.println(listForEdit);
        userPage.searchUser("richard");
        wait.setImplicitWait(driver);
        extentTest.get().log(Status.PASS, "Name searched successfully");
        view = user.clickOnViewButton();
        extentTest.get().log(Status.PASS, "View button clicked successfully");
        String actualViewPageTitle= view.getViewPageTitle();
        String expectedViewPageTitle=listForEdit.get(22);
        Assert.assertEquals(actualViewPageTitle,expectedViewPageTitle,"Invalid title");
    }
}
