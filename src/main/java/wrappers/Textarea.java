package wrappers;

import enumUI.EnumContAcc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Textarea {

    WebDriver driver;
    EnumContAcc label;

    public Textarea(WebDriver driver, EnumContAcc label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(("//div[contains(text(), '%s')]/parent::div/descendant::textarea")
                        .formatted(label)))
                .sendKeys(text);
    }
}
