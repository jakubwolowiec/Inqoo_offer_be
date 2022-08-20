package inqooprojectbe.model;

import java.math.BigDecimal;

public class WorkshopDTO {
    public String name;
    public BigDecimal price;
    public String description;
    public int time;

    public WorkshopDTO(String name, BigDecimal price, String description, int time){
        this.name = name;
        this.price = price;
        this.description = description;
        this.time = time;
    }
}
