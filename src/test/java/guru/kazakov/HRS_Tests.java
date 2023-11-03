package guru.kazakov;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HRS_Tests {
    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://www.hrsinternational.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void testPageTitle() {
        open("/en");
        String expectedTitle = "HRS Global - HRS Hospitality & Retail Systems";
        String actualTitle = title();
        assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testMainPageSearch() {
        open("/en");
        //
        $(".fa-search").click();

        // Ввести поисковой запрос
        $("#ke_search_searchfield_sword").setValue("hotel").pressEnter();

        // Проверить результаты поиска
        $(".container-search-results").shouldHave(text("You searched for hotel"));

        // Проверить, что найдено хотя бы одно предложение
        $$("div.container-search-results div.search-result").shouldHave(sizeGreaterThan(0));
    }

    @Test
    public void testMainPageFeedbackForm() {
        // Открыть главную страницу
        open("/en");

        // Нажать на ссылку "Contact us"
        $("[title=Contact]").click();
        $("#powermail_field_name").setValue("TestName");
        $("#powermail_field_e_mail").setValue("mail@test.com");
        $("#powermail_field_company").setValue("TestCompany");
        $("#powermail_field_phone").setValue("123456");
        $("#powermail_field_marker").setValue("TestInterests");
        $(".label-checkbox").click();
        $(".btn.primary").click();
        $(".indent").shouldHave(text("Thank you for contacting HRS International."));

    }

    @Test
    public void testMainPageLanguageSwitch() {
        // Открыть главную страницу
        open("/en");

        // Нажать на ссылку переключения страны
        $(".js.country").click();
        $("[title=Norway]").click();
        String expectedTitle = "HRS Norway - HRS - Hospitality & Retail Systems";
        String actualTitle = title();
        assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void testSupportPage() throws Exception {
        // Открытие страницы https://www.hrsinternational.com/en
        open("/en");

        // Переход на страницу Support
        $(".external-link").click();
        switchTo().window(1);
        $(By.xpath("//a[text()='Documentation']")).click();

        open("http://support.hrsinternational.com/litera/documents/suite_8_en.pdf");
        File downloadedFile = $(By.linkText("Fidelio v8")).download();
            PDF content = new PDF(downloadedFile);
            assertThat(content.text).contains("V8 Development Team");
        }

}


