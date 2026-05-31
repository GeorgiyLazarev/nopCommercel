package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {

    private final By USERNAME = By.id("user_name");
    private final By PASSWORD = By.id("username_password");
    private final By LOGIN = By.name("Login");
    private final By OPEN = By.xpath("//input[@value='Log In']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {
        assertTrue(isVisible(OPEN, 10), "Страница с добавлением аккаунта не загрузилась");
        return this;
    }

    @Override
    public LoginPage openPage() {
        driver.get(BASE_URL_LOGIN);
        isPageOpened();
        return this;
    }

    public void authorization(String user, String password) {
        openPage();
        driver.findElement(USERNAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN).click();
    }
}
