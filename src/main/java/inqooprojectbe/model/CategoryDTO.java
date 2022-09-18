package inqooprojectbe.model;

import java.util.UUID;

public class CategoryDTO {
    private String name;
    private String description;
    private UUID categoryUUID;

    private String background;

    public CategoryDTO(String name, String description, String background) {
        this.name = name;
        this.description = description;
        this.background = background;
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

    public void setCategoryUUID(UUID categoryUUID) {
        this.categoryUUID = categoryUUID;
    }

    public String getBackground() {

        return background;
    }
}