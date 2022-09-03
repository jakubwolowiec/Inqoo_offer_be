package inqooprojectbe.model;

import java.util.UUID;

public class SubcategoryDTO {
    private String name;
    private String description;
    private UUID subcategoryUUID;


    public SubcategoryDTO(String name, String description, UUID subcategoryUUID) {
        this.name = name;
        this.description = description;
        this.subcategoryUUID = this.subcategoryUUID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getSubcategoryUUID() {return subcategoryUUID;}
}