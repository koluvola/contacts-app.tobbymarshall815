package tests;

import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

   int i = (int) ((System.currentTimeMillis()/1000)/3600);
    public String email = "test1234A" + (i+10) + "@mail.ru";
    public String password = "Test12345$";


    @Test
    public void registrationTest(){
        app.getUser().openLogRegForm();
        System.out.println(email + " " + password);
        app.getUser().fillRegLogForm(new User().withEmail(email).withPassword(password));
        app.getUser().clickRegButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));


    }


}
