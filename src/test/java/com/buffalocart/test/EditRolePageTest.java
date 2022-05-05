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

public class EditRolePageTest extends Base {
    LoginPage login;
    UserPage user;
    MyAccountPage acc;
    EditPage edit;
    Constants con;
    RolesPage role;
    EditRolePage editrolepage;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 24, enabled = true, description = "TC_024_ Verify Edit Role page title")
    public void verify_Edit_Role_page_title() {
        login = new LoginPage(driver);
        //extentTest.get().assignCategory("Regression");
        List<String> list = excel.readDataFromExcel("LoginPage");
        login.enterUsername(list.get(6));
        //extentTest.get().log(Status.PASS, "Username entered successfully");
        login.enterPassword(list.get(7));
        //extentTest.get().log(Status.PASS, "Password entered successfully");
        acc = login.clickOnloginButton();
        //extentTest.get().log(Status.PASS, "Login Button Clicked successfully");
        acc.clickOnEndTour();
        //extentTest.get().log(Status.PASS, "End Tour Button Clicked successfully");
        acc.clickOnUserManagement();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //extentTest.get().log(Status.PASS, "User Management Clicked successfully");
        role=new RolesPage(driver);
        role = acc.clickOnRoleLink();
        //extentTest.get().log(Status.PASS, "Users Clicked successfully");
        List<String> list1 = excel.readDataFromExcel("AccountPage");
        role.searchRole(list1.get(36));
        //extentTest.get().log(Status.PASS, "Role searched successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        editrolepage=role.clickOnEditRolesButton();
        //extentTest.get().log(Status.PASS, "Edit button on role page clicked successfully");
        String actualEditRolePage= editrolepage.getEditRolePageTitle();
        String expectedEditRolePage=list1.get(42);
        Assert.assertEquals(actualEditRolePage,expectedEditRolePage,"invalid message");
    }

    @Test(priority = 25, enabled = true, description = "TC_025_ Verify user can update  a role ")
    public void verify_user_can_update_a_role () {
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
        role=new RolesPage(driver);
        role = acc.clickOnRoleLink();
        extentTest.get().log(Status.PASS, "Users Clicked successfully");
        List<String> list1 = excel.readDataFromExcel("AccountPage");
        role.searchRole(list1.get(36));
        //extentTest.get().log(Status.PASS, "Role searched successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        editrolepage=role.clickOnEditRolesButton();
        extentTest.get().log(Status.PASS, "Edit Button clicked on roles page successfully");
        editrolepage.enterEditRolePageValue("Edited");
        extentTest.get().log(Status.PASS, "Field edited successfully");
        editrolepage.clickOnUpdateRolesButton();
        extentTest.get().log(Status.PASS, "Save Button clicked in edit role page successfully");
        String actualRoleUpdatedMessage= editrolepage.getRoleUpdateMessage();
        String expectedRoleUpdatedMessage=list1.get(37);
        Assert.assertEquals(actualRoleUpdatedMessage,expectedRoleUpdatedMessage,"Invalid data");
    }
}
