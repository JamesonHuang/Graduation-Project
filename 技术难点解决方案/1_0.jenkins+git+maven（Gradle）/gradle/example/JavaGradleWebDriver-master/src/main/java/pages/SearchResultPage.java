package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Webdriver;

public class SearchResultPage {
    private final By continueButton = By.cssSelector("#indiGoAvailability_Submit");
    private final By fareRulesCheckBox = By.cssSelector("#indiGoAvailability_fareRules_DoesAgreeToTerms");
    private final By firstSearchResultRadioButton = By.cssSelector("#trip_0_flight_0_fare_0");
    private final By availaabilityContainer = By.cssSelector("#availabilityContainer");


    public void clickOnContinue() {
        Webdriver.clickButton(continueButton);
    }

    public void acceptTermsAndConditions() {
        Webdriver.selectCheckBox(fareRulesCheckBox);
    }

    public void selectFirstAvailableTicket() {
        Webdriver.selectRadioButton(firstSearchResultRadioButton);
    }

    public boolean isSearchResultContainerDisplayed() {
        return Webdriver.isElementDisplayed(availaabilityContainer);
    }
}
