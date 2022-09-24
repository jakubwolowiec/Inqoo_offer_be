package inqooprojectbe.model;

import java.time.LocalDate;
import java.util.UUID;

public class ScheduleDTO {
    private UUID workshopUUID;
    private UUID trainerUUID;
    private LocalDate startDate;


    public ScheduleDTO(UUID workshopUUID, UUID trainerUUID, LocalDate startDate) {
        this.workshopUUID = workshopUUID;
        this.trainerUUID = trainerUUID;
        this.startDate = startDate;
    }

    public ScheduleDTO() {
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
}