package inqooprojectbe.model;

import java.math.BigDecimal;

public class WorkshopDTO {
    private String name;
    private BigDecimal price;
    private String description;
    private int time;

    public WorkshopDTO(String name, BigDecimal price, String description, int time){
        this.name = name;
        this.price = price;
        this.description = description;
        this.time = time;
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
}
