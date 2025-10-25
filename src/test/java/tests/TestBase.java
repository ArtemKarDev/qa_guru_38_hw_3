package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestBase {

    @BeforeAll
    static void beforeAll(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;

        //прошу не обращять внимания на этот закомментированный код
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        //Configuration.timeout = 1000;
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
