package inqooprojectbe.model;

import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getName(),category.getDescription(), category.getBackground());
    }

    public Category fromDTO(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getName(), categoryDTO.getDescription(), categoryDTO.getBackground());
    }
}