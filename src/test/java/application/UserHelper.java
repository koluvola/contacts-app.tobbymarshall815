package application;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);

    }

    public void openLogRegForm(){
        click(By.cssSelector("[href='/login']"));
    }

    public void fillRegLogForm(User user){
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());

    }
    public void clickRegButton(){
        click(By.xpath("//*[text()=' Registration']"));
    }

    public void clickLoginButton() {
        click(By.xpath("//button[.=' Login']"));
    }

    public void login() {
        openLogRegForm();
        fillRegLogForm(new User().withEmail("test1234A447266@mail.ru").withPassword("Test12345$"));
        clickLoginButton();
    }

    public boolean isLogined() {
        return isElementPresent((By.xpath("//*[text()='Sign Out']")));

    }

}
