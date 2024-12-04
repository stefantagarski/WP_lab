package mk.finki.ukim.mk.lab.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double popularityScore;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Location location;

    private int ticketCount;


    public Event(String name, String description, double popularityScore, Category category, Location location, int ticketCount) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.category = category;
        this.location = location;
        this.ticketCount = ticketCount;
    }
}
