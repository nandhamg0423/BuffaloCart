package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesCommissionAgentPage extends ObjectUtility {
    WebDriver driver;
    public SalesCommissionAgentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /***page element***/

    private final String _addsalescommission = "/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button";
    @FindBy(xpath = _addsalescommission)
    private WebElement addsalescommission;

    private final String _prefix = "//label[@for='surname']/following-sibling::input";
    @FindBy(xpath = _prefix)
    private WebElement prefix;

    private final String _firstname = "//label[@for='first_name']/following-sibling::input";
    @FindBy(xpath = _firstname)
    private WebElement firstname;

    private final String _lastname = "//label[@for='last_name']/following-sibling::input";
    @FindBy(xpath = _lastname)
    private WebElement lastname;

    private final String _email = "//label[@for='email']/following-sibling::input";
    @FindBy(xpath = _email)
    private WebElement email;

    private final String _contactnum = "//label[@for='contact_no']/following-sibling::input";
    @FindBy(xpath = _contactnum)
    private WebElement contactnum;

    private final String _address = "//label[@for='address']/following-sibling::textarea";
    @FindBy(xpath = _address)
    private WebElement address;

    private final String _salespercent = "//label[@for='cmmsn_percent']/following-sibling::input";
    @FindBy(xpath = _salespercent)
    private WebElement salespercent;

    private final String _salesCommissionSaveButton = "//button[@class='btn btn-primary']";
    @FindBy(xpath = _salesCommissionSaveButton)
    private WebElement salesCommissionSaveButton;

    private final String _searchOnSalesCommissionPage = "//input[@class='form-control input-sm']";
    @FindBy(xpath = _searchOnSalesCommissionPage)
    private WebElement searchOnSalesCommissionPage;

    private final String _salesCommissionEditButton = "//button[@class='btn btn-xs btn-modal btn-primary']";
    @FindBy(xpath = _salesCommissionEditButton)
    private WebElement salesCommissionEditButton;

    private final String _salesCommissionDeleteButton = "//button[@class='btn btn-xs btn-modal btn-primary']/following-sibling::button";
    @FindBy(xpath = _salesCommissionDeleteButton)
    private WebElement salesCommissionDeleteButton;

    private final String _okButtonOnDeletePopUp = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
    @FindBy(xpath = _okButtonOnDeletePopUp)
    private WebElement okButtonOnDeletePopUp;

    private final String _updateMessage = "div[class='toast-message']";
    @FindBy(css = _updateMessage)
    private WebElement updateMessage;

    private final String _okButtonForDelete = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
    @FindBy(xpath = _okButtonForDelete)
    private WebElement okButtonForDelete;

    private final String _deletedMessage = "div[class='toast-message']";
    @FindBy(css = _deletedMessage)
    private WebElement deletedMessage;

    private final String _salesAddedMessage = "div[class='toast-message']";
    @FindBy(css = _salesAddedMessage)
    private WebElement salesAddedMessage;

    /***user action***/

    public String getSalesCommisionPageTitle() {
        String salesCommisionTitle = page.getPageTitle(driver);
        return salesCommisionTitle;
    }
    public SalesCommissionAgentPage clickOnAddSalesCommissionButton() {
        page.clickOnElement(addsalescommission);
        return new SalesCommissionAgentPage(driver);
    }
    public void enterPrefix(String pf) {
        page.enterText(prefix, pf);
    }
    public void enterFirstName(String fname) {
        page.enterText(firstname, fname);
    }
    public void enterLastName(String lname) {
        page.enterText(lastname, lname);
    }
    public void enterEmail(String em) {
        page.enterText(email, em);
    }
    public void enterContactNumber(String contactno) {
        page.enterText(contactnum, contactno);
    }
    public void enterAddress(String add) {
        page.enterText(address, add);
    }
    public void enterSalesPercent(String sPercent) {
        page.enterText(salespercent, sPercent);
    }
    public SalesCommissionAgentPage clickOnSalesCommissionSaveButton() {
        page.clickOnElement(salesCommissionSaveButton);
        return new SalesCommissionAgentPage(driver);
    }
    public void enterOnSearch(String s) {
        page.enterText(searchOnSalesCommissionPage, s);
    }
    public SalesCommissionAgentPage clickOnSalesCommissionEditButton() {
        page.clickOnElement(salesCommissionEditButton);
        return new SalesCommissionAgentPage(driver);
    }
    public SalesCommissionAgentPage clickOnSalesCommissionDeleteButton() {
        page.clickOnElement(salesCommissionDeleteButton);
        return new SalesCommissionAgentPage(driver);
    }
    public SalesCommissionAgentPage clickOnOkDeleteButton() {
        page.clickOnElement(okButtonOnDeletePopUp);
        return new SalesCommissionAgentPage(driver);
    }
    public String getUpdateMessage() {
        String updateMessagee = page.getElementText(updateMessage);
        return updateMessagee;
    }
    public String getDeletedMessage() {
        String deleteMessage = page.getElementText(deletedMessage);
        return deleteMessage;
    }
    public UserPage clickOnOkButton() {
        page.clickOnElement(okButtonForDelete);
        return new UserPage(driver);
    }
    public String getSalesAddedMessage() {
        String addedMessage = page.getElementText(salesAddedMessage);
        return addedMessage;
    }
}
