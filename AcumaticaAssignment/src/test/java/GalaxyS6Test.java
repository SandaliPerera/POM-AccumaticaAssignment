import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.example.*;

import java.time.Duration;

public class GalaxyS6Test {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        String driver_executable_path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_executable_path);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/index.html");
    }

    @Test
    public void addToCartTest() {

        Home homePage = new Home(driver);
        Phones phonesPage = homePage.goToPhones();
        GalaxyS6Phone galaxyPhone = phonesPage.goToGalaxyPhone();
        Cart cartPage = galaxyPhone.addToCartAndClosePopup();
        OrderPage orderPage = cartPage.placeOrder();
        Receipt receiptPage = orderPage.completeOrder("Sandali", "Sri Lanka", "Panadura", "123456789", "March", "2025");

        receiptPage.validateReceipt("Sandali", "Amount:");

        //        Set a wait for better visibility of the final receipt
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.quit();
    }
}
