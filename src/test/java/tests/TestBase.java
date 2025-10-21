package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

        //прошу не обращять внимания на этот закомментированный код
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 1000;
    }
}
