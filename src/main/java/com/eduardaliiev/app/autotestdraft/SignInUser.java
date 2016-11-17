package com.eduardaliiev.app.autotestdraft;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Eduard Aliiev on 11/16/16;
 */

public class SignInUser extends AbstractPage {
    //basic locators for the 'Sign in' page
    private final By idField = By.id("i0116");
    private final By nextButton = By.id("idSIButton9");
    //basic locators for the 'Enter password' page
    private final By passwordField = By.id("i0118");
    private final By signInButton = By.cssSelector("#idSIButton9");

    public SignInUser(WebDriver driver) {
        super(driver);
    }

    public SignInUser signInEmail(String login){
        //'Sign in' page
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='loginHeader']/../*[text()[contains(.,'Sign in')]]")).isEnabled());
        driver.findElement(idField).clear();
        driver.findElement(idField).sendKeys(login);
        driver.findElement(nextButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='loginHeader']/..//*[text()[contains(.,'Enter password')]]")).isEnabled());
    return this;
    }

    public SignInUser signInPassword(String password){
        //'Enter password' page
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='loginHeader']/..//*[text()[contains(.,'Enter password')]]")).isEnabled());
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='shell-cat-header-logo']//*[text()[contains(.,'Account')]]")).isEnabled());
        return this;
    }
}