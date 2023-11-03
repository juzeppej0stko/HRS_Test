package guru.kazakov;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;

public class HRS_TestsPageObject extends TestBase{

    @Test
    @DisplayName("Testing page title")
    @Owner("Sergey Kazakov")
    @Feature("Main Page")
    @Story("Checking the loading of the main page")
    @Severity(SeverityLevel.NORMAL)
    @Tag("remote")
    public void testPageTitle() {
        step("Open main page", () -> {
            mainPage.mainPageOpen();
                });
        step("Checking if the page title is correct", () -> {
            mainPage.isPageTitleCorrect(title(), "HRS Global - HRS Hospitality & Retail Systems");
        });
    }

    @Test
    @DisplayName("Testing main page search")
    @Owner("Sergey Kazakov")
    @Feature("Main Page")
    @Story("Checking the search button and the search results")
    @Severity(SeverityLevel.NORMAL)
    @Tag("remote")
    public void testMainPageSearch() {
        step("Open main page", () -> {
            mainPage.mainPageOpen();
                });
        step("Click on the search icon", () -> {
            mainPage.searchIconClick();
                });
        step("Enter Search Query", () -> {
            mainPage.enterSearchQuery(testData.query);
                });
        step("Checking that search results are not empty", () -> {
            mainPage.areSearchResultsNotEmpty();
        });
    }

    @Test
    @DisplayName("Testing main page feedback form")
    @Owner("Sergey Kazakov")
    @Feature("Main Page")
    @Story("Checking the feedback form")
    @Severity(SeverityLevel.NORMAL)
    @Tag("remote")
    public void testMainPageFeedbackForm() {
        step("Open main page", () -> {
            mainPage.mainPageOpen();
                });
        step("Cookies Message Close", () -> {
            mainPage.cookiesMsgClose();
                });
        step("Filling out the Contact Form", () -> {
            mainPage.fillContactForm(testData.name, testData.email,
                            testData.company, testData.phone, testData.interests);
                });
        step("Checking if the consent checkbox is checked", () -> {
            mainPage.checkTheConsentBox();
                });
        step("Checking if the consent checkbox is checked", () -> {
            mainPage.submitForm();
                });
        step("Checking if the Thank You Message Displayed", () -> {
            mainPage.isThankYouMessageDisplayed();
        });
    }

    @Test
    @DisplayName("Testing main page country switch")
    @Owner("Sergey Kazakov")
    @Feature("Main Page")
    @Story("Сhecking that the page intended for Norway has opened")
    @Severity(SeverityLevel.NORMAL)
    @Tag("remote")
    public void testMainPageLanguageSwitch() {
        step("Open main page", () -> {
            mainPage.mainPageOpen();
                });
        step("Change the region", () -> {
            mainPage.regionChange();
                });
        step("Checking the Correct Page Title", () -> {
            mainPage.isPageTitleCorrect("HRS Norway - HRS - Hospitality & Retail Systems",
                    title());
        });
    }

    @Test
    @DisplayName("Testing support page")
    @Owner("Sergey Kazakov")
    @Feature("Support Page")
    @Story("Checking the loading of the support page. Checking whether a document has been downloaded and whether it contains a certain line")
    @Severity(SeverityLevel.NORMAL)
    @Tag("remote")
    public void testSupportPage() throws Exception {

        step("Open main page", () -> {
            mainPage.mainPageOpen();
                });
        step("Open support page", () -> {
            supportPage.supportPageOpen();
                });
        step("Open page with documents", () -> {
            supportPage.docsPageOpen();
                });
        step("Checking that the Pdf is loaded And Contains Text", () -> {
            supportPage.isPdfDownloadedAndContainsText(testData.textInsidePdf);
        });
        }

}


