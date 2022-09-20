package inqooprojectbe.model;

import java.util.List;

public class SubcategoryDTO {
    private String name;
    private String description;

    private List<Workshop> workshops;
    private String subcategoryDTO_UUID;

    public SubcategoryDTO(String name, String description, List<Workshop> workshops) {
        this.name = name;
        this.description = description;
        this.workshops = workshops;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Workshop> getWorkshops() {
        return workshops;
    }

    public String getSubcategoryDTO_UUID() {
        return subcategoryDTO_UUID;
    }

    public void setSubcategoryDTO_UUID(String subcategoryDTO_UUID) {
        this.subcategoryDTO_UUID = subcategoryDTO_UUID;
    }
}