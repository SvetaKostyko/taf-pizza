package by.itacademy.svetakostyko.tafpizza;

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
        WebElement nameOfPizza = driver.findElement(By.xpath(TerraPage.TITLE_OF_PRODUCTS));
        Assert.assertEquals("Wrong text", "Пицца Маргарита Классическая 32 см", nameOfPizza.getText());
    }

    @Test
    public void testPizzaAndDrink() {
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
        List<WebElement> barBtn = driver.findElements(By.xpath(TerraPage.BTN_BAR));
        for (WebElement element : barBtn) {
            if (!element.getText().equals("")) {
                element.click();
                break;
            }
        }
        WebElement yellowSmoothiesElement = driver.findElement(By.xpath(TerraPage.BTN_YELLOW_SMOOTHIES));
        yellowSmoothiesElement.click();
        WebElement cartElement = driver.findElement(By.xpath(TerraPage.CART_BTN));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cartElement));
        cartElement.click();
        WebElement size = driver.findElement(By.xpath(TerraPage.SIZE_OF_PIZZA));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(size));
        List<WebElement> cartList = driver.findElements(By.xpath(TerraPage.TITLE_OF_PRODUCTS));
        Assert.assertEquals("Пицца Маргарита Классическая 32 см", cartList.get(0).getText());
        Assert.assertEquals("Желтый смузи", cartList.get(1).getText());
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
