package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventBooking {
    private String eventName;
    private String attendeeName;
    private String attendeeAddress;
    private Long numberOfTickets;
}
