package inqooprojectbe.model;

import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {
    public ScheduleDTO toDTO(Schedule schedule){
        ScheduleDTO scheduleDTO = new ScheduleDTO(schedule.getWorkshopUUID(), schedule.getTrainerUUID(), schedule.getStartDate());
        return scheduleDTO;
    }

    public Schedule fromDTO(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule( scheduleDTO.getWorkshopUUID(), scheduleDTO.getTrainerUUID(), scheduleDTO.getStartDate());
        return schedule;
    }
}