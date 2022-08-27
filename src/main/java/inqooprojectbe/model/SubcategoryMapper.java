package inqooprojectbe.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryMapper {

    public SubcategoryDTO toDTO(Subcategory subcategory) {
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO(subcategory.getName(), subcategory.getDescription());
        return subcategoryDTO;
    }

    public Subcategory fromDTO(SubcategoryDTO subcategoryDTO) {
        Subcategory subcategory = new Subcategory(subcategoryDTO.getName(), subcategoryDTO.getDescription());
        return subcategory;
    }
}
