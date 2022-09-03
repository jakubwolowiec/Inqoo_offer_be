package inqooprojectbe.model;

import java.util.UUID;

public class CategoryDTO {
    public String name;
    public String description;
    public UUID categoryUUID;

    public CategoryDTO(String name, String description, UUID categoryUUID) {
        this.name = name;
        this.description = description;
        this.categoryUUID = categoryUUID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getCategoryUUID() {
        return categoryUUID;
    }
}