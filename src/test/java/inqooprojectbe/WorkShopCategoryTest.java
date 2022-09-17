package inqooprojectbe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inqooprojectbe.controllers.WorkshopController;
import inqooprojectbe.model.Workshop;
import inqooprojectbe.model.WorkshopDTO;
import inqooprojectbe.repositories.WorkshopRepository;
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
import java.util.UUID;

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
}

