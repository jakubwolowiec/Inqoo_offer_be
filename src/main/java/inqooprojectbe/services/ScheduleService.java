package inqooprojectbe.services;

import inqooprojectbe.model.*;
import inqooprojectbe.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ScheduleService {

    private final TrainerService trainerService;
    private final WorkshopService workshopService;
    private final ScheduleMapper scheduleMapper;
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(TrainerService trainerService, WorkshopService workshopService, ScheduleMapper scheduleMapper, ScheduleRepository scheduleRepository) {
        this.trainerService = trainerService;
        this.workshopService = workshopService;
        this.scheduleMapper = scheduleMapper;
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule bookWorkshop(String workshopUUID, String trainerUUID, LocalDate startDate){

        Schedule scheduleToSave = new Schedule(workshopUUID, trainerUUID, startDate);
        scheduleRepository.save(scheduleToSave);
        return scheduleToSave;
    }

    public List<ScheduleDTO> getSchedules(){
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        for (Schedule schedule: schedules
             ) {
        scheduleDTOList.add(scheduleMapper.toDTO(schedule));
        }
        return scheduleDTOList;
    }
}
