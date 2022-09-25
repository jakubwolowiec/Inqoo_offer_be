package inqooprojectbe.services;

import inqooprojectbe.model.*;
import inqooprojectbe.repositories.TrainerRepository;
import inqooprojectbe.repositories.WorkshopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;
    private final WorkshopRepository workshopRepository;
    private final ScheduleMapper scheduleMapper;

    public TrainerService(TrainerRepository trainerRepository, TrainerMapper trainerMapper, WorkshopService workshopService, WorkshopRepository workshopRepository, ScheduleMapper scheduleMapper) {
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
        this.workshopRepository = workshopRepository;
        this.scheduleMapper = scheduleMapper;
    }

    public Trainer addTrainer(Trainer trainer, String workshopUUID) {
        trainer.setTrainerUUID(UUID.randomUUID().toString());
        Trainer saved = trainerRepository.save(trainer);
        workshopRepository.findByWorkshopUUID(workshopUUID).addTrainerToWorkshop(saved);
        System.out.println(workshopRepository.findAll());
        return saved;
    }

    public TrainerDTO getTrainer(String workshopUUID) {
        TrainerDTO trainerDTOList = trainerMapper.toDTO(workshopRepository.findByWorkshopUUID(workshopUUID).getTrainer());

        return trainerDTOList;
    }

    public void addScheduleToTrainer(Schedule schedule){
        Trainer trainer = trainerRepository.findByTrainerUUID(schedule.getTrainerUUID());
        trainer.setSchedule(schedule);

    }

    public Trainer getTrainerByUUID(String trainerUUID){
        return trainerRepository.findByTrainerUUID(trainerUUID);
    }
}
