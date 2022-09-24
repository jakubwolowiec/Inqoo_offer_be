package inqooprojectbe;

import com.fasterxml.jackson.databind.ObjectMapper;
import inqooprojectbe.controllers.TrainerController;
import inqooprojectbe.controllers.WorkshopController;
import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.TrainerAssignment;
import inqooprojectbe.model.Workshop;
import inqooprojectbe.repositories.TrainerRepository;
import inqooprojectbe.repositories.WorkshopRepository;
import inqooprojectbe.services.WorkshopService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class TrainerAssignmentTest {
    @Autowired
    WorkshopController workshopController;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    WorkshopRepository workshopRepository;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    TrainerController trainerController;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    WorkshopService workshopService;

    @BeforeEach
    void beforeEach() {
        workshopRepository.save((new Workshop("dd", BigDecimal.valueOf(1), "dd", 1)));
        workshopRepository.save((new Workshop("aa", BigDecimal.valueOf(2), "aa", 2)));
        workshopRepository.save((new Workshop("cc", BigDecimal.valueOf(3), "cc", 3)));
        trainerRepository.save(new Trainer("Jan", "Krawczyk", "000000000", "Programist lol"));
        trainerRepository.save(new Trainer("Stan", "Krawczyk", "000000000", "Programist lol"));
        trainerRepository.save(new Trainer("Gel", "Krawczyk", "000000000", "Programist lol"));
    }

    @AfterEach
    void afterEach() {
        workshopRepository.deleteAll();
        trainerRepository.deleteAll();
    }

    @Test
    public void shouldAddTrainerToWorkshop() throws Exception {
        // given
        String trainerUUID = aTrainerWithUUID();
        // and
        String workshopUUID = aWorkshopWithUUID();
        // and
        TrainerAssignment trainerAssignmentToAdd = new TrainerAssignment(workshopUUID, trainerUUID);
        //and
        String requestJSON = objectMapper.writeValueAsString(trainerAssignmentToAdd);
        // when
        mockMvc.perform(post("/category/subcategory/trainerAssignment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isOk());

        // then
        assertThat(workshopContainsTrainer(workshopUUID, trainerUUID))
                .isTrue();
    }

    private String aWorkshopWithUUID() {
        String workshopUUID = UUID.randomUUID().toString();
        Workshop workshopToAdd = new Workshop("dd", BigDecimal.valueOf(1), "dd", 1);
        workshopToAdd.setWorkshopUUID(workshopUUID);
        workshopRepository.save(workshopToAdd);
        return workshopUUID;
    }

    private String aTrainerWithUUID() {
        String trainerUUID = UUID.randomUUID().toString();
        Trainer trainerToAdd = new Trainer("Mark", "Lerry", "34534534", "typicalbio");
        trainerToAdd.setTrainerUUID(trainerUUID);
        trainerRepository.save(trainerToAdd);
        return trainerUUID;
    }

    private boolean workshopContainsTrainer(String workshopUUID, String trainerUUID) {
        return workshopRepository.findByWorkshopUUID(workshopUUID)
                .getTrainer().getTrainerUUID().equals(trainerUUID);
    }

}
