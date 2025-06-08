package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    private AndroidDriver currentDriver;

    private final By searchEntryCard = By.id("org.wikipedia:id/search_card");
    private final By searchInputText = By.id("org.wikipedia:id/search_src_text");
    private final By firstResultViewGroup = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(1)");
    private final By saveArticleButton = By.id("org.wikipedia:id/page_save");
    private final By navigateUpButton = AppiumBy.androidUIAutomator("new UiSelector().description(\"Navigate up\")");
    private final By savedTabNavigation = By.id("org.wikipedia:id/nav_tab_reading_lists");

    public SearchResultPage(AndroidDriver driver) {
        this.currentDriver = driver;
    }

    public void initiateNewSearch(String searchText) {
        currentDriver.findElement(searchEntryCard).click();
        currentDriver.findElement(searchInputText).sendKeys(searchText);
    }

    public void selectFirstResultAndSave() {
        currentDriver.findElement(firstResultViewGroup).click();
        currentDriver.findElement(saveArticleButton).click();
    }

    public void navigateToSavedItems() {
        currentDriver.findElement(navigateUpButton).click();
        currentDriver.findElement(navigateUpButton).click();
        currentDriver.findElement(savedTabNavigation).click();
    }
}
