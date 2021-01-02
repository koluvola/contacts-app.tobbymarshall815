import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    public void fillRegLogForm(String emailLocator, String passwordLocator, String email, String password, int time, String button) {
        type(By.xpath(String.valueOf(emailLocator)), email);
        type(By.xpath(String.valueOf(passwordLocator)), password);
        delay(time);
        click(By.xpath(String.valueOf(button)));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void openRegLogForm(String address) {
        click(By.cssSelector(address));
        delay(5000);
    }

    @BeforeMethod
    public void setUp() {

        wd = new FirefoxDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        delay(10000);
        wd.quit();
    }


}
