package inqooprojectbe;

import com.fasterxml.jackson.databind.ObjectMapper;
import inqooprojectbe.controllers.SubcategoryController;
import inqooprojectbe.model.Subcategory;
import inqooprojectbe.model.SubcategoryDTO;
import inqooprojectbe.model.SubcategoryMapper;
import inqooprojectbe.repositories.SubcategoryRepository;
import inqooprojectbe.services.SubcategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class SubcategoryTests {

    @Autowired
    SubcategoryService subcategoryService;
    @Autowired
    SubcategoryRepository subcategoryRepository;
    @Autowired
    SubcategoryController subcategoryController;

    SubcategoryMapper subcategoryMapper = new SubcategoryMapper();
    @BeforeEach
    void beforeEach() {
        subcategoryRepository.save(new Subcategory("IT", "EUEUEUEU"));
        subcategoryRepository.save(new Subcategory("UY", "EUEUEUEU"));
        subcategoryRepository.save(new Subcategory("AR", "EUEUEUEU"));
    }

    @Test
    @Transactional
    public void shouldReturnSubcategories() {
        //given

        //when
        List<Subcategory> allSubcategories = subcategoryService.getSubcategories();
        //then
        assertThat(allSubcategories.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void ShouldAddSubcategory(){
        //given
        Subcategory subcategory = new Subcategory("subcat","coś tam, coś");
        //when
        subcategoryService.addSubcategory(subcategory);
        //then
        assertThat(subcategoryRepository.findAll().size()).isEqualTo(4);
    }

    @Test
    @Transactional
    public void shouldTurnSubcategoryToDTO(){
    //given
    Subcategory subcategory = new Subcategory("pop","pop2");
    //when
        SubcategoryDTO subcategoryDTO = subcategoryMapper.toDTO(subcategory);
    //then
        assertThat(subcategoryDTO.name).isEqualTo(subcategory.getName());
        assertThat(subcategoryDTO.description).isEqualTo(subcategory.getDescription());
    }

    @Test
    @Transactional
    public void shouldTurnSubcategoryDTOToSubcategory(){
    //given
    SubcategoryDTO subcategoryDTO = new SubcategoryDTO("bob", "Sok");
    //when
    Subcategory subcategory = subcategoryMapper.fromDTO(subcategoryDTO);
    //then
        assertThat(subcategoryDTO.name).isEqualTo(subcategory.getName());
        assertThat(subcategoryDTO.description).isEqualTo(subcategory.getDescription());
    }
}
