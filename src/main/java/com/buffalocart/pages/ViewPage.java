package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ViewPage extends ObjectUtility {
    WebDriver driver;

    /** page constructor **/

    public ViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** user action **/

    public String getViewPageTitle() {
        String viewPageTitle = page.getPageTitle(driver);
        return viewPageTitle;
    }
}
