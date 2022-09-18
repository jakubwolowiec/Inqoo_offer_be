package inqooprojectbe.model;

import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO(category.getName(),category.getDescription(), category.getBackground());
        categoryDTO.setCategoryUUID(category.getCategoryUUID());
        return categoryDTO;
    }

    public Category fromDTO(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getName(), categoryDTO.getDescription(), categoryDTO.getBackground());
    }
}