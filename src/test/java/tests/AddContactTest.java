package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {
    String contactName = "Alex";
    int i = (int) ((System.currentTimeMillis() / 1000) / 3600);
    private String address = "Tel Aviv " + i;
    private String description = "New contact " + i;
    private String email = "test1234A447266@mail.ru";
    private String lName = "Wolf " + i;
    private String name = "Chris " + i;
    private String phone = "0536567" + i;

    @Test
    public void addContactTest() {

        app.getContact().clickAddButton();
        //app.getContact().fillAddContactForm(new Contact().withEmail(email).withAddress(address).withDescription(description).withlName(lName).withName(name).withPhone(phone));
        //String name, String Lname, String phone, String email, String address, String descript
        app.getContact().fillAddContactFormNew(name, lName, phone, email, address, description);
        app.getContact().clickSaveButton("//button[contains(.,'Save')]");
        app.getContact().openContacts();
        app.getContact().delay(4000);

        Assert.assertTrue(app.getContact().isNameExist(contactName));

        app.getContact().clearContacts();
        app.getContact().delay(10000);

    }

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLogined()) {
            app.getUser().login();
        }

    }
}
