package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Phones {
    WebDriver driver;

    By galaxyPhoneLink = By.xpath("//a[@href='prod.html?idp_=1']");

    public Phones(WebDriver driver) {
        this.driver = driver;
    }

    public GalaxyS6Phone goToGalaxyPhone() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementPhone = wait.until(ExpectedConditions.elementToBeClickable(galaxyPhoneLink));

//        WebElement elementPhone = driver.findElement(galaxyPhoneLink);
        elementPhone.click();
        return new GalaxyS6Phone(driver);
    }
}
