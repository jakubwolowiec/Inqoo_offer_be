package inqooprojectbe.controllers;

import inqooprojectbe.model.Subcategory;
import inqooprojectbe.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SubcategoryController {

    private SubcategoryRepository subcategoryRepository;

    @Autowired
    public SubcategoryController(SubcategoryRepository subcategoryRepository){this.subcategoryRepository = subcategoryRepository;}

    @GetMapping("/subcategories")
    public ResponseEntity<List<Subcategory>> getAllSubcategories() {
        List<Subcategory> subcategoryList = subcategoryRepository.findAll();
        return new ResponseEntity<>(subcategoryList, HttpStatus.OK);
    }

    @PostMapping("/addSubcategory")
    public ResponseEntity<Subcategory> addSubcategory(@RequestBody Subcategory subcategory) {
        Subcategory categoryToAdd = subcategoryRepository.save(subcategory);
        return new ResponseEntity<>(categoryToAdd, HttpStatus.OK);
    }
}