package inqooprojectbe.controllers;

import inqooprojectbe.model.Subcategory;
import inqooprojectbe.model.SubcategoryDTO;
import inqooprojectbe.services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/category/subcategory/{categoryUUID}")
    public ResponseEntity<Subcategory> addSubcategory(@RequestBody Subcategory subcategory, @PathVariable String categoryUUID) {
        Subcategory subcategoryToAdd = subcategoryService.addSubcategory(subcategory, categoryUUID);
        return new ResponseEntity<>(subcategoryToAdd, HttpStatus.CREATED);
    }

    @GetMapping("/category/{categoryUUID}/subcategory/{subcategoryUUID}")
    public ResponseEntity<SubcategoryDTO> getSubcategoryByUUID(@PathVariable String subcategoryUUID) {
        SubcategoryDTO subcategoryListUUID = subcategoryService.getSubcategoryByUUID(subcategoryUUID);
        return new ResponseEntity<>(subcategoryListUUID, HttpStatus.OK);
    }
}