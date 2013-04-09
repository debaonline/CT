package spec;

import domain.JourneyDetails;
import org.testng.Assert;
import page.FlightsSearchPage;
import page.LandingPage;
import page.SearchResultsPage;
import scenarios.PageStore;


public class SpecDefinition {


    LandingPage onLandingPage;
    FlightsSearchPage onFlightsSearchPage;
    SearchResultsPage onResultsPage;
    PageStore pageStore;


    public SpecDefinition(PageStore pageStore) {
        this.pageStore = pageStore;
    }


    public SpecDefinition(LandingPage onLandingPage) {
        this.onLandingPage = onLandingPage;
    }

    public void searchesForAOneWayJourneyWith(JourneyDetails journeyDetails) {
        FlightsSearchPage onFlightsSearchPage = pageStore.get(FlightsSearchPage.class);
        onFlightsSearchPage.searchForAOneWayJourneyWith(journeyDetails);
    }


    public void hasJourneyOptionsAvailableForHisOutboundJourney() {
        Assert.assertTrue(pageStore.get(SearchResultsPage.class).resultsAppearForOutboundJourney());
    }

    public void searchesForAReturnJourneyWith(JourneyDetails journeyDetails) {
        FlightsSearchPage onFlightsSearchPage = pageStore.get(FlightsSearchPage.class);
        onFlightsSearchPage.searchForAReturnJourneyWith(journeyDetails);
    }

    public void hasJourneyOptionsAvailableForTheReturnJourney() {
        SearchResultsPage onResultsPage = pageStore.get(SearchResultsPage.class);
        Assert.assertTrue(onResultsPage.resultsAppearForOutboundJourney());
        Assert.assertTrue(onResultsPage.resultsAppearForInboundJourney());
    }

    public void choosesToDoAFlightSearch() {
        LandingPage onLandingPage = pageStore.get(LandingPage.class);
        onLandingPage.goToFlightsSearchPage();
    }
}
