package inqooprojectbe.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private UUID subcategoryUUID;


    public Subcategory(String name, String description, List<Workshop> workshops) {
        this.name = name;
        this.description = description;
        this.workshops = workshops;
    }

    @OneToMany
    @JoinTable(
            name = "subcategory_workshop",
            joinColumns = @JoinColumn(name = "subcategory_id"),
            inverseJoinColumns = @JoinColumn(name = "workshop_id")
    )
    private List<Workshop> workshops;

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

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}