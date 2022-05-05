package com.buffalocart.test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class SalesCommissionAgentPageTest extends Base {
    LoginPage login;
    UserPage user;
    AddUserPage userPage;
    MyAccountPage acc;
    EditPage edit;
    SalesCommissionAgentPage salescommision;
    Constants con;
    ExcelUtility excel = new ExcelUtility();
    RandomDataUtility random1 = new RandomDataUtility();
    String randomMail = random1.random();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 28, enabled = true, description = "TC_028_ Verify  Sales Commission Agents page title")
    public void verify_Sales_Commission_Agents_page_title() {
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
        salescommision = acc.clickOnSalesCommissionLink();
        extentTest.get().log(Status.PASS, "SalesCommissionAgentPage Clicked successfully");
        List<String> listForUsers = excel.readDataFromExcel("AccountPage");
        String actualSalesCommisionPageTitle = listForUsers.get(26);
        String expectedSalesCommisionPageTitle = salescommision.getSalesCommisionPageTitle();
        Assert.assertEquals(actualSalesCommisionPageTitle, expectedSalesCommisionPageTitle, "Invalid Roles Title ");
    }
    @Test(priority = 29, enabled = true, description = "TC_029_ Verify  user can add sales  agent ")
    public void Verify_user_can_add_sales_agent() {
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
        salescommision = acc.clickOnSalesCommissionLink();
        extentTest.get().log(Status.PASS, "SalesCommissionAgentPage Clicked successfully");
        salescommision.clickOnAddSalesCommissionButton();
        extentTest.get().log(Status.PASS, "SalesCommission AddButton Clicked successfully");
        List<String> list1 = excel.readDataFromExcel("AccountPage");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        salescommision.enterPrefix(list1.get(27));
        salescommision.enterFirstName(list1.get(28));
        salescommision.enterLastName(list1.get(29));
        salescommision.enterEmail(randomMail);
        salescommision.enterContactNumber(list1.get(30));
        salescommision.enterAddress(list1.get(31));
        salescommision.enterSalesPercent(list1.get(32));
        salescommision.clickOnSalesCommissionSaveButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualAddedMessage=salescommision.getSalesAddedMessage();
        String expectedAddeddMessage=list1.get(41);
        Assert.assertEquals(actualAddedMessage,expectedAddeddMessage,"Invalid message");
    }

    @Test(priority = 30, enabled = true, description = "TC_030_ Verify Edit sales agent details")
    public void verify_Edit_sales_agent_details() {
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
        salescommision = acc.clickOnSalesCommissionLink();
        extentTest.get().log(Status.PASS, "SalesCommissionAgentPage Clicked successfully");
        salescommision.enterOnSearch("Edwin");
        extentTest.get().log(Status.PASS, "Name entered on search field successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        salescommision.clickOnSalesCommissionEditButton();
        extentTest.get().log(Status.PASS, "Edit Button Clicked successfully");
        List<String> list1 = excel.readDataFromExcel("AccountPage");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        salescommision.enterLastName("Marina");
        extentTest.get().log(Status.PASS, "Lastname Edited successfully");
        salescommision.clickOnSalesCommissionSaveButton();
        extentTest.get().log(Status.PASS, "Save button clicked successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualUpdatedMessage=salescommision.getUpdateMessage();
        String expectedUpdatedMessage=list1.get(39);
        Assert.assertEquals(actualUpdatedMessage,expectedUpdatedMessage,"Invalid message");
    }

    @Test(priority = 31, enabled = true, description = "TC_031_ Verify user can delete a Sales Commission Agents")
    public void verify_user_can_delete_a_Sales_Commission_Agents() {
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
        salescommision = acc.clickOnSalesCommissionLink();
        extentTest.get().log(Status.PASS, "SalesCommissionAgentPage Clicked successfully");
        salescommision.enterOnSearch("Delete");
        extentTest.get().log(Status.PASS, "Name entered on search field successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        salescommision.clickOnSalesCommissionDeleteButton();
        extentTest.get().log(Status.PASS, "Delete Button clicked successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        salescommision.clickOnOkDeleteButton();
        extentTest.get().log(Status.PASS, "Ok button clicked successfully");
        List<String> list1 = excel.readDataFromExcel("AccountPage");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualDeletedMessage=salescommision.getDeletedMessage();
        String expectedDeletedMessage=list1.get(40);
        Assert.assertEquals(actualDeletedMessage,expectedDeletedMessage,"Invalid message");
    }
}