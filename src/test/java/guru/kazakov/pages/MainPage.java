package guru.kazakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.PhoneNumber;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    private SelenideElement
            searchIcon = $(".fa-search"),
            searchInput = $("#ke_search_searchfield_sword"),
            contactLink = $("[title=Contact]"),
            nameField = $("#powermail_field_name"),
            emailField = $("#powermail_field_e_mail"),
            companyField = $("#powermail_field_company"),
            phoneField = $("#powermail_field_phone"),
            interestsField = $("#powermail_field_marker"),
            checkBox = $(".label-checkbox"),
            submitButton = $(".btn.primary"),
            thxMsg = $(".indent"),
            cookiesMsgClose = $(".dn-cookie-close"),
            regionChangeLink = $(".js.country"),
            regionNorway = $("[title=Norway]"),
            searchResultsContainer = $(".container-search-results");
    private ElementsCollection
            searchResults = $$("div.container-search-results div.search-result");

    public MainPage searchIconClick () {
        searchIcon.click();
        return this;
    }

    public MainPage enterSearchQuery (String searchQuery) {
        searchInput.setValue(searchQuery).pressEnter();
        // Проверить результаты поиска
        searchResultsContainer.shouldHave(text("You searched for hotel"));
        return this;
    }

    public MainPage areSearchResultsNotEmpty () {
        // Проверить, что найдено хотя бы одно предложение
        searchResults.shouldHave(sizeGreaterThan(0));
        return this;
    }

    public MainPage mainPageOpen () {
        open("/en");
        return this;
    }

    public MainPage cookiesMsgClose () {
        cookiesMsgClose.click();
        return this;
    }

    public MainPage fillContactForm
            (String userName, String userEmail, String userCompany,
             String userPhone, String userInterests) {
        // Нажать на ссылку "Contact us"
        contactLink.click();
        nameField.setValue(userName);
        emailField.setValue(userEmail);
        companyField.setValue(userCompany);
        phoneField.setValue(userPhone);
        interestsField.setValue(userInterests);
        return this;
    }

    public MainPage checkTheConsentBox () {
        // Установить галочку согласия
        checkBox.click();
        return this;
    }

    public MainPage submitForm () {
        sleep(1000);
        submitButton.click();
        return this;
    }

    public MainPage isThankYouMessageDisplayed () {
        thxMsg.shouldHave(text("Thank you for contacting HRS International."));
        return this;
    }

    public MainPage regionChange () {
        regionChangeLink.click();
        regionNorway.click();
        return this;
    }

    public MainPage isPageTitleCorrect (String expectedTitle, String actualTitle) {
        assertEquals(actualTitle, expectedTitle);
        return this;
    }






}
