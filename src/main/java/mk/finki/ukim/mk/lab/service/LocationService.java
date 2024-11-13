package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<Location> findAll();

    Optional<Location> findById(Long id);
}
