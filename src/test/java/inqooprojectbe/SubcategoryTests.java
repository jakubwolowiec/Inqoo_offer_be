package inqooprojectbe;

import com.fasterxml.jackson.core.type.TypeReference;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    SubcategoryMapper subcategoryMapper = new SubcategoryMapper();
    @BeforeEach
    void beforeEach() {
        subcategoryRepository.save(new Subcategory("IT", "EUEUEUEU", UUID.randomUUID()));
        subcategoryRepository.save(new Subcategory("UY", "EUEUEUEU",UUID.randomUUID()));
        subcategoryRepository.save(new Subcategory("AR", "EUEUEUEU",UUID.randomUUID()));
    }

    @Test
    @Transactional
    public void shouldReturnSubcategories() throws Exception {
        //given
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/category/subcategory"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        //when
        List<SubcategoryDTO> allSubcategories = objectMapper.readValue(contentAsString, new TypeReference<>(){});
        //then
        assertThat(allSubcategories.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void ShouldAddSubcategory(){
        //given
        Subcategory subcategory = new Subcategory("subcat","coś tam, coś",UUID.randomUUID());
        //when
        subcategoryService.addSubcategory(subcategory);
        //then
        assertThat(subcategoryRepository.findAll().size()).isEqualTo(4);
    }


}
