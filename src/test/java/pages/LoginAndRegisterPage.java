package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginAndRegisterPage {

    /*login form*/
    //List list = $$(byAttribute("class", "q-field__native q-placeholder"));

    public LoginAndRegisterPage fillEmailInLoginForm(String email) {
        $(byXpath("//div[@data-selector = 'loginEmail']//input")).shouldBe(Condition.visible);
        $(byXpath("//div[@data-selector = 'loginEmail']//input")).sendKeys(email);
        return this;
    }

    public LoginAndRegisterPage fillPasswordInLoginForm(String password) {
        $(byXpath("//div[@data-selector = 'loginPassword']//input")).sendKeys(password);
        return this;
    }

    public LoginAndRegisterPage clickLoginButtonInLoginForm() {
        $(byAttribute("label*", "og")).click();
        return new LoginAndRegisterPage();
    }

    public LoginAndRegisterPage selectRememberMeCheckboxInRegisterForm() {

        return this;
    }

    public LoginAndRegisterPage clickForgotPasswordLink() {

        return new LoginAndRegisterPage();
    }


    /*register*/
    public LoginAndRegisterPage fillCompanyNameInRegisterPage(String companyName) {
        $(byXpath("//div[@data-selector = 'registerCompany']//input")).sendKeys(companyName);
        return this;
    }

    public LoginAndRegisterPage fillFirstAndLastNameInRegisterPage(String name) {
        $(byXpath("//div[@data-selector = 'registerName']//input")).sendKeys(name);
        return this;
    }

    public LoginAndRegisterPage fillEmailInRegisterPage(String email) {
        $(byXpath("//div[@data-selector = 'registerEmail']//input")).sendKeys(email);
        return this;
    }

    public LoginAndRegisterPage selectCheckboxAboutAdvertisingInRegisterPage() {

        return this;
    }

    public LoginAndRegisterPage clickRegisterForFreeInRegisterPage() {
        $(byAttribute("data-selector", "registerSubmit")).click();
        return new LoginAndRegisterPage();
    }

    public LoginAndRegisterPage clickTermsAndConditionsInRegisterPage() {

        return this;
    }

    public LoginAndRegisterPage clickPrivacyPolicyInRegisterPage() {

        return this;
    }


}
