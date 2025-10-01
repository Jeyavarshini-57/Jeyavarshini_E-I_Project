package service;

import exception.BookingException;
import util.LoggerUtil;

public class HotelBookingService {
    public void bookHotel(String city, int nights) throws BookingException {
        if(city.isEmpty() || nights <= 0) {
            throw new BookingException("Invalid hotel booking details!");
        }
        LoggerUtil.info("Hotel booked in " + city + " for " + nights + " nights");
    }
}
