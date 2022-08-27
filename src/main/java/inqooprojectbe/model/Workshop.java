package inqooprojectbe.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    private Set<Trainer> trainers;

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

    public void setWorkshopTime(int workshopTime) {
        workshopTime = workshopTime;
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