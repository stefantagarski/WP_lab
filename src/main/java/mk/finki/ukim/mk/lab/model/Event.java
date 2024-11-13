package mk.finki.ukim.mk.lab.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Event {
    private Long id;
    private String name;
    private String description;
    private double popularityScore;
    private Category category;
    private Location location;

    public Event(String name, String description, double popularityScore, Category category, Location location) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.category = category;
        this.location = location;
    }
}
