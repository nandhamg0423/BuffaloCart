package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RolesPage extends ObjectUtility {
    WebDriver driver;

    /**page constructor **/

    public RolesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** page elements **/

    private final String _addButtonForAddRoles = "/html/body/div[2]/div[1]/section[2]/div/div[1]/div/a/i";
    @FindBy(xpath = _addButtonForAddRoles)
    private WebElement addButtonForAddRoles;

    private final String _rolePageSearch = "//input[@class='form-control input-sm']";
    @FindBy(xpath = _rolePageSearch)
    private WebElement rolePageSearch;

    private final String _roleEditButton = "//a[@class='btn btn-xs btn-primary']";
    @FindBy(xpath = _roleEditButton)
    private WebElement roleEditButton;

    private final String _roleDeleteButton = "//button[@class='btn btn-xs btn-danger delete_role_button']";
    @FindBy(xpath = _roleDeleteButton)
    private WebElement roleDeleteButton;

    private final String _okButtonForRoleDelete = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
    @FindBy(xpath = _okButtonForRoleDelete)
    private WebElement okButtonForRoleDelete;

    private final String _deletedMessage = "div[class='toast-message']";
    @FindBy(css = _deletedMessage)
    private WebElement deletedMessage;

    /**user action**/

    public String getRolesTitle() {
        String rolesPageTitle = page.getPageTitle(driver);
        return rolesPageTitle;
    }
    public AddRolesPage clickOnAddRolesButton() {
        page.clickOnElement(addButtonForAddRoles);
        return new AddRolesPage(driver);
    }
    public void searchRole(String seaRch) {
        page.enterText(rolePageSearch, seaRch);
    }
    public EditRolePage clickOnEditRolesButton() {
        page.clickOnElement(roleEditButton);
        return new EditRolePage(driver);
    }
    public RolesPage clickOnDeleteRolesButton() {
        page.clickOnElement(roleDeleteButton);
        return new RolesPage(driver);
    }
    public UserPage clickOnDeleteOkButton() {
        page.clickOnElement(okButtonForRoleDelete);
        return new UserPage(driver);
    }
    public String getDeletedMessage() {
        String deleteMessage = page.getElementText(deletedMessage);
        return deleteMessage;
    }
}
