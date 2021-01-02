import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    public String address = "[href*='/login']";
    public String email = "testtest123A@mail.ru";
    public String emailLocator = "//input[1]";
    public String loginButton = "//button[1]";
    public String password = "Test12345$";
    public String passwordLocator = "//input[2]";
    public String registrationButton = "//button[2]";
    public String signOut = "//*[text()='Sign Out']";
    public int time = 10000;

    @Test
    public void registrationTest() {
        openRegLogForm(address);
        fillRegLogForm(emailLocator, passwordLocator, email, password, time, registrationButton);
        Assert.assertTrue(isElementPresent(By.xpath(signOut)));


    }


}
