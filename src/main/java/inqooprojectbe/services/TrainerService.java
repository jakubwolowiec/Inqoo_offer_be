package inqooprojectbe.services;

import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.TrainerDTO;
import inqooprojectbe.model.TrainerMapper;
import inqooprojectbe.repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    private final TrainerMapper trainerMapper;

    public TrainerService(TrainerRepository trainerRepository, TrainerMapper trainerMapper){
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
    }

    public Trainer addTrainer(Trainer trainer){return trainerRepository.save(trainer);}

    public List<TrainerDTO> getTrainers(){
        List<TrainerDTO> trainerDTOList = new ArrayList<>();
        for (Trainer trainer: trainerRepository.findAll()
             ) {
         trainerDTOList.add(trainerMapper.toDTO(trainer));
        }
        return trainerDTOList;}

}
