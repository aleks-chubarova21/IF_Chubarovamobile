package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SavePage {
    private AndroidDriver currentDriver;

    private final By savedArticleNode = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(5)");
    private final By getArticleTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Appium\")");


    public SavePage(AndroidDriver driver) {
        this.currentDriver = driver;
    }

    public String retrieveSavedArticleTitle() {
        currentDriver.findElement(savedArticleNode).click();
        WebElement element = currentDriver.findElement(getArticleTitle);
        return element.getText();
    }
}
