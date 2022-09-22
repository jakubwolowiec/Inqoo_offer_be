package inqooprojectbe.model;

import org.springframework.stereotype.Component;

@Component
public class SubcategoryMapper {

    public SubcategoryDTO toDTO(Subcategory subcategory) {
         SubcategoryDTO subcategoryDto = new SubcategoryDTO( subcategory.getName(),subcategory.getDescription(), subcategory.getWorkshops());
                subcategoryDto.setSubcategoryDTO_UUID(subcategory.getSubcategoryUUID());
                return subcategoryDto;
    }

    public Subcategory fromDTO(SubcategoryDTO subcategoryDTO) {
       Subcategory subcategoryFromDTO = new Subcategory(subcategoryDTO.getName(),subcategoryDTO.getDescription());
        subcategoryFromDTO.setSubcategoryUUID(subcategoryDTO.getSubcategoryDTO_UUID());
        return subcategoryFromDTO;
    }
}
