package inqooprojectbe.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private UUID workshopUUID;
    private UUID trainerUUID;
    private LocalDate startDate;



    public Schedule(UUID workshopUUID, UUID trainerUUID, LocalDate startDate) {
        this.workshopUUID = workshopUUID;
        this.trainerUUID = trainerUUID;
        this.startDate = startDate;
    }

    public Schedule() {
    }

    public UUID getWorkshopUUID() {
        return workshopUUID;
    }

    public UUID getTrainerUUID() {
        return trainerUUID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Long getId() {
        return id;
    }
}
