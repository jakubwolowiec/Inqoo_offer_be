package inqooprojectbe;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import inqooprojectbe.controllers.TrainerController;
import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.TrainerDTO;
import inqooprojectbe.model.TrainerMapper;
import inqooprojectbe.model.Workshop;
import inqooprojectbe.repositories.TrainerRepository;
import inqooprojectbe.services.TrainerService;
import org.aspectj.lang.annotation.After;
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

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TrainerTest {
    @Autowired
    TrainerService trainerService;
    @Autowired
    TrainerController trainerController;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    TrainerMapper trainerMapper;


    @BeforeEach
   void beforeEach(){
        trainerRepository.save(new Trainer(1l, "Jan", "Krawczyk", "000000000", "Programist lol", new ArrayList<>()));
        trainerRepository.save(new Trainer(2l, "Jan", "Krawczyk", "000000000", "Programist lol", new ArrayList<>()));
        trainerRepository.save(new Trainer(3l, "Jan", "Krawczyk", "000000000", "Programist lol", new ArrayList<>()));
    }

    @AfterEach
    void afterEach(){trainerRepository.deleteAll();}


    @Test
    public void shouldGetTrainers() throws Exception {
    //given
        String contentAsString = this.mockMvc.perform(MockMvcRequestBuilders.get("/trainers")).andDo(print()).andReturn()
                .getResponse().getContentAsString();
    //when
        List<Trainer> trainerList = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });
    //then
    assertThat(trainerList.size()).isEqualTo(3);
    }

    @Test
    public void shouldAddTrainer() throws Exception {
    //given
        Trainer trainerToAdd = new Trainer("Mark", "Lerry", "34534534", "typicalbio");
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJSON= objectWriter.writeValueAsString(trainerToAdd);
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/add-trainer").contentType(MediaType.APPLICATION_JSON)
                .content(requestJSON))
                .andExpect(status().isOk());
        //when
        List<Trainer> trainerList = trainerRepository.findAll();
    //then
        assertThat(trainerList.size()).isEqualTo(4);
    }

    @Test
    public void shouldReturnTrainerDTO(){
    //given
    Trainer trainer1 = new Trainer("Marej", "Bobby", "334234234","lol");
    //when
     TrainerDTO trainerDTO = trainerMapper.toDTO(trainer1);
    //then
        assertThat(trainerDTO.name).isEqualTo(trainer1.getName());
    }
    @Test
    public void shouldReturnTrainerFromDTO(){
    //given
    TrainerDTO trainerDTO = new TrainerDTO("Marej", "Bobby", "334234234","lol");
    //when
     Trainer trainer = trainerMapper.fromDTO(trainerDTO);
    //then
        assertThat(trainer.getName()).isEqualTo(trainerDTO.name);
    }
}
