package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class MainDiscoveryPage {
    private AndroidDriver currentDriver;

    private final By searchInputArea = By.id("org.wikipedia:id/search_container");
    private final By actualSearchInput = By.id("org.wikipedia:id/search_src_text");
    private final By firstResultItem = AppiumBy.androidUIAutomator("new UiSelector().text(\"Java\")");
    private final By bottomNavigationExploreIcon = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"org.wikipedia:id/navigation_bar_item_icon_container\").instance(2)");


    public MainDiscoveryPage(AndroidDriver driver) {
        this.currentDriver = driver;
    }

    public void enterSearchQuery(String searchText) {
        currentDriver.findElement(searchInputArea).click();
        currentDriver.findElement(actualSearchInput).sendKeys(searchText);
    }

    public String getFirstSearchResultText() {
        WebElement element = currentDriver.findElement(firstResultItem);
        return element.getText();
    }

    public void tapExploreNavigation() {
        currentDriver.findElement(bottomNavigationExploreIcon).click();
    }
}