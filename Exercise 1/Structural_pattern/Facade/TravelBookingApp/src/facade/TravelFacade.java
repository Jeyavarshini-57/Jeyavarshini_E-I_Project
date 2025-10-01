package facade;

import service.FlightBookingService;
import service.HotelBookingService;
import service.CarRentalService;
import exception.BookingException;

public class TravelFacade {
    private final FlightBookingService flightService;
    private final HotelBookingService hotelService;
    private final CarRentalService carService;

    public TravelFacade() {
        flightService = new FlightBookingService();
        hotelService = new HotelBookingService();
        carService = new CarRentalService();
    }

    public void bookTravel(String from, String to, String city, int nights, int days) throws BookingException {
        flightService.bookFlight(from, to);
        hotelService.bookHotel(city, nights);
        carService.rentCar(city, days);
    }
}
