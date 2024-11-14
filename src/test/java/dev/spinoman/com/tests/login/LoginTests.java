package dev.spinoman.com.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginWithEmailAndPassword() {
        driver.get("https://dev.spinoman.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[@class='button__text']]")));
        loginButton.click();

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("iframe")));
        driver.switchTo().frame(iframe);

//        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("damn@test.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Spinoman@1");

        WebElement authButton = driver.findElement(By.id("submitBtn"));
        authButton.click();
    }


}
