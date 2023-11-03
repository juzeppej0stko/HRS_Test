package guru.kazakov;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en"));
    String query = "hotel";
    String name = faker.name().firstName();;
    String email = faker.internet().emailAddress();
    String company = faker.company().name();
    String phone = faker.phoneNumber().cellPhone();
    String interests = faker.lorem().words(3).toString();
    String textInsidePdf = "V8 Development Team";

}
