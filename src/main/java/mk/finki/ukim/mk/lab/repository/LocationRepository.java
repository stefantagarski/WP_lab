package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepository {
    public List<Location> findAll() {
        return DataHolder.locations;
    }

    public Optional<Location> findById(Long id) {
        return DataHolder.locations.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
