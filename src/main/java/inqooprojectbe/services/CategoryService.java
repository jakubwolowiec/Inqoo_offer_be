package inqooprojectbe.services;

import inqooprojectbe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inqooprojectbe.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Category addCategory(Category category) {
        category.setCategoryUUID(UUID.randomUUID());
        return categoryRepository.save(category);
    }

    public List<CategoryDTO> getCategories() {
        {
            List<CategoryDTO> categoryDTOList = new ArrayList<>();
            for (Category category : categoryRepository.findAll()
            ) {
                categoryDTOList.add(categoryMapper.toDTO(category));
            }
            return categoryDTOList;
        }
    }

    public CategoryDTO getCategoryByUUID(UUID categoryUUID) {

        return categoryMapper.toDTO(categoryRepository.findByCategoryUUID(categoryUUID));



    }
}