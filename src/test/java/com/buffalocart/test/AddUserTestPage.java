package com.buffalocart.test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.UserPage;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import com.buffalocart.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class AddUserTestPage extends Base {
    LoginPage login;
    UserPage user;
    MyAccountPage acc;
    AddUserPage userPage;
    Constants con;
    ExcelUtility excel = new ExcelUtility();
    WaitUtility wait=new WaitUtility();
    RandomDataUtility random1 = new RandomDataUtility();
    String randomMail = random1.random();
    String randomId = random1.randomId();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 16, enabled = true, description = "TC_016_Verify  user can add user details")
    public void Verify_user_can_add_user_details() {
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
        userPage = user.clickOnAddButton();
        extentTest.get().log(Status.PASS, "Add button in userpage Clicked successfully");
        List<String> listAddUserPage = excel.readDataFromExcel("AccountPage");
        userPage.enterPrefix(listAddUserPage.get(7));
        extentTest.get().log(Status.PASS, "Prefix entered successfully");
        userPage.enterFirstname(listAddUserPage.get(8));
        extentTest.get().log(Status.PASS, "FirstName entered successfully");
        userPage.enterLastname(listAddUserPage.get(9));
        extentTest.get().log(Status.PASS, "LastName entered successfully");
        userPage.enterEmail(randomMail);
        extentTest.get().log(Status.PASS, "Email field is empty");
        userPage.selectRole("Editor");
        extentTest.get().log(Status.PASS, "Role entered successfully");
        userPage.enterUsername(randomId);
        extentTest.get().log(Status.PASS, "Username entered successfully");
        userPage.enterPassword(listAddUserPage.get(12));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        userPage.enterConfirmpassword(listAddUserPage.get(13));
        extentTest.get().log(Status.PASS, "Confirm Password entered successfully");
        userPage.enterSalespercentage(listAddUserPage.get(14));
        extentTest.get().log(Status.PASS, "Sales Percentage entered successfully");
        userPage.clickOnRSelectContactCheckBox();
        extentTest.get().log(Status.PASS, "Contact CheckBox Selected successfully");
        userPage.selectContact("Tom - (76)");
        extentTest.get().log(Status.PASS, "Contact selected successfully");
        userPage.clickOnSaveButton();
        String actualDataAddedMessage = userPage.getUserAddedMessage();
        String expectedDataAddedMessage = listAddUserPage.get(43);
        Assert.assertEquals(actualDataAddedMessage, expectedDataAddedMessage, "Invalid message");
    }

    @Test(priority = 13, enabled = true, description = "TC_013_Verify the error message displayed without filling mandatory fields in add user form")
    public void verify_the_error_message_displayed_without_filling_mandatory_fields_in_add_user_form() {
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
        userPage = user.clickOnAddButton();
        extentTest.get().log(Status.PASS, "Add button in userpage Clicked successfully");
        List<String> listAddUserPage = excel.readDataFromExcel("AccountPage");
        userPage.enterPrefix(listAddUserPage.get(7));
        extentTest.get().log(Status.PASS, "Prefix entered successfully");
        userPage.enterFirstname(listAddUserPage.get(8));
        extentTest.get().log(Status.PASS, "FirstName entered successfully");
        userPage.enterLastname(listAddUserPage.get(9));
        extentTest.get().log(Status.PASS, "LastName entered successfully");
        extentTest.get().log(Status.PASS, "Email field is empty");
        userPage.selectRole("Editor");
        extentTest.get().log(Status.PASS, "Role entered successfully");
        userPage.enterUsername(randomId);
        extentTest.get().log(Status.PASS, "Username entered successfully");
        userPage.enterPassword(listAddUserPage.get(12));
        extentTest.get().log(Status.PASS, "Password entered successfully");
        userPage.enterConfirmpassword(listAddUserPage.get(13));
        extentTest.get().log(Status.PASS, "Confirm Password entered successfully");
        userPage.enterSalespercentage(listAddUserPage.get(14));
        extentTest.get().log(Status.PASS, "Sales Percentage entered successfully");
        userPage.clickOnRSelectContactCheckBox();
        extentTest.get().log(Status.PASS, "Contact CheckBox Selected successfully");
        userPage.selectContact("Tom - (76)");
        extentTest.get().log(Status.PASS, "Contact selected successfully");
        userPage.clickOnSaveButton();
        extentTest.get().log(Status.PASS, "Save Button clicked successfully");
        String actualFieldErrorMessage = userPage.getErrorMessageForEmptyField();
        String expectedFieldErrorMessage = listAddUserPage.get(17);
        Assert.assertEquals(actualFieldErrorMessage, expectedFieldErrorMessage, "Invalid message");
    }

    @Test(priority = 15, enabled = true, description = "TC_015_Verify  Add Users page title")
    public void verify_Add_Users_page_title() {
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
        userPage = user.clickOnAddButton();
        extentTest.get().log(Status.PASS, "Add button in userpage Clicked successfully");
        List<String> listAddUser = excel.readDataFromExcel("AccountPage");
        String actualAddUserTitle = listAddUser.get(6);
        String expectedaddUsertitle = userPage.getAddUserPageTitle();
        Assert.assertEquals(actualAddUserTitle, expectedaddUsertitle, "Invalid Title");
        List<String> listAddUserPage = excel.readDataFromExcel("AccountPage");
    }

}
