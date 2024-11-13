package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> listAll();

    Optional<Category> findById(Long id);
}
