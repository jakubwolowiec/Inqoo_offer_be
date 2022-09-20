package inqooprojectbe.controllers;

import inqooprojectbe.model.CategoryDTO;
import inqooprojectbe.model.Subcategory;
import inqooprojectbe.model.SubcategoryDTO;
import inqooprojectbe.repositories.SubcategoryRepository;
import inqooprojectbe.services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("/category/subcategory/{categoryUUID}")
    public ResponseEntity<List<SubcategoryDTO>> getAllSubcategories(@PathVariable String categoryUUID) {
        List<SubcategoryDTO> subcategoryList = subcategoryService.getSubcategories();
        return new ResponseEntity<>(subcategoryList, HttpStatus.OK);
    }

    @PostMapping("/category/subcategory")
    public ResponseEntity<Subcategory> addSubcategory(@RequestBody Subcategory subcategory) {
        Subcategory categoryToAdd = subcategoryService.addSubcategory(subcategory);
        return new ResponseEntity<>(categoryToAdd, HttpStatus.CREATED);
    }
    @GetMapping("/category/{categoryUUID}/subcategory/{subcategoryUUID}")
    public ResponseEntity<SubcategoryDTO> getUUIDSubcategory(@PathVariable String subcategoryUUID) {
        SubcategoryDTO subcategoryListUUID = subcategoryService.getSubcategoryByUUID(subcategoryUUID);
        return new ResponseEntity<>(subcategoryListUUID, HttpStatus.OK);
    }
}