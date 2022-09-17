package inqooprojectbe.model;

import java.util.UUID;

public class TrainerDTO {
    private String name;
    private String surname;
    private String phoneNumber;
    private String bio;
    private UUID trainerUUID;

    public TrainerDTO(String name, String surname, String phoneNumber, String bio, UUID trainerUUID) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.trainerUUID = trainerUUID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public UUID getTrainerUUID() {
        return trainerUUID;
    }
}
