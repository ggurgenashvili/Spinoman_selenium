package dev.spinoman.com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private By headerLogin = By.xpath("//button[.//span[@class='button__text']]");
    private By iframe = By.className("iframe");
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By loginButton = By.id("submitBtn");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void visit() {
        super.visit("https://dev.spinoman.com/");
    }
    public void headerLogin() {
        driver.findElement(headerLogin).click();
    }
    public void iframeLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }
    public void enterEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public SuccessfulLoginPage executeLogin(String username, String password) {
        enterEmail(username);
        enterPassword(password);
        clickLogin();
        return new SuccessfulLoginPage(driver);
    }


}
