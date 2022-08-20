package inqooprojectbe.model;

import org.springframework.beans.factory.annotation.Autowired;

public class SubcategoryMapper {


    public SubcategoryMapper() {
    }

    public SubcategoryDTO toDTO(Subcategory subcategory) {
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO(subcategory.getName(), subcategory.getDescription());
        return subcategoryDTO;
    }

    public Subcategory fromDTO(SubcategoryDTO subcategoryDTO) {
        Subcategory subcategory = new Subcategory(subcategoryDTO.name, subcategoryDTO.description);
        return subcategory;
    }
}
