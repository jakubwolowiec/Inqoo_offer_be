package inqooprojectbe.model;

import java.util.UUID;

public class TrainerAssignment {
    private UUID workshopUUID;
    private UUID trainerUUID;

    public TrainerAssignment() {
    }

    public TrainerAssignment(UUID workshopUUID, UUID trainerUUID) {
        this.workshopUUID = workshopUUID;
        this.trainerUUID = trainerUUID;
    }

    public UUID getWorkshopUUID() {
        return workshopUUID;
    }

    public UUID getTrainerUUID() {
        return trainerUUID;
    }
}
