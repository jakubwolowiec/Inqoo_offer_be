package inqooprojectbe.services;

import inqooprojectbe.model.Subcategory;
import inqooprojectbe.model.SubcategoryDTO;
import inqooprojectbe.model.SubcategoryMapper;
import inqooprojectbe.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;
    public SubcategoryService(SubcategoryRepository subcategoryRepository, SubcategoryMapper subcategoryMapper) {
        this.subcategoryRepository = subcategoryRepository;
        this.subcategoryMapper = subcategoryMapper;
    }

    public Subcategory addSubcategory(Subcategory subcategory){ return subcategoryRepository.save(subcategory);}

    public List<SubcategoryDTO> getSubcategories()
    {List<SubcategoryDTO>subcategoryDTOList = new ArrayList<>();
        for (
    Subcategory subcategory: subcategoryRepository.findAll()
            ) {
        subcategoryDTOList.add(subcategoryMapper.toDTO(subcategory));
    }
        return subcategoryDTOList;}

    public SubcategoryDTO getSubcategoryByUUID(String subCategoryUUID) {
        return null;
    }
}