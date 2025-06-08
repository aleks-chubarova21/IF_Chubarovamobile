package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AppOnboardingPage {
    private final By skipButton = By.id("org.wikipedia:id/fragment_onboarding_skip_button");

    private AndroidDriver currentDriver;

    public AppOnboardingPage(AndroidDriver driver) {
        this.currentDriver = driver;
    }

    public void skipIntroScreen() {
        currentDriver.findElement(skipButton).click();
    }
}
