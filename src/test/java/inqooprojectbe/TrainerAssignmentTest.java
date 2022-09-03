package inqooprojectbe;

import com.fasterxml.jackson.databind.ObjectMapper;
import inqooprojectbe.controllers.TrainerController;
import inqooprojectbe.controllers.WorkshopController;
import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.Workshop;
import inqooprojectbe.repositories.TrainerRepository;
import inqooprojectbe.repositories.WorkshopRepository;
import inqooprojectbe.services.WorkshopService;
import org.junit.jupiter.api.AfterEach;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class TrainerAssignmentTest {
    @Autowired
    WorkshopController workshopController;
    @Autowired
    WorkshopRepository workshopRepository;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    TrainerController trainerController;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    WorkshopService workshopService;

    @BeforeEach
    void beforeEach() {
        workshopRepository.save((new Workshop("dd", BigDecimal.valueOf(1), "dd", 1, UUID.randomUUID())));
        workshopRepository.save((new Workshop("aa", BigDecimal.valueOf(2), "aa", 2, UUID.randomUUID())));
        workshopRepository.save((new Workshop("cc", BigDecimal.valueOf(3), "cc", 3, UUID.randomUUID())));
        trainerRepository.save(new Trainer("Jan", "Krawczyk", "000000000", "Programist lol", UUID.randomUUID()));
        trainerRepository.save(new Trainer("Stan", "Krawczyk", "000000000", "Programist lol", UUID.randomUUID()));
        trainerRepository.save(new Trainer("Gel", "Krawczyk", "000000000", "Programist lol", UUID.randomUUID()));
    }

    @AfterEach
    void afterEach() {
        workshopRepository.deleteAll();
        trainerRepository.deleteAll();
    }

    @Test
    public void shouldAddTrainerToWorkshop() throws Exception{
        // given
        UUID trainerUUID = aTrainerWithUUID();
        // and
        UUID workshopUUID = aWorkshopWithUUID();

        // when
        workshopService.addTrainerToWorkshop(workshopUUID, trainerUUID);

        // then
        assertThat(workshopContainsTrainer(workshopUUID, trainerUUID))
                .isTrue();
    }

    private UUID aWorkshopWithUUID() {
        UUID workshopUUID = UUID.randomUUID();
        Workshop workshopToAdd = new Workshop("dd", BigDecimal.valueOf(1), "dd", 1, workshopUUID);
        workshopRepository.save(workshopToAdd);
        return workshopUUID;
    }

    private UUID aTrainerWithUUID() {
        UUID trainerUUID = UUID.randomUUID();
        Trainer trainerToAdd = new Trainer("Mark", "Lerry", "34534534", "typicalbio", trainerUUID);
        trainerRepository.save(trainerToAdd);
        return trainerUUID;
    }

    private boolean workshopContainsTrainer(UUID workshopUUID, UUID trainerUUID) {
        return workshopRepository.findByWorkshopUUID(workshopUUID)
                .getTrainers()
                .stream()
                .anyMatch(trainer -> trainer.getTrainerUUID().equals(trainerUUID));
    }

}
