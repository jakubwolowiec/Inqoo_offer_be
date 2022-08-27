package inqooprojectbe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inqooprojectbe.controllers.CategoryController;
import inqooprojectbe.model.Category;
import inqooprojectbe.repositories.CategoryRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class InqooBackEndApplicationTests {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryController categoryController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void beforeEach() {
        categoryRepository.save(new Category("IT", "EUEUEUEU"));
        categoryRepository.save(new Category("UY", "EUEUEUEU"));
        categoryRepository.save(new Category("AR", "EUEUEUEU"));
    }

    @Test
    @Transactional
    void contextLoads() {
        assertThat(categoryController).isNotNull();
    }

    @Test
    @Transactional
    public void shouldReturnCategories() {
        //given

        //when
        List<Category> all = categoryRepository.findAll();
        //then
        assertThat(all.size()).isEqualTo(3);
    }


    @Test
    @Transactional
    public void shouldReturnCategoryDTO() throws Exception {
        //given

        String contentAsString = this.mockMvc.perform(MockMvcRequestBuilders.get("/category"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<Category> categoryList = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });

        //then
        assertThat(categoryList.size()).isEqualTo(3);
    }
}