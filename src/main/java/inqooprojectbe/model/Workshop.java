package inqooprojectbe.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    private String  workshopUUID;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "workshop_trainers",
            joinColumns = @JoinColumn(name = "workshop_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id")
    )
    private Trainer trainer;

    public Workshop(String name, BigDecimal price, String description, int time) {
        this.name =name;
        this.price = price;
        this.description =description;
        this.workshopTime =time;
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

    public void setWorkshopUUID(String workshopUUID) {
        this.workshopUUID = workshopUUID;
    }

    public String getWorkshopUUID() {
        return workshopUUID;
    }

    public void setWorkshopTime(int workshopTime) {
        workshopTime = workshopTime;
    }

    public void addTrainerToWorkshop(Trainer trainer){
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
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