package tests;

import dto.Account;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewContactPage;

import java.io.IOException;
import java.util.HashMap;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    NewAccountPage newAccountPage;
    NewContactPage newContactPage;

    @BeforeEach()
    @Description("Настройка браузера")
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        newAccountPage = new NewAccountPage(driver);
        newContactPage = new NewContactPage(driver);
        driver.manage().window().maximize();
    }

    @AfterEach()
    @Description("Закрытие браузера браузера")
    public void tearDawn() {
        driver.quit();
    }
}
