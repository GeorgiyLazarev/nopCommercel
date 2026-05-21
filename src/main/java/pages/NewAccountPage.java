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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wrappers.Checkbox.checkBox;
import static wrappers.Dropdown.select;

@Log4j2
public class NewAccountPage extends BasePage {

    private final By OPEN_ACCOUNT = By.xpath("//div[text()='Create Account']");
    private final By SAVE_ACCOUNT = By.xpath("//span[contains(@class, 'star-')]");

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountPage isPageOpened() {
        assertTrue(isVisible(OPEN_ACCOUNT, 10));
        return this;
    }

    @Override
    public NewAccountPage openPage() {
        driver.get(BASE_URL_ACCOUNT);
        isPageOpened();
        return this;
    }

    public NewAccountPage clickCheckbox(EnumContAcc nameCheckbox) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(checkBox(nameCheckbox)));
        verifyCheckboxIsSelected(nameCheckbox);
        return this;
    }

    public NewAccountPage clickDropdown(String label) {
        driver.findElement(select(label)).click();
        return this;
    }

    public NewAccountPage choiceOption(String label, Options option) {
        clickDropdown(label);
        WebElement selectElement = driver.findElement(select(label));
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText(option.toString());
        return this;
    }

    public NewAccountPage saveAccount() {
        log.info("Save new account");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",  driver.findElement(By.id("SAVE")));
        verifySaveAccount();
        return this;
    }

    public NewAccountPage addNewAccount(dto.Account account) {
        new Input(driver, NAME).write(account.getName());
        new Input(driver, OFFICE_PHONE).write(account.getPhone());
        new Input(driver, WEBSITE).write(account.getSite());
        new Input(driver, FAX).write(account.getFax());
        new Input(driver, ANNUAL_REVENUE).write(account.getAnnualRevenue());
        new AddressTextarea(driver, BILLING_ADDRESS, BILLING_STREET).write(account.getStreetBilling());
        new AddressTextarea(driver, SHIPPING_ADDRESS, SHIPPING_STREET).write(account.getStreetShipping());
        new AddressInput(driver, BILLING_ADDRESS, BILLING_CITY).write(account.getCityBilling());
        new AddressInput(driver, SHIPPING_ADDRESS, SHIPPING_CITY).write(account.getCityShipping());
        new AddressInput(driver, BILLING_ADDRESS, BILLING_STATE_REGION).write(account.getRegionBilling());
        new AddressInput(driver, SHIPPING_ADDRESS, SHIPPING_STATE_REGION).write(account.getRegionShipping());
        new AddressInput(driver, BILLING_ADDRESS, BILLING_POSTAL_CODE).write(account.getPostalCodeBilling());
        new AddressInput(driver, SHIPPING_ADDRESS, SHIPPING_POSTAL_CODE).write(account.getPostalCodeShipping());
        new AddressInput(driver, BILLING_ADDRESS, BILLING_COUNTRY).write(account.getCountryBilling());
        new AddressInput(driver, SHIPPING_ADDRESS, SHIPPING_COUNTRY).write(account.getCountryShipping());
        new Textarea(driver, DESCRIPTION).write(account.getDescription());
        return this;
    }

    public NewAccountPage verifyCheckboxIsSelected(EnumContAcc nameCheckbox) {
        assertTrue(driver.findElement(checkBox(nameCheckbox)).isSelected());
        return this;
    }

    public NewAccountPage verifyCheckboxIsNotSelected(EnumContAcc nameCheckbox) {
        assertFalse(driver.findElement(checkBox(nameCheckbox)).isSelected());
        return this;
    }

    public NewAccountPage verifySaveAccount() {
        assertTrue(isVisible(SAVE_ACCOUNT, 10));
        return this;
    }
}
