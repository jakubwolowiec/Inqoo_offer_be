package inqooprojectbe.model;

import java.util.Set;

public class CategoryDTO {
    public String name;
    public String description;
    public Set<SubcategoryDTO> subcategories;

    public CategoryDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Set<SubcategoryDTO> getSubcategories() {
        return subcategories;
    }


}