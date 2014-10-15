package pages;

import org.openqa.selenium.By;
import support.Webdriver;

public class HomePage {
    private final By searchSubmit = By.id("indiGoOneWaySearch_Submit");
    private final By searchOrigin = By.id("indiGoOneWaySearch_Origin");
    private final By searchDepartureDate = By.id("indiGoOneWaySearch_DepartureDate");
    private final By noOfAdultDropDown = By.id("indiGoOneWaySearch_PassengerCounts_0__Count");
    private final By oneWayRadio = By.id("onewayradio");
    private final By closeButtonDialog = By.xpath("//div[@id='oneWaySearchModal']/div[@class='modal-footer']/button[@class='indigo-submit']");
    private final By destinationDropDown = By.id("indiGoOneWaySearch_Destination");


    public void selectOneWayRadio(){
        Webdriver.selectRadioButton(oneWayRadio);
    }

    public void closeDialogBox(){
        Webdriver.clickButton(closeButtonDialog);
    }

    public void selectOrigin(String origin){
        Webdriver.selectByVisibleText(searchOrigin, origin);

    }

    public void selectDestination(String dest){
        Webdriver.selectByVisibleText(destinationDropDown, dest);
    }

    public void clickOnSubmit() {
        Webdriver.clickButton(searchSubmit);
    }

    public void enterDepartureDate(String dateOfTravel) {
        Webdriver.clearField(searchDepartureDate);
        Webdriver.sendKeys(searchDepartureDate, dateOfTravel);
    }

    public void selectNumberOfPassenger() {
        Webdriver.selectByValue(noOfAdultDropDown, "1");
    }
}
