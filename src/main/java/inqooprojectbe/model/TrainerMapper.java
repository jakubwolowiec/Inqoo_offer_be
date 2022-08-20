package inqooprojectbe.model;

import inqooprojectbe.repositories.TrainerRepository;
import org.springframework.stereotype.Component;


@Component
public class TrainerMapper {
    private final TrainerRepository trainerRepository;

    public TrainerMapper(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public TrainerDTO toDTO(Trainer trainer){
        return new TrainerDTO(trainer.getName(),
                trainer.getSurname(), trainer.getPhoneNumber(),trainer.getBio());
    }
    public Trainer fromDTO(TrainerDTO trainerDTO){
        return new Trainer(trainerDTO.name, trainerDTO.surname,trainerDTO.phoneNumber,
                trainerDTO.bio);
    }
}
