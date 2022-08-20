package inqooprojectbe.controllers;

import inqooprojectbe.model.Category;
import inqooprojectbe.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class CategoryController {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category categoryToAdd = categoryRepository.save(category);
        return new ResponseEntity<>(categoryToAdd, HttpStatus.OK);
    }
}
