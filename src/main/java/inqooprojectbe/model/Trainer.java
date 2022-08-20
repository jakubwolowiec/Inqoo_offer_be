package inqooprojectbe.model;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany
    private List<Workshop> workshopList;

    public Trainer(Long id, String name, String surname, String phoneNumber, String bio, List<Workshop> workshopList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.workshopList = workshopList;
    }

    public Trainer(String name, String surname, String phoneNumber, String bio) {
    }

    public Trainer() {

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

    public List<Workshop> getWorkshopList() {
        return workshopList;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bio='" + bio + '\'' +
                ", workshopList=" + workshopList +
                '}';
    }
}
