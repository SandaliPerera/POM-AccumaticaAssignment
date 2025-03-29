package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Cart {
    WebDriver driver;

    private final By placeOrderButton = By.className("btn-success");

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage placeOrder() {
        driver.findElement(placeOrderButton).click();
        return new OrderPage(driver);
    }
}
