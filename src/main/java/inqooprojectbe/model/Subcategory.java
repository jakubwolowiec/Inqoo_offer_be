package inqooprojectbe.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;

    public Subcategory() {
    }

    public Subcategory(String name, String description, List<Workshop> workshopList) {
        this.name = name;
        this.description = description;
        this.workshopList = workshopList;
    }

    @OneToMany
    private List<Workshop> workshopList;

    public Subcategory(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}