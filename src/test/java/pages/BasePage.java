package pages;

import com.codeborne.selenide.Condition;
import utils.PropertyLoader;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {

    public static final String BASE_URL = PropertyLoader.loadProperty("base.URL");

    public String notificationPopupText() {
        $(byAttribute("class", "q-notification__message col")).waitUntil(Condition.visible, 15000);
        return $(byAttribute("class", "q-notification__message col")).getText();
    }

    public String getUrl() {
        return url();
    }

}
