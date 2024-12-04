package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.EventBooking;

import java.util.Optional;

public interface EventBookingService{
     Optional<EventBooking> placeBooking(String eventName, Long userID, int numberOfTickets);
}
