package inqooprojectbe.model;

import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
//        CategoryDTO categoryDTO = new CategoryDTO(category.getName(), category.getDescription(), category.getCategoryUUID());
        return new CategoryDTO(category.getName(),category.getDescription(), category.getCategoryUUID());
    }

    public Category fromDTO(CategoryDTO categoryDTO) {
//        Category category = new Category(categoryDTO.name, categoryDTO.description);
        return new Category(categoryDTO.getName(), categoryDTO.getDescription(), categoryDTO.getCategoryUUID());
    }
}