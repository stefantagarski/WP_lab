package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.repository.CategoryRepository;
import mk.finki.ukim.mk.lab.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> listAll() {
        return repository.categoryList();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }
}
