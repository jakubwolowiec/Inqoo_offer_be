package inqooprojectbe.model;

public class SubcategoryDTO {
    private String name;
    private String description;

    public SubcategoryDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}