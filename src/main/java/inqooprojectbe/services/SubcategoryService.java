package inqooprojectbe.services;

import inqooprojectbe.model.Subcategory;
import inqooprojectbe.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public Subcategory addSubcategory(Subcategory subcategory){ return subcategoryRepository.save(subcategory);}

    public List<Subcategory> getSubcategories(){return subcategoryRepository.findAll();}
}