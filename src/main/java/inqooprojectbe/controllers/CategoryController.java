package inqooprojectbe.controllers;

import inqooprojectbe.model.Category;
import inqooprojectbe.model.CategoryDTO;
import inqooprojectbe.repositories.CategoryRepository;
import inqooprojectbe.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categoryList = categoryService.getCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category categoryToAdd = categoryService.addCategory(category);
        return new ResponseEntity<>(categoryToAdd, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryUUID}")
    public ResponseEntity<CategoryDTO> getCategoryByUUID(@PathVariable UUID categoryUUID) {
        CategoryDTO categoryDTO = categoryService.getCategoryByUUID(categoryUUID);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }
}
