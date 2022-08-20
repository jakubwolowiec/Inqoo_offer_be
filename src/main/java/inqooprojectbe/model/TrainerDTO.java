package inqooprojectbe.model;

public class TrainerDTO {
    protected String name;
    protected String surname;
    protected String phoneNumber;
    protected String bio;

    public TrainerDTO(String name, String surname, String phoneNumber, String bio) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
    }
}
