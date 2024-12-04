package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCategoryRepository {
    public List<Category> categoryList() {
        return DataHolder.categories;
    }

    public Optional<Category> findById(Long id) {
        return DataHolder.categories.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
