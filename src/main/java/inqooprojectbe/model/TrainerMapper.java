package inqooprojectbe.model;

import inqooprojectbe.repositories.TrainerRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class TrainerMapper {
    public TrainerDTO toDTO(Trainer trainer) {
         TrainerDTO trainerDTO = new TrainerDTO(trainer.getName(),
                trainer.getSurname(), trainer.getPhoneNumber(), trainer.getBio());
         trainerDTO.setTrainerUUID(trainer.getTrainerUUID());
         return trainerDTO;
    }

    public Trainer fromDTO(TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer(trainerDTO.getName(), trainerDTO.getSurname(), trainerDTO.getPhoneNumber(),
                trainerDTO.getBio());
        trainer.setTrainerUUID(trainerDTO.getTrainerUUID());
        return trainer;}
}
