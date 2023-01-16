package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends ObjectUtility {
    WebDriver driver;

    /**page constructor **/

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** page elements **/

    private final String _addButton = "//a[@class='btn btn-block btn-primary']";
    @FindBy(xpath = _addButton)
    private WebElement addButton;

    private final String _searchUser = "//input[@class='form-control input-sm']";
    @FindBy(xpath = _searchUser)
    private WebElement searchUser;

    private final String _editButton = "//a[@class='btn btn-xs btn-primary']";
    @FindBy(xpath = _editButton)
    private WebElement editButton;

    private final String _deleteButton = "//button[@class='btn btn-xs btn-danger delete_user_button']";
    @FindBy(xpath = _deleteButton)
    private WebElement deleteButton;

    private final String _viewButton = "//a[@class='btn btn-xs btn-info']";
    @FindBy(xpath = _viewButton)
    private WebElement viewButton;

    private final String _searchFieldName = "//input[@class='form-control input-sm']";
    @FindBy(xpath = _searchFieldName)
    private WebElement searchFieldName;

    private final String _displayedName = "//tr[@class='odd']//td[2]";
    @FindBy(xpath = _displayedName)
    private WebElement displayedName;

    private final String _updateMessage = "div[class='toast-message']";
    @FindBy(css = _updateMessage)
    private WebElement updateMessage;

    private final String _invalidDataMessage = "//td[@class='dataTables_empty']";
    @FindBy(xpath = _invalidDataMessage)
    private WebElement invalidDataMessage;

    private final String _okButtonForDelete = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
    @FindBy(xpath = _okButtonForDelete)
    private WebElement okButtonForDelete;

    private final String _deletedMessage = "div[class='toast-message']";
    @FindBy(css = _deletedMessage)
    private WebElement deletedMessage;

    /**user action**/

    public String getUserTitle() {
        String userPageTitle = page.getPageTitle(driver);
        return userPageTitle;
    }
    public AddUserPage clickOnAddButton() {
        page.clickOnElement(addButton);
        return new AddUserPage(driver);
    }
    public void searchUser(String seaRch) {
        page.enterText(searchUser, seaRch);
    }
    public EditPage clickOnEditButton() {
        page.clickOnElement(editButton);
        return new EditPage(driver);
    }
    public UserPage clickOnDeleteButton() {
        page.clickOnElement(deleteButton);
        return new UserPage(driver);
    }
    public ViewPage clickOnViewButton() {
        page.clickOnElement(viewButton);
        return new ViewPage(driver);
    }
    public String getSearchFieldName(){
        String nameInSearch = page.getElementText(searchFieldName);
        return nameInSearch;
    }
    public String getUpdateMessage() {
        String updateMessagee = page.getElementText(updateMessage);
        return updateMessagee;
    }
    public String getInvalidDataMessage() {
        String invalidMessage = page.getElementText(invalidDataMessage);
        return invalidMessage;
    }
    public UserPage clickOnOkButton() {
        page.clickOnElement(okButtonForDelete);
        return new UserPage(driver);
    }
    public String getDeletedMessage() {
        String deleteMessage = page.getElementText(deletedMessage);
        return deleteMessage;
    }
}
