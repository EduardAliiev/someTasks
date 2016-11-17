package com.eduardaliiev.app.autotestdraft;

import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 11/17/16;
 */
public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

}
