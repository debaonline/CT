package scenarios;

import domain.JourneyDetails;
import domain.JourneyDetailsBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spec.SpecDefinition;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Chapter_08_ImproveReadability_UserDrivenBehavior {

    // Use the application driver
    WebDriver driver;
    PageStore pageStore;

    SpecDefinition user ;



    @BeforeMethod
      public void setup(){
        // initialize driver
        pageStore = new PageStore();
        user = new SpecDefinition(pageStore);

        //launch the application under test
        driver = pageStore.getDriver();
        driver.get("http://www.cleartrip.com/");

        given(user).choosesToDoAFlightSearch();
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney(){

        //create your test data - the journey detail domain object
        JourneyDetails journeyDetails = new JourneyDetailsBuilder().isOneWay(true).
                withOrigin("Bangalore").withDestination("Delhi").
                withDepartureDate(tomorrow()).build();


        when(user).searchesForAOneWayJourneyWith(journeyDetails);
        then(user).hasJourneyOptionsAvailableForHisOutboundJourney();
    }


    @Test
    public void testThatResultsAppearForAReturnJourney(){

        //create your test data - the journey detail domain object
        JourneyDetails journeyDetails = new JourneyDetailsBuilder().isOneWay(false).
                withOrigin("Bangalore").withDestination("Delhi").
                withDepartureDate(tomorrow()).withReturnDate(dayAfterTomorrow()).build();

        when(user).searchesForAReturnJourneyWith(journeyDetails);
        then(user).hasJourneyOptionsAvailableForTheReturnJourney();


    }


    @AfterMethod
    public void teardown(){
        //close the browser
        pageStore.destroy();

    }


    public String tomorrow(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }

    public String dayAfterTomorrow(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 2);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }


    protected <T extends SpecDefinition> T given(T dsl) {
        return dsl;
    }

    protected <T extends SpecDefinition> T when(T dsl) {
        return dsl;
    }

    protected <T extends SpecDefinition> T then(T dsl) {
        return dsl;
    }

    protected <T extends SpecDefinition> T and(T dsl) {
        return dsl;
    }


}
