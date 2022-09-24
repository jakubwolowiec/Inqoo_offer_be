package inqooprojectbe.services;

import inqooprojectbe.model.Category;
import inqooprojectbe.model.Subcategory;
import inqooprojectbe.model.SubcategoryDTO;
import inqooprojectbe.model.SubcategoryMapper;
import inqooprojectbe.repositories.CategoryRepository;
import inqooprojectbe.repositories.SubcategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;
    private final CategoryRepository categoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository, SubcategoryMapper subcategoryMapper, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.subcategoryMapper = subcategoryMapper;
        this.categoryRepository = categoryRepository;
    }

    public Subcategory addSubcategory(Subcategory subcategory, String categoryUUID) {
        subcategory.setSubcategoryUUID(UUID.randomUUID().toString());
        subcategoryRepository.save(subcategory);
        Category byCategoryUUID = categoryRepository.findByCategoryUUID(categoryUUID);
        Subcategory subcategory1 = byCategoryUUID.addSubcategory(subcategory);
        return subcategory1;
    }

    public List<SubcategoryDTO> getSubcategoriesByCategoryUUID(String categoryUUID) {
        List<SubcategoryDTO> subcategoryDTOList = new ArrayList<>();
        for (
                Subcategory subcategory : categoryRepository.findByCategoryUUID(categoryUUID).getSubcategories()
        ) {
            subcategoryDTOList.add(subcategoryMapper.toDTO(subcategory));
        }
        return subcategoryDTOList;
    }

}