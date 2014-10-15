import flow.SearchFlow;
import junit.runner.BaseTestRunner;
import org.junit.Before;
import org.junit.Test;
import support.BaseTest;
import support.Webdriver;



public class MyIndigoTest extends BaseTest {

    @Before
    public void setUp(){
        Webdriver.get("https://book.goindigo.in/");
    }

    @Test
    public void testOneWayFlightSearch() throws InterruptedException {
        new SearchFlow().searchOneWayJourney("Pune", "Delhi", "14 Jun 2014").verifySearchResult().selectJourneyAndContinue()
        .enterUserDetails();
    }




}
