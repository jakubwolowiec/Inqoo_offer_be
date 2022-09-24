package inqooprojectbe.model;

import java.util.UUID;

public class TrainerAssignment {
    private String workshopUUID;
    private String trainerUUID;

    public TrainerAssignment() {
    }

    public TrainerAssignment(String workshopUUID, String trainerUUID) {
        this.workshopUUID = workshopUUID;
        this.trainerUUID = trainerUUID;
    }

    public String getWorkshopUUID() {
        return this.workshopUUID;
    }

    public String  getTrainerUUID() {
        return this.trainerUUID;
    }
}
