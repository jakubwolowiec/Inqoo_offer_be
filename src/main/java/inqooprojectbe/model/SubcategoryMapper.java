package inqooprojectbe.model;

import org.springframework.stereotype.Component;

@Component
public class SubcategoryMapper {

    public SubcategoryDTO toDTO(Subcategory subcategory) {
//        SubcategoryDTO subcategoryDTO = new SubcategoryDTO(subcategory.getName(), subcategory.getDescription());
        return new SubcategoryDTO( subcategory.getName(),subcategory.getDescription(),subcategory.getSubcategoryUUID());
    }

    public Subcategory fromDTO(SubcategoryDTO subcategoryDTO) {
//        Subcategory subcategory = new Subcategory(subcategoryDTO.getName(), subcategoryDTO.getDescription());
        return new Subcategory(subcategoryDTO.getName(),subcategoryDTO.getDescription(),subcategoryDTO.getSubcategoryUUID());
    }
}
