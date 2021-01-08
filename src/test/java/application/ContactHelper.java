package application;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void clearContacts() {
        LocalStorage local = ((WebStorage) wd).getLocalStorage();
        String token = local.getItem("token");
        System.out.println(token);
        try {
            URL url=new URL("https://contacts-telran.herokuapp.com/api/clear");
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.addRequestProperty("Authorization",token);
            connection.getInputStream();
            wd.navigate().refresh();
            delay(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clickAddButton() {
        click(By.cssSelector("[href='/add']"));
    }

    public void clickSaveButton(String xpath) {
        delay(3000);
        click(By.xpath("//button[contains(.,'Save')]"));
        delay(2000);


    }

    public void fillAddContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getlName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getlName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void fillAddContactFormNew(String name, String Lname, String phone, String email, String address, String descript) {
        type(By.cssSelector("[placeholder='Name']"), name);
        type(By.cssSelector("[placeholder='Last Name']"), Lname);
        type(By.cssSelector("[placeholder='Last Name']"), phone);
        type(By.cssSelector("[placeholder='email']"), email);
        type(By.cssSelector("[placeholder='Address']"), address);
        type(By.cssSelector("[placeholder='description']"), descript);

    }

    public boolean isNameExist(String contactName) {


        List<WebElement> elements = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : elements) {
            if (el.getText().equals(contactName))
                System.out.println("Element found in list.");
            return true;

        }

        return false;


    }

    public void openContacts() {
        click(By.cssSelector("[href='/contacts']"));
        delay(30000);
    }
}