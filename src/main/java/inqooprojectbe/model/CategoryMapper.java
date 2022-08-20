package inqooprojectbe.model;

public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO(category.getName(), category.getDescription());
        return categoryDTO;
    }

    public Category fromDTO(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.name, categoryDTO.description);
        return category;
    }
}