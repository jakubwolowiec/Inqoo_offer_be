package inqooprojectbe.model;

import java.time.LocalDate;
import java.util.UUID;

public class ScheduleDTO {
    private String workshopUUID;
    private String trainerUUID;
    private LocalDate startDate;


    public ScheduleDTO(String workshopUUID, String trainerUUID, LocalDate startDate) {
        this.workshopUUID = workshopUUID;
        this.trainerUUID = trainerUUID;
        this.startDate = startDate;
    }

    public ScheduleDTO() {
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
}