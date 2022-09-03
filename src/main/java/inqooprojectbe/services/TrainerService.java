package inqooprojectbe.services;

import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.TrainerDTO;
import inqooprojectbe.model.TrainerMapper;
import inqooprojectbe.repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;
    private final WorkshopService workshopService;
    public TrainerService(TrainerRepository trainerRepository, TrainerMapper trainerMapper, WorkshopService workshopService) {
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
        this.workshopService = workshopService;
    }

    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public List<TrainerDTO> getTrainers() {
        List<TrainerDTO> trainerDTOList = new ArrayList<>();
        for (Trainer trainer : trainerRepository.findAll()) {
            trainerDTOList.add(trainerMapper.toDTO(trainer));
        }
        return trainerDTOList;
    }

    public Trainer getTrainerByUUID(UUID trainerUUID){
        List<Trainer> all = trainerRepository.findAll();
        return all.stream().filter(trainer -> trainer.getTrainerUUID().equals(trainerUUID)).findFirst().orElse(null);
    }
}
