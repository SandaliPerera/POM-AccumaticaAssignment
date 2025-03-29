package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Receipt {
    WebDriver driver;

    private final By receiptText = By.cssSelector("p.lead.text-muted");

    public Receipt(WebDriver driver) {
        this.driver = driver;
    }


    public void validateReceipt(String expectedName, String expectedAmount) {
        WebElement receipt = driver.findElement(receiptText);
        String receiptDetails = receipt.getText();
        System.out.println("\n-----------Actual Text --------- \n" + receiptDetails + "\n-----------------");

    }
}
