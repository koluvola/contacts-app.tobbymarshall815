package tests;

import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    //public String email = "testtest1234Aa@mail.ru";
    public String email = "test1234A447266@mail.ru";
    public String password = "Test12345$";


    @Test
    public void loginTest() throws InterruptedException {
        app.getUser().openLogRegForm();
        app.getUser().fillRegLogForm(new User().withEmail(email).withPassword(password));
        app.getUser().clickLoginButton();
        app.getUser().delay(1000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }

}
