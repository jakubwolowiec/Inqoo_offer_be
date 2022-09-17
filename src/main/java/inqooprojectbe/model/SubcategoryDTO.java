package inqooprojectbe.model;

import org.hibernate.jdbc.Work;

import java.util.List;
import java.util.UUID;

public class SubcategoryDTO {
    private String name;
    private String description;

    private List<Workshop> workshops;

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
}