package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRolesPage extends ObjectUtility {
    WebDriver driver;

    /** page constructor**/

    public AddRolesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**page elements **/

    private final String _roleName = "//input[@id='name']";
    @FindBy(xpath = _roleName)
    private WebElement roleName;

    private final String _saveButton = "//button[@class='btn btn-primary pull-right']";
    @FindBy(xpath = _saveButton)
    private WebElement saveButton;

    /**user action**/

    public void enterRoleName(String rolName) {
        page.enterText(roleName, rolName);
    }
    public RolesPage clickOnSaveButton() {
        page.clickOnElement(saveButton);
        return new RolesPage(driver);
    }
}
