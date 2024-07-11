package tests;

import data.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod; // Correct import for BeforeMethod
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SeatSelectionPage;

import java.io.IOException;

public class SeatSelectionTest extends TestBase {

    HomePage homeObject;
    SearchResultsPage searchResultsObject;
    SeatSelectionPage seatSelectionObject;

    String fromCity;
    String toCity;
    String departureDate;
    String mobileNumber;
    String email;
    String name;
    String gender;
    String age;
    String concession;
    String idCard;
    String idNumber;
    String seatPageMessage;

    @BeforeClass
    public void setupTestData() throws IOException, ParseException {
        fromCity = JsonReader.jsonData("TripData", "fromCity");
        toCity = JsonReader.jsonData("TripData", "toCity");
        departureDate = JsonReader.jsonData("TripData", "departureDate");
        mobileNumber = JsonReader.jsonData("CustomerDetails", "mobileNumber");
        email = JsonReader.jsonData("CustomerDetails", "email");
        name = JsonReader.jsonData("CustomerDetails", "name");
        gender = JsonReader.jsonData("CustomerDetails", "gender");
        age = JsonReader.jsonData("CustomerDetails", "age");
        concession = JsonReader.jsonData("CustomerDetails", "concession");
        idCard = JsonReader.jsonData("CustomerDetails", "idCard");
        idNumber = JsonReader.jsonData("CustomerDetails", "idNumber");
        seatPageMessage = JsonReader.jsonData("Assertions", "seatPageMessage");
    }

    @BeforeMethod
    public void setUp() {
        homeObject = new HomePage(driver);
        searchResultsObject = new SearchResultsPage(driver);
        seatSelectionObject = new SeatSelectionPage(driver);
    }



    @Test
    public void userCanSelectBoardingPoint() throws InterruptedException {
        homeObject.searchForAvailableTickets(fromCity, toCity, departureDate);
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains(seatPageMessage));
        seatSelectionObject.selectBoardingPoint();
    }

    @Test
    public void userCanSelectDroppingPoint() throws InterruptedException {
        homeObject.searchForAvailableTickets(fromCity, toCity, departureDate);
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains(seatPageMessage));
        seatSelectionObject.selectDroppingPoint();
    }

    @Test
    public void userCanSelectSeat() throws InterruptedException {
        homeObject.searchForAvailableTickets(fromCity, toCity, departureDate);
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains(seatPageMessage));
        seatSelectionObject.selectAvailableSeat();
    }

    @Test
    public void userCanFillTripInfo() throws InterruptedException {
        homeObject.searchForAvailableTickets(fromCity, toCity, departureDate);
        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains(seatPageMessage));
        seatSelectionObject.selectBoardingPoint();
        seatSelectionObject.selectDroppingPoint();
        seatSelectionObject.selectAvailableSeat();
        seatSelectionObject.navigateToPassengerDetails();
    }

    @Test
    public void userCanEnterHisDetails() throws InterruptedException {
        homeObject.searchForAvailableTickets(fromCity, toCity, departureDate);

        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains(seatPageMessage));
        seatSelectionObject.selectBoardingPoint();
        seatSelectionObject.selectDroppingPoint();
        seatSelectionObject.selectAvailableSeat();
        seatSelectionObject.navigateToPassengerDetails();
        seatSelectionObject.enterCustomerDetails(mobileNumber, email);
    }

    @Test
    public void userCanFillCheckoutDetails() throws InterruptedException {
        System.out.println(departureDate);
        homeObject.searchForAvailableTickets(fromCity, toCity, departureDate);

        searchResultsObject.selectTrip();
        Assert.assertTrue(seatSelectionObject.getSeatPageAssertionTxt().contains(seatPageMessage));
        seatSelectionObject.selectBoardingPoint();
        seatSelectionObject.selectDroppingPoint();
        seatSelectionObject.selectAvailableSeat();
        seatSelectionObject.navigateToPassengerDetails();
        seatSelectionObject.enterCustomerDetails(mobileNumber, email);
        seatSelectionObject.enterPassengerDetails(name, gender, age, concession, idCard, idNumber);
        Assert.assertTrue(seatSelectionObject.payButtonIsDisplayedAssertion());
    }
}
