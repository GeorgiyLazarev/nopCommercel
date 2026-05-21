package pages;

import enumUI.EnumContAcc;
import enumUI.Options;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import wrappers.AddressInput;
import wrappers.AddressTextarea;
import wrappers.Input;
import wrappers.Textarea;

import static enumUI.EnumContAcc.*;
import static enumUI.EnumContAcc.BILLING_CITY;
import static enumUI.EnumContAcc.BILLING_COUNTRY;
import static enumUI.EnumContAcc.BILLING_POSTAL_CODE;
import static enumUI.EnumContAcc.BILLING_STATE_REGION;
import static enumUI.EnumContAcc.DESCRIPTION;
import static enumUI.EnumContAcc.FAX;
import static enumUI.EnumContAcc.SHIPPING_CITY;
import static enumUI.EnumContAcc.SHIPPING_COUNTRY;
import static enumUI.EnumContAcc.SHIPPING_POSTAL_CODE;
import static enumUI.EnumContAcc.SHIPPING_STATE_REGION;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wrappers.Checkbox.checkBox;
import static wrappers.Dropdown.select;

@Log4j2
public class NewContactPage extends BasePage {

    private final By OPEN_CONTACT = By.xpath("//div[text()='Create Contact']");
    private final By SAVE_CONTACT = By.xpath("//span[contains(@class, 'star-')]");

    public NewContactPage(WebDriver driver) {
        super(driver);
    }

    public NewContactPage addNewContact(dto.Contact contact) {
        new Input(driver, FIRST_NAME).write(contact.getFirstName());
        new Input(driver, LAST_NAME).write(contact.getLastName());
        new Input(driver, MOBILE).write(contact.getMobile());
        new Input(driver, OFFICE_PHONE).write(contact.getPhone());
        new Input(driver, FAX).write(contact.getFax());
        new AddressTextarea(driver, PRIMARY_ADDRESS, ADDRESS).write(contact.getStreetBilling());
        new AddressTextarea(driver, OTHER_ADDRESS, OTHER_ADDRESS).write(contact.getStreetShipping());
        new AddressInput(driver, PRIMARY_ADDRESS, BILLING_CITY).write(contact.getCityBilling());
        new AddressInput(driver, OTHER_ADDRESS, SHIPPING_CITY).write(contact.getCityShipping());
        new AddressInput(driver, PRIMARY_ADDRESS, BILLING_STATE_REGION).write(contact.getRegionBilling());
        new AddressInput(driver, OTHER_ADDRESS, SHIPPING_STATE_REGION).write(contact.getRegionShipping());
        new AddressInput(driver, PRIMARY_ADDRESS, BILLING_POSTAL_CODE).write(contact.getPostalCodeBilling());
        new AddressInput(driver, OTHER_ADDRESS, SHIPPING_POSTAL_CODE).write(contact.getPostalCodeShipping());
        new AddressInput(driver, PRIMARY_ADDRESS, BILLING_COUNTRY).write(contact.getCountryBilling());
        new AddressInput(driver, OTHER_ADDRESS, SHIPPING_COUNTRY).write(contact.getCountryShipping());
        new Textarea(driver, DESCRIPTION).write(contact.getDescription());
        return this;
    }

    @Override
    public NewContactPage isPageOpened() {
        assertTrue(isVisible(OPEN_CONTACT, 10));
        return this;
    }

    @Override
    public NewContactPage openPage() {
        driver.get(BASE_URL_CONTACT);
        isPageOpened();
        return this;
    }

    public NewContactPage clickCheckbox(EnumContAcc nameCheckbox) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(checkBox(nameCheckbox)));
        verifyCheckboxIsSelected(nameCheckbox);
        return this;
    }

    public NewContactPage clickDropdown(String label) {
        driver.findElement(select(label)).click();
        return this;
    }

    public NewContactPage choiceOption(String label, Options option) {
        clickDropdown(label);
        WebElement selectElement = driver.findElement(select(label));
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText(option.toString());
        return this;
    }

    public NewContactPage saveContact() {
        log.info("Save new contact");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",  driver.findElement(By.id("SAVE")));
        verifySaveContact();
        return this;
    }

    public NewContactPage verifyCheckboxIsSelected(EnumContAcc nameCheckbox) {
        assertTrue(driver.findElement(checkBox(nameCheckbox)).isSelected());
        return this;
    }

    public NewContactPage verifyCheckboxIsNotSelected(EnumContAcc nameCheckbox) {
        assertFalse(driver.findElement(checkBox(nameCheckbox)).isSelected());
        return this;
    }

    public NewContactPage verifySaveContact() {
        assertTrue(isVisible(SAVE_CONTACT, 10));
        return this;
    }
}
