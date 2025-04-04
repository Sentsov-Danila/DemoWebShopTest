package demowebshop.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import demowebshop.pages.MainPage;
import net.datafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private static final String mainPageURL = "https://demowebshop.tricentis.com/";
    private final Faker faker = new Faker();
    private final MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadTimeout = 100000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void registerNewUser() {
        String password = faker.internet().password();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String confirmPassword = password;
        String email = faker.internet().emailAddress();
        Selenide.open(mainPageURL, MainPage.class );

        mainPage.clickRegistrationButton()
                .clickRandomGenderButton()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword)
                .clickRegisterButton();
    }
    @AfterEach
    void logOutUser() {
        mainPage
                .clickLogOutButton();
    }
}
