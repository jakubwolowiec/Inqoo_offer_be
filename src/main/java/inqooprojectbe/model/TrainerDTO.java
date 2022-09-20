package inqooprojectbe.model;

import java.util.UUID;

public class TrainerDTO {
    private String name;
    private String surname;
    private String phoneNumber;
    private String bio;
    private String trainerUUID;

    public TrainerDTO(String name, String surname, String phoneNumber, String bio) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
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

    public void setTrainerUUID(String trainerUUID) {
        this.trainerUUID = trainerUUID;
    }

    public String getTrainerUUID() {
        return trainerUUID;
    }
}
