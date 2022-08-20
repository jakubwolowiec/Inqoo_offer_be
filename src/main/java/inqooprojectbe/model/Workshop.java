package inqooprojectbe.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Workshop {
    public Workshop(Long id, String name, String description, BigDecimal price, int workshopTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.workshopTime = workshopTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int workshopTime;

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

    public void setName(String name) {
        this.name = name;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Workshop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", time=" + workshopTime +
                '}';
    }
}