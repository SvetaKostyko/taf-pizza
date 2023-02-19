import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void choosePizza(){
        List<WebElement> pizzaBtn = driver.findElements(By.xpath(TerraPage.BTN_PIZZA));
        pizzaBtn.get(1).click();
    }
    @After
    public void closeBrowser(){
    driver.quit();
    }
}
