package scenarios;

import domain.JourneyDetails;
import domain.JourneyDetailsBuilder;
import org.testng.annotations.Test;


public class Chapter_08_ImproveReadability_UserDrivenBehavior extends BaseScenario{


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







}
