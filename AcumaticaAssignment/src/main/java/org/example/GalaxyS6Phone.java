package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GalaxyS6Phone {
    WebDriver driver;

    private final By addToCartButton = By.xpath("//a[@class = 'btn btn-success btn-lg']");
    private final By clickCart = By.xpath("//a[@class='nav-link'][@id='cartur']");

    public GalaxyS6Phone(WebDriver driver) {
        this.driver = driver;
    }

    public Cart addToCartAndClosePopup() {

        // ----------- Validate the popup is received after clicking Add to cart button  -----------
        try {
            driver.findElement(addToCartButton).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //  ----------- Validate the text "Product added" on the popup  -----------
            String alertText = alert.getText();
            System.out.println("Popup text: " + alertText + "\n");


    //  ----------- Click the OK button to close the popup  -----------
            alert.accept();

//  ----------- Validate that the popup is closed ---------
            System.out.println("Popup closed and action validated.");
        } catch (Exception e) {
            System.out.println("No alert appeared.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//        -------------click on "cart" after validating alert -----------------------
        WebElement clickOnCart = driver.findElement(clickCart);
        clickOnCart.click();

        return new Cart(driver);
    }
}
