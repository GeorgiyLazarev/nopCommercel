package tests;

import dto.Contact;
import dto.ContactFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static enumUI.EnumContAcc.*;
import static enumUI.Options.EXISTING_CUSTOMER;
import static enumUI.Options.MR;

public class NewContactTest extends BaseTest {

    Contact contact = ContactFactory.getContact();

    @Test
    public void checkAddNewContact() {
        loginPage.authorization("will", "will");
        newContactPage
                .openPage()
                .choiceOption("salutation", MR)
                .choiceOption("lead_source", EXISTING_CUSTOMER)
                .clickCheckbox(OPTED_OUT)
                .clickCheckbox(INVALID)
                .addNewContact(contact)
                .saveContact();
    }
}
