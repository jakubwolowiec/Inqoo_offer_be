package inqooprojectbe.model;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public class WorkshopDTO {
    private String name;
    private BigDecimal price;
    private String description;
    private int time;
    private UUID workshopUUID;
    private Set<Trainer> trainerList;

    public WorkshopDTO(String name, BigDecimal price, String description, int time, Set<Trainer> trainerList){
        this.name = name;
        this.price = price;
        this.description = description;
        this.time = time;
        this.trainerList = trainerList;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getTime() {
        return time;
    }

    public UUID getWorkshopUUID() {
        return workshopUUID;
    }

    public Set<Trainer> getTrainerList() {
        return trainerList;
    }
}
