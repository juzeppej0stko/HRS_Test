package guru.kazakov;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.kazakov.helpers.Attach;
import guru.kazakov.pages.MainPage;
import guru.kazakov.pages.SupportPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
TestData testData = new TestData();
MainPage mainPage = new MainPage();
SupportPage supportPage = new SupportPage();

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://www.hrsinternational.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();

    }
}
