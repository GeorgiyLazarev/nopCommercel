package wrappers;

import enumUI.EnumContAcc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {

    WebDriver driver;

    public Checkbox(WebDriver driver) {
        this.driver = driver;
    }

    public static By checkBox(EnumContAcc label) {
        return By.xpath("//label[text()='%s']//parent::div".formatted(label) +
                "//input[contains(@value, '0emailAddress0')]");
    }
}
