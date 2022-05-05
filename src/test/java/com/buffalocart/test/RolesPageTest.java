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

public class RolesPageTest extends Base {
    LoginPage login;
    UserPage user;
    MyAccountPage acc;
    EditPage edit;
    Constants con;
    RolesPage role;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 21, enabled = true, description = "TC_021_ Verify Roles page title")
    public void verify_Roles_page_title() {
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
        List<String> listForUsers = excel.readDataFromExcel("AccountPage");
        String actualRolesTitle = listForUsers.get(23);
        String expectedRolesTitle = role.getRolesTitle();
        Assert.assertEquals(actualRolesTitle, expectedRolesTitle, "Invalid Roles Title ");
    }

    @Test(priority = 26, enabled = true, description = "TC_026_ Verify user can delete a role from the list ")
    public void verify_user_can_delete_a_role_from_the_list() {
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
        List<String> list1 = excel.readDataFromExcel("AccountPage");
        role.searchRole(list1.get(36));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        role.clickOnDeleteRolesButton();
        extentTest.get().log(Status.PASS, "Roles Delete Button Clicked successfully");
        role.clickOnDeleteOkButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualRoleDeletedMessage=role.getDeletedMessage();
        String expectedRoleDeletedMessage= list1.get(38);
        Assert.assertEquals(actualRoleDeletedMessage,expectedRoleDeletedMessage,"Invalid message");
    }
}
