package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends ObjectUtility {
    WebDriver driver;

    /**page constructor **/


    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /***page element***/

    private final String _prefix = "//input[@id='surname']";
    @FindBy(xpath = _prefix)
    private WebElement prefix;

    private final String _firstname = "//input[@id='first_name']";
    @FindBy(xpath = _firstname)
    private WebElement firstname;

    private final String _lastname = "//input[@id='last_name']";
    @FindBy(xpath = _lastname)
    private WebElement lastname;

    private final String _email = "//input[@id='email']";
    @FindBy(xpath = _email)
    private WebElement email;

    private final String _role = "//select[@id='role']";
    @FindBy(xpath = _role)
    private WebElement role;

    private final String _username = "//input[@id='username']";
    @FindBy(xpath = _username)
    private WebElement username;

    private final String _password = "//input[@id='password']";
    @FindBy(xpath = _password)
    private WebElement password;

    private final String _confirmPassword = "//input[@id='confirm_password']";
    @FindBy(xpath = _confirmPassword)
    private WebElement confirmPassword;

    private final String _salespercent = "//input[@id='cmmsn_percent']";
    @FindBy(xpath = _salespercent)
    private WebElement salespercent;

    private final String _allowselectContactcheckbox = "//ins[@class='iCheck-helper']";
    @FindBy(xpath = _allowselectContactcheckbox)
    private WebElement allowselectContactcheckbox;

    private final String _salesContact = "//select[@class='form-control select2 select2-hidden-accessible']";
    @FindBy(xpath = _salesContact)
    private WebElement salesContact;

    private final String _saveButtonOnAddUserPage = "//button[@id='submit_user_button']";
    @FindBy(xpath = _saveButtonOnAddUserPage)
    private WebElement saveButtonOnAddUserPage;

    private final String _searchUser = "//input[@class='form-control input-sm']";
    @FindBy(xpath = _searchUser)
    private WebElement searchUser;

    private final String _userDataNotmatchMessage = "//tr[@class='odd']";
    @FindBy(xpath = _userDataNotmatchMessage)
    private WebElement userDataNotmatchMessage;

    private final String _errorMessageForEmptyField = "//label[@id='email-error']";
    @FindBy(xpath = _errorMessageForEmptyField)
    private WebElement errorMessageForEmptyField;

    private final String _profileName = "a[class='dropdown-toggle']>span";
    @FindBy(css = _profileName)
    private WebElement profileName;

    private final String _userAddedMessage = "div[class='toast-message']";
    @FindBy(css = _userAddedMessage)
    private WebElement userAddedMessage;

    /***user action***/

    public String getAddUserPageTitle() {
        String userPageTitle = page.getPageTitle(driver);
        return userPageTitle;
    }
    public void enterPrefix(String pref) {
        page.enterText(prefix, pref);
    }
    public void enterFirstname(String fName) {
        page.enterText(firstname, fName);
    }
    public void enterLastname(String lName) {
        page.enterText(lastname, lName);
    }
    public void enterEmail(String mail) {
        page.enterText(email, mail);
    }
    public void selectRole(String role1) {
    String roleDropdown=page.dropdownOptionByVisibleTest(role,role1);
    }
    public void enterUsername(String uName) {
       page.enterText(username, uName);
   }
    public void enterPassword(String pWord) {
        page.enterText(password, pWord);
    }
    public void enterConfirmpassword(String confirmpWord) {
        page.enterText(confirmPassword, confirmpWord);
    }
    public void enterSalespercentage(String percentage) {
        page.enterText(salespercent, percentage);
    }
    public void clickOnRSelectContactCheckBox() {
        page.clickOnElement(allowselectContactcheckbox);
    }
    public void selectContact(String contact) {
    String contacts=page.dropdownOptionByVisibleTest(salesContact,contact);
    }
    public UserPage clickOnSaveButton() {
        page.clickOnElement(saveButtonOnAddUserPage);
        return new UserPage(driver);
    }
    public void searchUser(String seaRch) {
        page.enterText(searchUser, seaRch);
    }
    public String getErrorMessageForEmptyField(){
        String fieldEmptyErrorMessage = page.getElementText(errorMessageForEmptyField);
        return fieldEmptyErrorMessage;
    }
    public String getUserAddedMessage() {
        String addedMessage = page.getElementText(userAddedMessage);
        return addedMessage;
    }
}
