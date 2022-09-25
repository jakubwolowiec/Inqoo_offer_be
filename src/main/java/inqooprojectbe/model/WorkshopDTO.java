package inqooprojectbe.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WorkshopDTO {
    private String name;
    private BigDecimal price;
    private String description;
    private int time;
    private String workshopUUID;
    private Trainer trainer;
    private LocalDate startDate;

    public WorkshopDTO(String name, BigDecimal price, String description, int time,Trainer trainer){
        this.name = name;
        this.price = price;
        this.description = description;
        this.time = time;
        this.trainer = trainer;
        this.startDate = startDate;

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

    public String getWorkshopUUID() {
        return workshopUUID;
    }

    public void setWorkshopUUID(String workshopUUID) {
        this.workshopUUID = workshopUUID;
    }

    public Trainer getTrainerList() {
        return trainer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

}
