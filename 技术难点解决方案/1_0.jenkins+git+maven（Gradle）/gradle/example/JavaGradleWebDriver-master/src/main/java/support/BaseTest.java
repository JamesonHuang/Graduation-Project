package support;

import org.junit.AfterClass;

public class BaseTest {

    @AfterClass
    public static void tearDown(){
        Webdriver.disposeWebDriver();
    }
}
