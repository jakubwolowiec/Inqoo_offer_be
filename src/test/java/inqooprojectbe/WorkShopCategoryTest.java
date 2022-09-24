package inqooprojectbe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inqooprojectbe.controllers.WorkshopController;
import inqooprojectbe.model.Category;
import inqooprojectbe.model.Subcategory;
import inqooprojectbe.model.Workshop;
import inqooprojectbe.model.WorkshopDTO;
import inqooprojectbe.repositories.WorkshopRepository;
import inqooprojectbe.services.CategoryService;
import inqooprojectbe.services.SubcategoryService;
import inqooprojectbe.services.WorkshopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class WorkShopCategoryTest {
    @Autowired
    WorkshopRepository workshopRepository;
    @Autowired
    WorkshopController workshopController;
    @Autowired
    WorkshopService workshopService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    SubcategoryService subcategoryService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void beforeEach() {
        workshopRepository.save((new Workshop("dd", BigDecimal.valueOf(1), "dd", 1)));
        workshopRepository.save((new Workshop("aa", BigDecimal.valueOf(2), "aa", 2)));
        workshopRepository.save((new Workshop("cc", BigDecimal.valueOf(3), "cc", 3)));
    }

    @Test
    @Transactional
    public void shouldReturnWorkshop() {
        //given

        //when
        List<WorkshopDTO> all = workshopService.getWorkshops();
        //then
        assertThat(all.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void shouldReturnWorkshopDTO() throws Exception {
        //given

        String contentAsString = this.mockMvc.perform(MockMvcRequestBuilders.get("/category/subcategory/workshop")).andDo(print()).andReturn()
                .getResponse().getContentAsString();
        List<Workshop> workshopList = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });

        //then
        assertThat(workshopList.size()).isEqualTo(workshopRepository.findAll().size());
    }

    @Test
    public void shouldAddWorkshopToSubcategoryList(){
    //given
    Category category = new Category("Test Name", "Test Description", "Test Background");
    Subcategory subcategory = new Subcategory("Test subName", "Test subDesc");
    Workshop workshop = new Workshop("Test workshopName",BigDecimal.valueOf(1300L),"Test desc", 140);
    //when
    categoryService.addCategory(category);
    subcategoryService.addSubcategory(subcategory, category.getCategoryUUID());
    workshopService.addWorkshop(workshop, subcategory.getSubcategoryUUID());
    //then
    assertThat(category.getSubcategories().get(0).getWorkshops().size()).isEqualTo(1);
    }
}

