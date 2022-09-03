package inqooprojectbe;

import inqooprojectbe.controllers.CategoryController;
import inqooprojectbe.model.Category;
import inqooprojectbe.model.CategoryDTO;
import inqooprojectbe.repositories.CategoryRepository;
import inqooprojectbe.services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.PATH;

@SpringBootTest
public class CategoryControllerTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryController categoryController;
    @Autowired
    CategoryService categoryService;

    @BeforeEach
    void beforeEach() {
        categoryRepository.save(new Category("IT", "EUEUEUEU", UUID.randomUUID()));
        categoryRepository.save(new Category("UY", "EUEUEUEU",UUID.randomUUID()));
        categoryRepository.save(new Category("AR", "EUEUEUEU",UUID.randomUUID()));
    }

    @Test
    @Transactional
    public void shouldAddCategory() throws Exception {
        //given
        int size = categoryRepository.findAll().size();
        Category category = new Category("baza", "ew",UUID.randomUUID());
        //when
        categoryService.addCategory(category);
        //then
        assertThat(categoryRepository.findAll().size()).isEqualTo(size + 1);
    }

    @Test
    @Transactional
    public void shouldReturnCategories() {
        //given

        //when
        List<CategoryDTO> all = categoryService.getCategories();
        //then
        assertThat(all.size()).isEqualTo(3);
    }
    @Test
    @Transactional
    public void getCategoryUUID(){
        //given

        //when
        List<CategoryDTO> CategoryUUID = categoryService.getCategoryUUID();
        //them
        assertThat(categoryRepository.findByCategoryUUID(UUID.randomUUID()));
    }
}
