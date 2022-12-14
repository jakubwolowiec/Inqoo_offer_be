package inqooprojectbe.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String bio;
    private String trainerUUID;

    public Trainer() {
    }

    public Trainer(String name, String surname, String phoneNumber, String bio) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
    }

    public Long getId() {
        return id;
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

    public String getTrainerUUID() {
        return trainerUUID;
    }

    public void setTrainerUUID(String trainerUUID) {
        this.trainerUUID = trainerUUID;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bio='" + bio +
                '}';
    }
}
