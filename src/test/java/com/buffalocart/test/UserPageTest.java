package com.buffalocart.test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.Converter;
import org.testng.annotations.Test;
import java.util.List;

public class UserPageTest extends Base {
    LoginPage login;
    UserPage user;
    AddUserPage userPage;
    MyAccountPage acc;
    EditPage edit;
    Constants con;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 10, enabled = true, description = "TC_010_Verify Users page title")
    public void verify_Users_page_title() {
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
        user = new UserPage(driver);
        user = acc.clickOnUsersLink();
        extentTest.get().log(Status.PASS, "Users Clicked successfully");
        List<String> listForUsers = excel.readDataFromExcel("AccountPage");
        String actualUsersTitle = listForUsers.get(5);
        String expectedUsersTitle = user.getUserTitle();
        Assert.assertEquals(actualUsersTitle, expectedUsersTitle, "Invalid Users Title ");
    }

    @Test(priority = 11, enabled = true, description = "TC_011_Verify user search with valid data")
    public void verify_user_search_with_valid_data() {
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
        user = new UserPage(driver);
        user = acc.clickOnUsersLink();
        List<String> listAddUserPage = excel.readDataFromExcel("AccountPage");
        System.out.println(listAddUserPage);
        user.searchUser(listAddUserPage.get(8));
        extentTest.get().log(Status.PASS, "Name searched successfully");
        String actualSearchName=user.getSearchFieldName();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //String expectedSearchName=user.getDisplayedName();
        //Assert.assertEquals(actualSearchName,expectedSearchName,"Invalid search data");
    }

    @Test(priority = 12, enabled = true, description = "TC_012_Verify message displayed by  user search with invalid data")
    public void verify_message_displayed_by_user_search_with_invalid_data() {
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
        user = new UserPage(driver);
        user = acc.clickOnUsersLink();
        extentTest.get().log(Status.PASS, "Users link Clicked successfully");
        List<String> listAddUserPage = excel.readDataFromExcel("AccountPage");
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user = new UserPage(driver);
        user.searchUser(listAddUserPage.get(15));
        extentTest.get().log(Status.PASS, "Invalid data entered successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualUserDataMessage = user.getInvalidDataMessage();
        String expectedUserDataMessage = listAddUserPage.get(16);
        Assert.assertEquals(actualUserDataMessage, expectedUserDataMessage, "Invalid data");
    }
    @Test(priority = 19, enabled = true, description = "TC_019_Verify user can delete a user")
    public void verify_user_can_delete_a_user() {
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
        user = new UserPage(driver);
        user = acc.clickOnUsersLink();
        extentTest.get().log(Status.PASS, "Users link Clicked successfully");
        userPage = new AddUserPage(driver);
        List<String> listForEdit = excel.readDataFromExcel("AccountPage");
        userPage.searchUser("Tinu");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.clickOnDeleteButton();
        extentTest.get().log(Status.PASS, "Delete button Clicked successfully");
        user.clickOnOkButton();
        extentTest.get().log(Status.PASS, "Ok button Clicked successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualDeletedMessage = user.getDeletedMessage();
        String expectedDeletedMessage = listForEdit.get(35);
        Assert.assertEquals(actualDeletedMessage, expectedDeletedMessage, "Invalid data");
    }
}
