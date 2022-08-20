package inqooprojectbe.services;

import inqooprojectbe.model.Trainer;
import inqooprojectbe.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public Trainer addTrainer(Trainer trainer){return trainerRepository.save(trainer);}

    public List<Trainer> getTrainers(){return trainerRepository.findAll();}

}
