package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriverWait wait;
    WebDriver driver;

    protected String user = System.getProperty("user");
    protected String password = System.getProperty("password");

    public final String BASE_URL_LOGIN = "https://demo.suiteondemand.com/index.php?module=Users&action=Login";
    public final String BASE_URL_ACCOUNT = "https://demo.suiteondemand.com/index.php?module=" +
            "Accounts&action=EditView&return_module=Accounts&return_action=DetailView";
    public final String BASE_URL_CONTACT = "https://demo.suiteondemand.com/index.php?module=Contacts&action=" +
            "EditView&return_module=Contacts&return_action=DetailView";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isVisible(By locator, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public abstract BasePage isPageOpened();
    public abstract BasePage openPage();
}
