import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DirtyTest {

        @Test
        public void testOneWayFlightSearch() throws InterruptedException {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://book.goindigo.in/");
            driver.findElement(By.id("onewayradio")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='oneWaySearchModal']/div[@class='modal-footer']/button[@class='indigo-submit']")));
            element.click();
            new Select(driver.findElement(By.id("indiGoOneWaySearch_Origin"))).selectByVisibleText("Pune");
            new Select(driver.findElement(By.id("indiGoOneWaySearch_Destination"))).selectByVisibleText("Delhi");
            new Select(driver.findElement(By.id("indiGoOneWaySearch_PassengerCounts_0__Count"))).selectByValue("1");
            driver.findElement(By.id("indiGoOneWaySearch_DepartureDate")).sendKeys("14 June");
            driver.findElement(By.id("indiGoOneWaySearch_Submit")).click();
        }

}
