package inqooprojectbe.services;

import inqooprojectbe.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inqooprojectbe.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository)
    {this.categoryRepository = categoryRepository;}

    public Category addCategory(Category category){return categoryRepository.save(category);}

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}