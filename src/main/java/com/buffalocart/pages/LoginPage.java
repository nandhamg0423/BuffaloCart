package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends ObjectUtility {
    WebDriver driver;

    /** page constructor **/

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** page elements **/

    private final String _username = "//input[@id='username']";
    @FindBy(xpath = _username)
    private WebElement username;

    private final String _password = "//input[@id='password']";
    @FindBy(xpath = _password)
    private WebElement password;

    private final String _loginButton = "//button[@class='btn btn-primary']";
    @FindBy(xpath = _loginButton)
    private WebElement loginButton;

    private final String _rememberMe = "//input[@name='remember']";
    @FindBy(xpath = _rememberMe)
    private WebElement rememberMe;

    private final String _invalidCredential = "//span[@class='help-block']/child::strong";
    @FindBy(xpath = _invalidCredential)
    private WebElement invalidCredential;

    private final String _emailError = "//input[@id='email']";
    @FindBy(xpath = _emailError)
    private WebElement emailError;

    private final String _forgotPassword = "//a[@class='btn btn-link']";
    @FindBy(xpath = _forgotPassword)
    private WebElement forgotPassword;

    /** user action methods **/

    public String getLoginPageTitle() {
        String loginTitle = page.getPageTitle(driver);
        return loginTitle;
    }
    public void enterUsername(String uName) {
        page.enterText(username, uName);
    }
    public void enterPassword(String pass) {
        page.enterText(password, pass);
    }
    public MyAccountPage clickOnloginButton() {
        page.clickOnElement(loginButton);
        return new MyAccountPage(driver);
    }
    public void clickOnRememberMeCheckBox() {
        page.clickOnElement(rememberMe);
    }
    public String getLoginFailedMessage() {
        String errorMessage = page.getElementText(invalidCredential);
        return errorMessage;
    }
    public ResetPasswordPage clickOnForgotLink() {
        page.clickOnElement(forgotPassword);
        return new ResetPasswordPage(driver);
    }
    public boolean getRememberMeCheckBoxSelectionStatus() {
        Boolean checkBoxSelectionStatus = page.isElementSelected(rememberMe);
        return checkBoxSelectionStatus;
    }
}
