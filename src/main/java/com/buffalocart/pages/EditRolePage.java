package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditRolePage extends ObjectUtility {
    WebDriver driver;

    /**page constructor **/

    public EditRolePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** page elements**/

    private final String _fieldForEditRolePage = "//input[@id='name']";
    @FindBy(xpath = _fieldForEditRolePage)
    private WebElement fieldForEditRolePage;

    private final String _updateButtonForEditRolePage = "//button[@class='btn btn-primary pull-right']";
    @FindBy(xpath = _updateButtonForEditRolePage)
    private WebElement updateButtonForEditRolePage;

    private final String _roleUpdateMessage = "div[class='toast-message']";
    @FindBy(css = _roleUpdateMessage)
    private WebElement roleUpdateMessage;

    /**user action**/

    public void enterEditRolePageValue(String editRole) {
        page.enterText(fieldForEditRolePage, editRole);
    }
    public RolesPage clickOnUpdateRolesButton() {
        page.clickOnElement(updateButtonForEditRolePage);
        return new RolesPage(driver);
    }
    public String getRoleUpdateMessage() {
        String roleUpdateMessagee = page.getElementText(roleUpdateMessage);
        return roleUpdateMessagee;
    }
    public String getEditRolePageTitle() {
        String editRolePageTitle = page.getPageTitle(driver);
        return editRolePageTitle;
    }
}
