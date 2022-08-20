package inqooprojectbe.model;

public class TrainerMapper {
    public TrainerDTO toDTO(Trainer trainer){
        return new TrainerDTO(trainer.getName(),
                trainer.getSurname(), trainer.getPhoneNumber(),trainer.getBio());
    }
    public Trainer fromDTO(TrainerDTO trainerDTO){
        return new Trainer( trainerDTO.name, trainerDTO.surname,trainerDTO.phoneNumber,
                trainerDTO.bio);
    }
}
