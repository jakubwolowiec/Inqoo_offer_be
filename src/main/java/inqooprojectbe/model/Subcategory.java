package inqooprojectbe.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private String subcategoryUUID;


    public Subcategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @OneToMany
    @JoinTable(
            name = "subcategory_workshop",
            joinColumns = @JoinColumn(name = "subcategory_id"),
            inverseJoinColumns = @JoinColumn(name = "workshop_id")
    )
    private List<Workshop> workshops = new ArrayList<>();

    public Subcategory() {

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Workshop> getWorkshops() {
        return workshops;
    }

    public String getSubcategoryUUID() {
        return subcategoryUUID;
    }

    public void addWorkshop(Workshop workshop){
        this.workshops.add(workshop);
    }

    public void setSubcategoryUUID(String subcategoryUUID) {
        this.subcategoryUUID = subcategoryUUID;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}