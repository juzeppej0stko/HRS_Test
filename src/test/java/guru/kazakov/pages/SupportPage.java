package guru.kazakov.pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SupportPage {
    private SelenideElement
            supportLink = $(".external-link"),
            docsLink = $(By.xpath("//a[text()='Documentation']"));
    public SupportPage supportPageOpen () {
        supportLink.click();
        switchTo().window(1);
        return this;
    }

    public SupportPage docsPageOpen () {
        docsLink.click();
        return this;
    }

    public SupportPage isPdfDownloadedAndContainsText (String text) throws Exception {
        File downloadedFile = $(By.linkText("Fidelio v8")).download();
        PDF content = new PDF(downloadedFile);
        assertThat(content.text).contains(text);
        return this;
    }

}
