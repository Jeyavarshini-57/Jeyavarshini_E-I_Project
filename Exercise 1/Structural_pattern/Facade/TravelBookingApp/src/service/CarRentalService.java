package service;

import exception.BookingException;
import util.LoggerUtil;

public class CarRentalService {
    public void rentCar(String city, int days) throws BookingException {
        if(city.isEmpty() || days <= 0) {
            throw new BookingException("Invalid car rental details!");
        }
        LoggerUtil.info("Car rented in " + city + " for " + days + " days");
    }
}
