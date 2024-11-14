package dev.spinoman.com.tests.login;

import dev.spinoman.com.pageObjects.BasePage;
import dev.spinoman.com.pageObjects.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseT {


    @Test
    public void loginWithEmailAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        loginPage.headerLogin();
        loginPage.iframeLogin();
        loginPage.enterEmail("damn@test.com");
        loginPage.enterPassword("Spinoman@1");
        loginPage.clickLogin();
    }




}
