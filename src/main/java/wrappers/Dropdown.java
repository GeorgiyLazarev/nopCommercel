package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {

    WebDriver driver;

    public Dropdown(WebDriver driver) {
        this.driver = driver;
    }

    public static By select(String label) {
        return By.xpath("//select[contains(@name, '%s')]".formatted(label));
    }
}
