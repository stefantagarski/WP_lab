package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {
    public List<Category> categoryList() {
        return DataHolder.categories;
    }
}
