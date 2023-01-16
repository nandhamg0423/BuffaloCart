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
public class EditPageTest extends Base {
    LoginPage login;
    UserPage user;
    MyAccountPage acc;
    AddUserPage userPage;
    EditPage edit;
    Constants con;
    ExcelUtility excel = new ExcelUtility();
    WaitUtility wait=new WaitUtility();                     
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 18, enabled = true, description = "TC_018_Verify Edit User page title")
    public void verify_Edit_User_page_title() {
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
        List<String> list1 = excel.readDataFromExcel("AccountPage");
        String actualEditPageTitle= edit.getEditPageTitle();
        String expectedEditPageTitle=list1.get(21);
        Assert.assertEquals(actualEditPageTitle,expectedEditPageTitle,"Invalid message");
    }

    @Test(priority = 17, enabled = true, description = "TC_017_Verify  user can edit the user details  ")
    public void verify_user_can_edit_the_user_details() {
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
        userPage.searchUser(listForEdit.get(8));
        extentTest.get().log(Status.PASS, "Name searched successfully");
        wait.setImplicitWait(driver);
        edit = user.clickOnEditButton();
        extentTest.get().log(Status.PASS, "Edit button clicked successfully");
        userPage.enterPassword("aaaaaaa");
        userPage.enterConfirmpassword("aaaaaaa");
        user = edit.clickOnUpdateButton();
        extentTest.get().log(Status.PASS, "Update button clicked successfully");
        user=new UserPage(driver);
        wait.setImplicitWait(driver);
        String actualUpdateMessage=user.getUpdateMessage();
        String expectedUpdateMessage=listForEdit.get(34);
        Assert.assertEquals(actualUpdateMessage,expectedUpdateMessage,"Invalid Message");
    }
}