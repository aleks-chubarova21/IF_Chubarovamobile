package webHooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import util.TestProperties;

public class WebHooks {
    protected AndroidDriver driver;

    @BeforeEach
    protected void initAppiumDriver() throws Exception {
        File appFile = new File("src/test/resources/apk/org.wikipedia_50460_apps.evozi.com.apk");

        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_2_API_27");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", appFile.getAbsolutePath());
        capabilities.setCapability("orientation", "PORTRAIT");

        String appiumUrl = TestProperties.getProperty("appiumurl").trim();
        if (!appiumUrl.endsWith("/")) {
            appiumUrl += "/";
        }

        driver = new AndroidDriver(new URL(appiumUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    protected void closeAppiumDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}