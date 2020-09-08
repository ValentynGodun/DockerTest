package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static tests.ui.MyExecutionListener.failedTests;

public class BaseTest {
    //Logger log = Logger.getLogger(BaseTest.class.getName());

    @Before
    public void clearCache() {
        clearBrowserCache();
        clearBrowserCookies();
    }

    @Before
    public void setupBrowser() {
        Configuration.browser = "chrome";
        //Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;
 //       Configuration.remote = "http://localhost:4444/wd/hub";

    }

   /* @Before
    public void listener() {
        JUnitCore core = new JUnitCore();
        core.addListener(new JunitListener());
        core.run(BaseTest.class);
    }*/

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

}
