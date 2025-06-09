package test;

import webHooks.WebHooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AppOnboardingPage;
import pages.MainDiscoveryPage;

public class MobileTest extends WebHooks {

    @Test
    public void SearchJava() {
        AppOnboardingPage onboardingPage = new AppOnboardingPage(driver);
        MainDiscoveryPage mainPage = new MainDiscoveryPage(driver);

        onboardingPage.skipIntroScreen();
        mainPage.enterSearchQuery("Java");

        String firstResult = mainPage.getFirstSearchResultText();
        Assertions.assertTrue(firstResult.contains("Java"), "Результат: 'Java'");
    }
}