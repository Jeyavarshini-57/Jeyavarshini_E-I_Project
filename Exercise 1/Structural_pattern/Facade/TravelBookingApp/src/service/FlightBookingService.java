package service;

import exception.BookingException;
import util.LoggerUtil;

public class FlightBookingService {
    public void bookFlight(String from, String to) throws BookingException {
        if(from.isEmpty() || to.isEmpty()) {
            throw new BookingException("Flight source or destination cannot be empty!");
        }
        LoggerUtil.info("Flight booked from " + from + " to " + to);
    }
}
