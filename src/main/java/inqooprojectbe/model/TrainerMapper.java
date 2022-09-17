package inqooprojectbe.model;

import inqooprojectbe.repositories.TrainerRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class TrainerMapper {
    public TrainerDTO toDTO(Trainer trainer) {
        return new TrainerDTO(trainer.getName(),
                trainer.getSurname(), trainer.getPhoneNumber(), trainer.getBio());
    }

    public Trainer fromDTO(TrainerDTO trainerDTO) {
        return new Trainer(trainerDTO.getName(), trainerDTO.getSurname(), trainerDTO.getPhoneNumber(),
                trainerDTO.getBio()); }
}
