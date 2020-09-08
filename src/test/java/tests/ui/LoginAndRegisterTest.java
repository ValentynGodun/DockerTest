package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.LoginAndRegisterPage;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.BASE_URL;

@RunWith(MyTestRunner.class)
public class LoginAndRegisterTest extends BaseTest {

    LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage();

    @Test
    public void registerNewUserWithCompanyName() {
        String randomUUIDString = UUID.randomUUID().toString();
        String email = randomUUIDString + "@aasa.dev";

        open(BASE_URL);

        loginAndRegisterPage.fillCompanyNameInRegisterPage("aaaaa")
                .fillFirstAndLastNameInRegisterPage("aaaa Test")
                .fillEmailInRegisterPage(email)
                .clickRegisterForFreeInRegisterPage();

        List possibleTextPopup = Stream.of("Eingeloggt", "Registered").collect(Collectors.toList());


    }

}
