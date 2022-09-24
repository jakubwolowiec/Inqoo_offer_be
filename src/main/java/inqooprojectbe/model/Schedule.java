package inqooprojectbe.model;

import org.apache.logging.log4j.message.StringFormattedMessage;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String workshopUUID;
    private String trainerUUID;
    private LocalDate startDate;



    public Schedule(String workshopUUID, String trainerUUID, LocalDate startDate) {
        this.workshopUUID = workshopUUID;
        this.trainerUUID = trainerUUID;
        this.startDate = startDate;
    }

    public Schedule() {
    }

    public String getWorkshopUUID() {
        return workshopUUID;
    }

    public String getTrainerUUID() {
        return trainerUUID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Long getId() {
        return id;
    }
}
