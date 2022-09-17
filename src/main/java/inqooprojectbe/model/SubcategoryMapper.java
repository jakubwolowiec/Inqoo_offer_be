package inqooprojectbe.model;

import org.springframework.stereotype.Component;

@Component
public class SubcategoryMapper {

    public SubcategoryDTO toDTO(Subcategory subcategory) {
        return new SubcategoryDTO( subcategory.getName(),subcategory.getDescription(), subcategory.getWorkshops());
    }

    public Subcategory fromDTO(SubcategoryDTO subcategoryDTO) {
        return new Subcategory(subcategoryDTO.getName(),subcategoryDTO.getDescription(), subcategoryDTO.getWorkshops());
    }
}
