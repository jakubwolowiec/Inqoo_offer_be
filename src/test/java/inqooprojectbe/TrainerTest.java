package inqooprojectbe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inqooprojectbe.controllers.TrainerController;
import inqooprojectbe.model.Trainer;
import inqooprojectbe.repositories.TrainerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TrainerTest {
    @Autowired
    TrainerController trainerController;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @BeforeEach
    void beforeEach() {
        trainerRepository.save(new Trainer("Jan", "Krawczyk", "000000000", "Programist lol"));
        trainerRepository.save(new Trainer("Jan", "Krawczyk", "000000000", "Programist lol"));
        trainerRepository.save(new Trainer("Jan", "Krawczyk", "000000000", "Programist lol"));
    }

    @AfterEach
    void afterEach() {
        trainerRepository.deleteAll();
    }

    @Test
    public void shouldGetTrainers() throws Exception {
        //given
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/trainers"))
                                        .andDo(print())
                                        .andReturn()
                                        .getResponse()
                                        .getContentAsString();
        //when
        List<Trainer> trainerList = objectMapper.readValue(contentAsString, new TypeReference<>(){});

        //then
        assertThat(trainerList.size()).isEqualTo(3);
    }

    @Test
    public void shouldAddTrainer() throws Exception {
        //given
        Trainer trainerToAdd = new Trainer("Mark", "Lerry", "34534534", "typicalbio");
        String requestJSON = objectMapper.writeValueAsString(trainerToAdd);
        ResultActions resultActions = mockMvc.perform(post("/trainer/add")
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .content(requestJSON))
                                              .andExpect(status().isCreated());

        //when
        List<Trainer> trainerList = trainerRepository.findAll();

        //then
        assertThat(trainerList.size()).isEqualTo(4);
    }
}
