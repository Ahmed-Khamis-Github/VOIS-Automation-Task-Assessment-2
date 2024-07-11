package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SeatSelectionPage;

public class SearchBusesTest extends TestBase {
    HomePage homeObject ;
    SearchResultsPage searchResultsObject ;

    SeatSelectionPage seatSelectionObject ;

    @BeforeMethod
    public void setUp() {
        homeObject = new HomePage(driver);
        searchResultsObject = new SearchResultsPage(driver) ;
        seatSelectionObject = new SeatSelectionPage(driver) ;

    }

    @Test()
    public void userCanSearchForTicket() throws InterruptedException {
        homeObject.searchForAvailableTickets("Chikkamagaluru", "Bengaluru", "2024-08-2");
         Assert.assertTrue(searchResultsObject.getSearchDetailsTxt().contains("Chikkamagaluru"));
    }

    @Test()
    public  void userCanSelectTrip () throws InterruptedException {
        homeObject.searchForAvailableTickets("Chikkamagaluru", "Bengaluru", "2024-08-2");
         searchResultsObject.selectTrip();
         Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains("Please select seat"));

    }




}
