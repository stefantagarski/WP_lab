package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.*;
import mk.finki.ukim.mk.lab.model.exceptions.NoCategoryFoundException;
import mk.finki.ukim.mk.lab.model.exceptions.NoLocationIDFoundException;
import mk.finki.ukim.mk.lab.repository.jpa.EventBookingRepository;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    private final EventBookingRepository eventBookingRepository;
    private final UserRepository userRepository;

    public EventBookingServiceImpl(EventBookingRepository eventBookingRepository, UserRepository userRepository) {
        this.eventBookingRepository = eventBookingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<EventBooking> placeBooking(String eventName, Long userID, int numberOfTickets) {

        User user = userRepository.findById(userID).orElse(null);

        EventBooking eventBooking = new EventBooking(eventName, (long) numberOfTickets, user);

        return Optional.of(eventBookingRepository.save(eventBooking));
    }
}
