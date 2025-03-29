package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderPage {
    WebDriver driver;

    private final By nameField = By.id("name");
    private final By countryField = By.id("country");
    private final By cityField = By.id("city");
    private final By cardField = By.id("card");
    private final By monthField = By.id("month");
    private final By yearField = By.id("year");
    private final By purchaseButton = By.xpath("//button[text()='Purchase']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public Receipt completeOrder(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
        driver.findElement(purchaseButton).click();
        return new Receipt(driver);
    }
}
