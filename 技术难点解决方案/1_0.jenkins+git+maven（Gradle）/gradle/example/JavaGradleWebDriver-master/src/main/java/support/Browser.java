package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropUtil;

import static org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS;
import static org.openqa.selenium.remote.CapabilityType.HAS_NATIVE_EVENTS;
import static org.openqa.selenium.remote.CapabilityType.TAKES_SCREENSHOT;

public class Browser {

    public WebDriver getDriver() {
        String browserName = PropUtil.getPropertyValue("webdriver.browser");
        if (browserName.equalsIgnoreCase("FIREFOX")) {
            return startFirefox();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            return startChrome();
        }


        return null;
    }

    public WebDriver startFirefox() {
        FirefoxProfile profile = new FirefoxProfile();
        return new FirefoxDriver(profile);
    }

    public WebDriver startIE() {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
        desiredCapabilities.setCapability(ACCEPT_SSL_CERTS, true);
        desiredCapabilities.setCapability(HAS_NATIVE_EVENTS, true);
        desiredCapabilities.setCapability(TAKES_SCREENSHOT, true);
        return new InternetExplorerDriver(desiredCapabilities);
    }

    public WebDriver startChrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/atirek/Projects/My Frameworks/JavaGradleWebDriver/drivers/chromedriver");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setPlatform(org.openqa.selenium.Platform.ANY);
        return new ChromeDriver();

    }

}
