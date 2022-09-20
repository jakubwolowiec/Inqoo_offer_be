package inqooprojectbe.model;

import java.util.UUID;

public class CategoryDTO {
    private String name;
    private String description;
    private String categoryUUID;

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

    public String getCategoryUUID() {
        return categoryUUID;
    }

    public void setCategoryUUID(String categoryUUID) {
        this.categoryUUID = categoryUUID;
    }

    public String getBackground() {

        return background;
    }
}