package wrappers;

import enumUI.EnumContAcc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressInput {

    WebDriver driver;
    EnumContAcc address, label;

    public AddressInput(WebDriver driver, EnumContAcc address, EnumContAcc label) {
        this.driver = driver;
        this.address = address;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(("//fieldset[contains(., '%s')]/descendant::" +
                        "tr[contains(., '%s')]/descendant::input").formatted(address, label)))
                .sendKeys(text);
    }
}
