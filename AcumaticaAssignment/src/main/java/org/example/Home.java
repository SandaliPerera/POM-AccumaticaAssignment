package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home {
    WebDriver driver;

    private final By phonesLink = By.xpath("(//a[normalize-space()='Phones'])[1]");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public Phones goToPhones() {

//        System.out.println("Testing...");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        System.out.println("Current URL: " + driver.getCurrentUrl());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement elementPhone = wait.until(ExpectedConditions.presenceOfElementLocated(phonesLink));

        wait.until(ExpectedConditions.elementToBeClickable(elementPhone));

        elementPhone.click();

        return new Phones(driver);
    }

}
