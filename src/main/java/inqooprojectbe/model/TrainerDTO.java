package inqooprojectbe.model;

public class TrainerDTO {
    public String name;
    public String surname;
    public String phoneNumber;
    public String bio;

    public TrainerDTO(String name, String surname,String phoneNumber,String bio){
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
    }
}
