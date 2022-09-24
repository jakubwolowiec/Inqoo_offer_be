package inqooprojectbe.services;

import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.TrainerDTO;
import inqooprojectbe.model.TrainerMapper;
import inqooprojectbe.repositories.TrainerRepository;
import inqooprojectbe.repositories.WorkshopRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;
    private final WorkshopRepository workshopRepository;

    public TrainerService(TrainerRepository trainerRepository, TrainerMapper trainerMapper, WorkshopService workshopService, WorkshopRepository workshopRepository) {
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
        this.workshopRepository = workshopRepository;
    }

    public Trainer addTrainer(Trainer trainer) {
        trainer.setTrainerUUID(UUID.randomUUID().toString());
        return trainerRepository.save(trainer);
    }

    public TrainerDTO getTrainer(String workshopUUID) {
        TrainerDTO trainerDTOList = trainerMapper.toDTO(workshopRepository.findByWorkshopUUID(workshopUUID).getTrainer());

        return trainerDTOList;
    }

    public Trainer getTrainerByUUID(String trainerUUID){
        return trainerRepository.findByTrainerUUID(trainerUUID).orElse(null);
    }
}
