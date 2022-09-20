package inqooprojectbe.model;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SubcategoryMapper {

    public SubcategoryDTO toDTO(Subcategory subcategory) {
         SubcategoryDTO subcategoryDto = new SubcategoryDTO( subcategory.getName(),subcategory.getDescription(), subcategory.getWorkshops());
                subcategoryDto.setSubcategoryDTO_UUID(subcategory.getSubcategoryUUID());
                return subcategoryDto;
    }

    public Subcategory fromDTO(SubcategoryDTO subcategoryDTO) {
       Subcategory subcategoryFromDTO = new Subcategory(subcategoryDTO.getName(),subcategoryDTO.getDescription(), subcategoryDTO.getWorkshops());
        subcategoryFromDTO.setSubcategoryUUID(subcategoryDTO.getSubcategoryDTO_UUID());
        return subcategoryFromDTO;
    }
}
