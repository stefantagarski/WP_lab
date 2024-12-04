package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByLocation_Id(Long locationId);

    @Query("SELECT e FROM Event e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "OR LOWER(e.description) LIKE LOWER(CONCAT('%', :text, '%'))")
    List<Event> searchEventByNameOrDescriptionIgnoreCase(@Param("text") String text);

    List<Event> searchEventByPopularityScoreGreaterThanEqual(double popularityScoreIsGreaterThan);

    List<Event> searchByNameAndPopularityScore(String text, double rating);

    List<Event> findAllByCategory_Id(Long categoryId);

    Optional<Event> findByName(String name);
}
