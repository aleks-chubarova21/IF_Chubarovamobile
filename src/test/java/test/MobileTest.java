package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AppOnboardingPage;
import pages.MainDiscoveryPage;
import pages.SearchResultPage;
import pages.SavePage;
import webHooks.WebHooks;

public class MobileTest extends WebHooks {

    @Test
    public void verifySearchForJavaAndFirstResult() {

        AppOnboardingPage onboardingPage = new AppOnboardingPage(driver);
        MainDiscoveryPage mainPage = new MainDiscoveryPage(driver);

        onboardingPage.skipIntroScreen();
        mainPage.enterSearchQuery("Java");

        String firstResult = mainPage.getFirstSearchResultText();
        Assertions.assertTrue(firstResult.contains("Java"), "Первый результат поиска должен содержать 'Java'");
    }

    @Test
    public void verifyArticleSaveAndRetrieve() {
        AppOnboardingPage onboardingPage = new AppOnboardingPage(driver);
        MainDiscoveryPage mainPage = new MainDiscoveryPage(driver);
        SearchResultPage searchActionsPage = new SearchResultPage(driver);
        SavePage savedPage = new SavePage(driver);

        onboardingPage.skipIntroScreen();
        mainPage.tapExploreNavigation();
        searchActionsPage.initiateNewSearch("Appium");
        searchActionsPage.selectFirstResultAndSave();
        searchActionsPage.navigateToSavedItems();

        String savedArticleTitle = savedPage.retrieveSavedArticleTitle();
        Assertions.assertEquals("Appium", savedArticleTitle, "Сохраненная статья должна быть 'Appium'");
    }
}
