package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class AddRolesTestPage extends Base {
    LoginPage login;
    UserPage user;
    MyAccountPage acc;
    AddUserPage userPage;
    EditPage edit;
    ViewPage view;
    RolesPage role;
    AddRolesPage addrole;
    Constants con;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 22, enabled = true, description = "TC_0220_ VVerify Add Roles page title ")
    public void verify_Add_Roles_page_title() {
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "User Management Clicked successfully");
        role = new RolesPage(driver);
        role = acc.clickOnRoleLink();
        extentTest.get().log(Status.PASS, "Users Clicked successfully");
        addrole = role.clickOnAddRolesButton();
        extentTest.get().log(Status.PASS, "Add roles Clicked successfully");
        List<String> listForUsers = excel.readDataFromExcel("AccountPage");
        String actualRolesTitle = listForUsers.get(24);
        String expectedRolesTitle = role.getRolesTitle();
        Assert.assertEquals(actualRolesTitle, expectedRolesTitle, "Invalid Roles Title ");
    }

    @Test(priority = 23, enabled = true, description = "TC_023_ Verify  user can add roles")
    public void verify_user_can_add_roles() {
        login = new LoginPage(driver);
        extentTest.get().assignCategory("Smoke");
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS, "User Management Clicked successfully");
        role = new RolesPage(driver);
        role = acc.clickOnRoleLink();
        extentTest.get().log(Status.PASS, "Users Clicked successfully");
        addrole = role.clickOnAddRolesButton();
        extentTest.get().log(Status.PASS, "Add roles Clicked successfully");
        List<String> listForRoleName = excel.readDataFromExcel("AccountPage");
        addrole.enterRoleName(listForRoleName.get(36));
        addrole.clickOnSaveButton();
        extentTest.get().log(Status.PASS, "Save Button Clicked successfully");
        List<String> listForUsers = excel.readDataFromExcel("AccountPage");
        String actualRolesTitle = listForUsers.get(23);
        String expectedRolesTitle = role.getRolesTitle();
        Assert.assertEquals(actualRolesTitle, expectedRolesTitle, "Invalid Roles Title ");
    }
}