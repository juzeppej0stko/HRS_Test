import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
public class HRS_Tests {
    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://www.hrsinternational.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testPageTitle() {
        open("/en");
        String expectedTitle = "HRS Global - HRS Hospitality & Retail Systems";
        String actualTitle = title();
        assert actualTitle.equals(expectedTitle) : "Page title doesn't match expected value";
    }
}

