package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ObjectUtility {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**page elements**/

    private final String _tourBox = "//body[@class='skin-purple sidebar-mini   tour-tour-element tour-tour-0-element  pace-done pace-done']";
    @FindBy(xpath = _tourBox)
    private WebElement tourbox;

    /**user action methods**/

    public HomePage tourButton(){
        page.clickOnElement(tourbox);
        return new HomePage(driver);
    }
}
