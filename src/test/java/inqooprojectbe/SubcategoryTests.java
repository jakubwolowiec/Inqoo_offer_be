package inqooprojectbe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inqooprojectbe.controllers.SubcategoryController;
import inqooprojectbe.model.*;
import inqooprojectbe.repositories.CategoryRepository;
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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class SubcategoryTests {

    @Autowired
    SubcategoryService subcategoryService;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubcategoryRepository subcategoryRepository;
    @Autowired
    SubcategoryController subcategoryController;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @BeforeEach
    void beforeEach() {
        Subcategory saved1 = subcategoryRepository.save(new Subcategory("IT", "EUEUEUEU"));
        Subcategory saved2 = subcategoryRepository.save(new Subcategory("UY", "EUEUEUEU"));
        Subcategory saved3 = subcategoryRepository.save(new Subcategory("AR", "EUEUEUEU"));
        Category category = new Category("name", "desc","");
        category.setCategoryUUID("c139ef3a-4e84-48e6-bc49-8d449f15211e");
        category.addSubcategory(saved1);
        category.addSubcategory(saved2);
        category.addSubcategory(saved3);
        categoryRepository.save(category);

    }

    @Test
    @Transactional
    public void shouldReturnSubcategories() throws Exception {
        //given
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/category/subcategory/all/c139ef3a-4e84-48e6-bc49-8d449f15211e"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        //when
        List<SubcategoryDTO> allSubcategories = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        //then
        assertThat(allSubcategories.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void ShouldAddSubcategory() {
        //given
        Subcategory subcategory = new Subcategory("subcat", "coś tam, coś");
        Category category = new Category("BOB", "BOB Description", "");
        category.setCategoryUUID("c139ef3a-4e84-48e6-bc49-8d449f15211a");
        categoryRepository.save(category);
        //when
        subcategoryService.addSubcategory(subcategory, category.getCategoryUUID());
        //then
        assertThat((categoryRepository.findByCategoryUUID("c139ef3a-4e84-48e6-bc49-8d449f15211a").getSubcategories().size())).isEqualTo(1);
    }


}
