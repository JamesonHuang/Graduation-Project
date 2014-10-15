package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver {

    private final static WebDriver DRIVER = new Browser().getDriver();
    private final static WebDriverWait wait = new WebDriverWait(DRIVER, 10);

    public static void get(String url){
        DRIVER.get(url);
    }

    private static WebElement getWebElement(By by){
        return DRIVER.findElement(by);
    }

    public static void selectRadioButton(By by){
        getWebElement(by).click();
    }


    public static void clickButton(By by) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }


    public static void selectByVisibleText(By by, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        new Select(element).selectByVisibleText(text);
    }

    public static void clearField(By by) {
        getWebElement(by).clear();
    }

    public static void sendKeys(By by, String text) {
        getWebElement(by).sendKeys(text);
    }

    public static void selectByValue(By by, String value) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        new Select(element).selectByValue(value);
    }

    public static void selectCheckBox(By by) {
        getWebElement(by).click();
    }

    public static boolean isElementDisplayed(By by) {
        return getWebElement(by).isDisplayed();
    }

    public static void disposeWebDriver(){
        DRIVER.quit();
    }

}
