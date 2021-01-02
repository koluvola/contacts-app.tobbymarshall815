import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    public String address = "[href*='/login']";
    public String email = "testtest1@mail.ru";
    public String emailLocator = "//input[1]";
    public String loginButton = "//button[1]";
    public String password = "Test12345$";
    public String passwordLocator = "//input[2]";
    public String registrationButton = "//button[2]";
    public int time = 10000;

    @Test
    public void loginTest() {
        openRegLogForm(address);
        fillRegLogForm(emailLocator, passwordLocator, email, password, time, loginButton);

    }
}
