package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage extends ObjectUtility {
    WebDriver driver;

    /**page constructor **/

    public EditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /** page elements**/

    private final String _updateButton = "//button[@id='submit_user_button']";
    @FindBy(xpath = _updateButton)
    private WebElement updateButton;

    /**user action methods**/

    public String getEditPageTitle() {
        String editPageTitle = page.getPageTitle(driver);
        return editPageTitle;
    }
    public UserPage clickOnUpdateButton() {
        page.clickOnElement(updateButton);
        return new UserPage(driver);
    }

}
