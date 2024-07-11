package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SeatSelectionPage;

public class SeatSelectionTest extends TestBase {

    HomePage homeObject;
    SearchResultsPage searchResultsObject;

    SeatSelectionPage seatSelectionObject;

    @BeforeMethod
    public void setUp() {
        homeObject = new HomePage(driver);
        searchResultsObject = new SearchResultsPage(driver);
        seatSelectionObject = new SeatSelectionPage(driver);

    }

    @Test
    public void userCanSelectBoardingPoint() throws InterruptedException {
        homeObject.searchForAvailableTickets("Chikkamagaluru", "Bengaluru", "2024-08-2");
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains("Please select seat"));
        seatSelectionObject.selectBoardingPoint();
    }


    @Test
    public void userCanSelectDroppingPoint() throws InterruptedException {
        homeObject.searchForAvailableTickets("Chikkamagaluru", "Bengaluru", "2024-08-2");
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains("Please select seat"));
        seatSelectionObject.selectDroppingPoint();
    }


    @Test
    public void userCanSelectSeat() throws InterruptedException {
        homeObject.searchForAvailableTickets("Chikkamagaluru", "Bengaluru", "2024-08-2");
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains("Please select seat"));
        seatSelectionObject.selectAvailableSeat();
    }


    @Test
    public void userCanFillTripInfo() throws InterruptedException {
        homeObject.searchForAvailableTickets("Chikkamagaluru", "Bengaluru", "2024-08-2");
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains("Please select seat"));
        seatSelectionObject.selectBoardingPoint();
        seatSelectionObject.selectDroppingPoint();
        seatSelectionObject.selectAvailableSeat();
        seatSelectionObject.navigateToPassengerDetails();
    }

    @Test
    public void userCanEnterHisDetails() throws InterruptedException {
        homeObject.searchForAvailableTickets("Chikkamagaluru", "Bengaluru", "2024-08-2");
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains("Please select seat"));
        seatSelectionObject.selectBoardingPoint();
        seatSelectionObject.selectDroppingPoint();
        seatSelectionObject.selectAvailableSeat();
        seatSelectionObject.navigateToPassengerDetails();
        seatSelectionObject.enterCustomerDetails("6789125987","ahmedd@gmail.com");
    }


    @Test
    public void userCanFillCheckoutDetails() throws InterruptedException {
        homeObject.searchForAvailableTickets("Chikkamagaluru", "Bengaluru", "2024-08-2");
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains("Please select seat"));
        seatSelectionObject.selectBoardingPoint();
        seatSelectionObject.selectDroppingPoint();
        seatSelectionObject.selectAvailableSeat();
        seatSelectionObject.navigateToPassengerDetails();
        seatSelectionObject.enterCustomerDetails("6789125987","ahmedd@gmail.com");

        seatSelectionObject.enterPassengerDetails("ahmed","Male","20","GENERAL PUBLIC", "PAN","5454");

        Assert.assertTrue(seatSelectionObject.payButtonIsDisplayedAssertion());
    }

}
