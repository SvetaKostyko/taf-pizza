import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TerraTest {
    WebDriver driver;

    @Before
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TerraPage.URL);
    }

    @Test
    public void choosePizza() {
        WebElement cookiesButton = driver.findElement(By.xpath(TerraPage.BTN_COOKIES));
        cookiesButton.click();
        List<WebElement> pizzaBtn = driver.findElements(By.xpath(TerraPage.BTN_PIZZA));
        for (WebElement element : pizzaBtn) {
            if (!element.getText().equals("")) {
                element.click();
                break;
            }
        }
        WebElement margaritaElement = driver.findElement(By.xpath(TerraPage.BTN_MARGARITA_PIZZA));
        margaritaElement.click();
        WebElement cartElement = driver.findElement(By.xpath(TerraPage.CART_BTN));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cartElement));
        cartElement.click();
        WebElement size = driver.findElement(By.xpath(TerraPage.SIZE_OF_PIZZA));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(size));
        WebElement nameOfPizza = driver.findElement(By.xpath(TerraPage.TITLE_OF_PIZZA));
        Assert.assertEquals("Wrong text", "Пицца Маргарита Классическая 32 см", nameOfPizza.getText());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
