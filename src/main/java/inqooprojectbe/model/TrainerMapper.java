package inqooprojectbe.model;

import inqooprojectbe.repositories.TrainerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainerMapper {
    TrainerRepository trainerRepository;
    public TrainerDTO toDTO(Trainer trainer){
        return new TrainerDTO(trainer.getName(),
                trainer.getSurname(), trainer.getPhoneNumber(),trainer.getBio());
    }
    public Trainer fromDTO(TrainerDTO trainerDTO){
        return new Trainer(0l ,trainerDTO.name, trainerDTO.surname,trainerDTO.phoneNumber,
                trainerDTO.bio, new ArrayList<>());
    }
}
