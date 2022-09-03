package inqooprojectbe.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int workshopTime;
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID workshopUUID;
    private LocalDate startDate;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "workshop_trainers",
            joinColumns = @JoinColumn(name = "workshop_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id")
    )
    private Set<Trainer> trainers = new HashSet<>();

    public Workshop(String name, BigDecimal price, String description, int time, UUID workshopUUID, LocalDate startDate) {
        this.name =name;
        this.price = price;
        this.description =description;
        this.workshopTime =time;
        this.workshopUUID = workshopUUID;
        this.startDate = startDate;
    }

    public Workshop() {

    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getWorkshopTime() {
        return workshopTime;
    }

    public UUID getWorkshopUUID() {
        return workshopUUID;
    }

    public void setWorkshopTime(int workshopTime) {
        workshopTime = workshopTime;
    }

    public void addTrainerToWorkshop(Trainer trainer){
        this.trainers.add(trainer);
    }

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public LocalDate getStartDate() {
        return startDate;
    }


    @Override
    public String toString() {
        return "Workshop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", time=" + workshopTime +
                '}';
    }
}