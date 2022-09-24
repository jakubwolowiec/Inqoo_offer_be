package inqooprojectbe.model;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WorkshopMapper {
    public WorkshopDTO toDTO(Workshop workshop) {

        WorkshopDTO workshopDTO = new WorkshopDTO(workshop.getName(),
                workshop.getPrice(), workshop.getDescription(), workshop.getWorkshopTime(), workshop.getTrainer());
        workshopDTO.setWorkshopUUID(workshop.getWorkshopUUID());

        return workshopDTO;
    }

    public Workshop fromDTO(WorkshopDTO workshopDTO) {
        Workshop workshop = new Workshop(workshopDTO.getName(),
                workshopDTO.getPrice(), workshopDTO.getDescription(), workshopDTO.getTime());
        workshop.setWorkshopUUID(workshopDTO.getWorkshopUUID());
        return workshop;
    }
}
