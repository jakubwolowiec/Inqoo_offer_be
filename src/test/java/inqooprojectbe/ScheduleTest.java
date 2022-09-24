package inqooprojectbe;

import inqooprojectbe.model.*;
import inqooprojectbe.repositories.WorkshopRepository;
import inqooprojectbe.services.ScheduleService;
import inqooprojectbe.services.TrainerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest

public class ScheduleTest {
    @Autowired
     ScheduleService scheduleService;
    @Autowired
    TrainerService trainerService;
    @Autowired
    WorkshopRepository workshopRepository;

    @Test
    @Transactional
    public void shouldGenerateSchedule(){
    //given
        Trainer trainer1 = new Trainer("Bob", "Smith", "324123453", "miszcz kotu");
        trainerService.addTrainer(trainer1);
        Workshop workshop1 = new Workshop("Java", new BigDecimal(3000), "Java essentials", 1);
        workshop1.setWorkshopUUID(UUID.randomUUID().toString());
        workshopRepository.save(workshop1);
        LocalDate startDate = LocalDate.of(2001, Month.APRIL, 1);
    //when
    ScheduleDTO newSchedule = scheduleService.bookWorkshop(workshop1.getWorkshopUUID(), trainer1.getTrainerUUID(), startDate);
    //then
        assertThat(newSchedule.getStartDate()
                .equals(startDate) &&
                newSchedule.getTrainerUUID().equals(trainer1.getTrainerUUID()) &&
                newSchedule.getWorkshopUUID().equals(workshop1.getWorkshopUUID())).isTrue();
    }
}
