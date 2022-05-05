package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyAccountPage extends ObjectUtility {
    WebDriver driver;

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**page elements**/

    private final String _profileName = "a[class='dropdown-toggle']>span";
    @FindBy(css = _profileName)
    private WebElement profileName;

    private final String _currentDate = "div[class='m-8 pull-left mt-15 hidden-xs']>strong";
    @FindBy(css = _currentDate)
    private WebElement currentDate;

    private final String _endtour= "//button[@class='btn btn-default btn-sm']";
    @FindBy(xpath = _endtour)
    private WebElement endtour;

    private final String _signout= "//div[@class='pull-right']/child::a";
    @FindBy(xpath = _signout)
    private WebElement signout;

    private final String _userManagement= "//span[text()='User Management']";
    @FindBy(xpath = _userManagement)
    private WebElement userManagement;

    private final String _userManagementUsers= "//li[2]/ul/li[1]/a/span";
    @FindBy(xpath = _userManagementUsers)
    private WebElement userManagementUsers;

    private final String _userManagementRoles= "//li[@class='active active-sub']//a//span";
    @FindBy(xpath = _userManagementRoles)
    private WebElement userManagementRoles;

    private final String _userManagementSalesCommission= "body > div.wrapper > aside > section > ul > li.treeview.active-sub.active > ul > li:nth-child(3) > a > span";
    @FindBy(css = _userManagementSalesCommission)
    private WebElement userManagementSalesCommission;

    private final String _userManagementCommonPath= "//span[starts-with(@class,'title')]";
    @FindBy(xpath = _userManagementCommonPath)
    private WebElement userManagementCommonPath;

    private final String _userslink = "//ul[@class='treeview-menu menu-open']//i[@class='fa fa-user']";
    @FindBy(xpath = _userslink)
    private WebElement userslink;

    private final String _rolelink = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[2]/a/span";
    @FindBy(xpath = _rolelink)
    private WebElement rolelink;

    private final String _salesCommission = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[3]/a/span";
    @FindBy(xpath = _salesCommission)
    private WebElement salesCommission;

    /**user action methods**/

    public String getUserAccountName() {
        String accountPageTitle = page.getElementText(profileName);
        return accountPageTitle;
    }
    public String getHomePageTitle() {
        String accountPageTitle = page.getPageTitle(driver);
        return accountPageTitle;
    }
    public String getMyAccountPageDate(){
        String myAccountPageDate = page.getElementText(currentDate);
        return myAccountPageDate;
    }
    public MyAccountPage clickOnEndTour() {
        page.clickOnElement(endtour);
        return new MyAccountPage(driver);
    }
    public MyAccountPage clickOnAccountName() {
        page.clickOnElement(profileName);
        return new MyAccountPage(driver);
    }
    public MyAccountPage clickOnSignout() {
        page.clickOnElement(signout);
        return new MyAccountPage(driver);
    }
    public MyAccountPage clickOnUserManagement() {
        page.clickOnElement(userManagement);
        return new MyAccountPage(driver);
    }
    public String commonPathForManagementList(){
        String commonPath= page.getElementText(userManagementCommonPath);
        return commonPath;
    }
    public UserPage clickOnUsersLink() {
        page.clickOnElement(userslink);
        return new UserPage(driver);
    }
    public RolesPage clickOnRoleLink() {
        page.clickOnElement(rolelink);
        return new RolesPage(driver);
    }
    public SalesCommissionAgentPage clickOnSalesCommissionLink() {
        page.clickOnElement(salesCommission);
        return new SalesCommissionAgentPage(driver);
    }
}
