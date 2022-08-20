package inqooprojectbe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inqooprojectbe.controllers.CategoryController;
import inqooprojectbe.model.Category;
import inqooprojectbe.repositories.CategoryRepository;
import inqooprojectbe.services.CategoryService;
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
    CategoryService categoryService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @Transactional
    void contextLoads() {
        assertThat(categoryController).isNotNull();
    }

    @Test
    @Transactional
    public void shouldReturnCategoryDTO() throws Exception {
        //given
        String contentAsString = this.mockMvc.perform(MockMvcRequestBuilders.get("/categories")).andDo(print()).andReturn()
                .getResponse().getContentAsString();
        List<Category> categoryList = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
        //when

        //then
        assertThat(categoryList.size()).isEqualTo(categoryRepository.findAll().size());
    }
}