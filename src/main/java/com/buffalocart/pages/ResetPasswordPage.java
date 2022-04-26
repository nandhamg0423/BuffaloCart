package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ResetPasswordPage extends ObjectUtility {
    WebDriver driver;
    /**
     * page constructor
     **/

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**page elements**/


    private final String _invalidEmailForForgot = "//input[@class='form-control']";
    @FindBy(xpath = _invalidEmailForForgot)
    private WebElement invalidEmailForForgot;

    private final String _resetButton = "//button[@class='btn btn-primary']";
    @FindBy(xpath = _resetButton)
    private WebElement resetButton;

    private final String _resetErrorMessage = "//span[@class='help-block']/child::strong";
    @FindBy(xpath = _resetErrorMessage)
    private WebElement resetErrorMessage;



/**user action**/


    public void invalidEmailForForgot(String invalidEmail) {
        page.enterText(invalidEmailForForgot, invalidEmail);
    }

    public void resetButton() {
        page.clickOnElement(resetButton);
    }

    public void resetErrormessage() {
        page.clickOnElement(resetErrorMessage);
    }


    public String getResetErrorMessage() throws IOException {
        String reseterrorMessage = page.getElementText(resetErrorMessage);
        String exp = String.valueOf(excel.readDataFromExcel("LoginPage"));
        return reseterrorMessage;
    }
}
