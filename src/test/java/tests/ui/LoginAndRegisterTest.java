package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import pages.ShippingCostCalculator;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.BASE_URL;

@RunWith(MyTestRunner.class)
public class LoginAndRegisterTest extends BaseTest {

    HomePage homePage = new HomePage();
    LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage();
    ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void loginTest() {
        open(BASE_URL);

        homePage.clickLoginAndRegisterButton();

        loginAndRegisterPage.fillEmailInLoginForm("aaa@i.ua")
                .fillPasswordInLoginForm("aaaa")
                .clickLoginButtonInLoginForm();


        List possibleTextPopup = Stream.of("Eingeloggt", "Logged in").collect(Collectors.toList());
        String notificationPopupText = shippingCostCalculator.notificationPopupText();

        Assert.assertTrue("Incorrect notification popup text OR can't login.  Popup text: " + notificationPopupText, possibleTextPopup.contains(notificationPopupText));
        Assert.assertTrue("Looks like couldn't login, please check!", shippingCostCalculator.isLogoutButtonDisplayed());

        //TODO move login and pass to another place
    }

    @Test
    public void registerNewUser() {
        String randomUUIDString = UUID.randomUUID().toString();
        String email = randomUUIDString + "@aa.aaa";

        open(BASE_URL);

        homePage.clickLoginAndRegisterButton();

        loginAndRegisterPage.fillFirstAndLastNameInRegisterPage("Test")
                .fillEmailInRegisterPage(email)
                .clickRegisterForFreeInRegisterPage();

        List possibleTextPopup = Stream.of("Eingeloggt", "Registered").collect(Collectors.toList());
        String notificationPopupText = shippingCostCalculator.notificationPopupText();

        Assert.assertTrue("Incorrect notification popup text OR couldn't register new user. Popup text: " + notificationPopupText, possibleTextPopup.contains(notificationPopupText));
        Assert.assertTrue("Looks like couldn't register new user, please check!", shippingCostCalculator.isLogoutButtonDisplayed());
    }

    @Test
    public void registerNewUserWithCompanyName() {
        String randomUUIDString = UUID.randomUUID().toString();
        String email = randomUUIDString + "@aasa.dev";

        open(BASE_URL);

        homePage.clickLoginAndRegisterButton();

        loginAndRegisterPage.fillCompanyNameInRegisterPage("aaaaa")
                .fillFirstAndLastNameInRegisterPage("aaaa Test")
                .fillEmailInRegisterPage(email)
                .clickRegisterForFreeInRegisterPage();

        List possibleTextPopup = Stream.of("Eingeloggt", "Registered").collect(Collectors.toList());
        String notificationPopupText = dashboardPage.notificationPopupText();

        Assert.assertTrue("Incorrect notification popup text OR couldn't register new user. Popup text: " + notificationPopupText, possibleTextPopup.contains(notificationPopupText));

        dashboardPage.clickMenu().chooseAccountSetting();
        Assert.assertTrue("Radio button 'Business' doesn't selected", dashboardPage.checkIfBusinessAccountTypeSelected());

    }

}
