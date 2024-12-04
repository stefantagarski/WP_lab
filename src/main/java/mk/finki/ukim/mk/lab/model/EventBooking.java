package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class EventBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;
    private Long numberOfTickets;

    @ManyToOne
    private User user;

    public EventBooking(String eventName, Long numberOfTickets, User user) {
        this.eventName = eventName;
        this.numberOfTickets = numberOfTickets;
        this.user = user;
    }
}
