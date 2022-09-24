package inqooprojectbe;

import inqooprojectbe.model.ScheduleDTO;
import inqooprojectbe.model.TrainerDTO;
import inqooprojectbe.model.WorkshopDTO;
import inqooprojectbe.services.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest

public class ScheduleTest {

    ScheduleService scheduleService;

    @Test
    @Transactional
    public void shouldGenerateSchedule(){
    //given
        TrainerDTO trainerDTO1 = new TrainerDTO("Bob", "Smith", "324123453", "miszcz kotu");
        WorkshopDTO workshopDTO1 = new WorkshopDTO("Java", new BigDecimal(3000), "Java essentials", 1, UUID.randomUUID(), new HashSet<>());
        LocalDate startDate = LocalDate.of(2001, Month.APRIL, 1);
    //when
    ScheduleDTO newSchedule = scheduleService.bookWorkshop(workshopDTO1.getWorkshopUUID(), trainerDTO1.getTrainerUUID(), startDate);
    //then
        assertThat(newSchedule.getStartDate()
                .equals(startDate) &&
                newSchedule.getTrainerUUID().equals(trainerDTO1.getTrainerUUID()) &&
                newSchedule.getWorkshopUUID().equals(workshopDTO1.getWorkshopUUID())).isTrue();
    }
}
