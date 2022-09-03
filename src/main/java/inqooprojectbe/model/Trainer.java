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
    private UUID trainerUUID;
    public Trainer() {
    }

    public Trainer(String name, String surname, String phoneNumber, String bio, UUID trainerUUID) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.trainerUUID = trainerUUID;
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

    public UUID getTrainerUUID() {
        return trainerUUID;
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
