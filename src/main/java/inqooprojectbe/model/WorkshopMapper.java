package inqooprojectbe.model;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WorkshopMapper {
    public WorkshopDTO toDTO(Workshop workshop){

        return new WorkshopDTO(workshop.getName(),
                workshop.getPrice(), workshop.getDescription(), workshop.getWorkshopTime(), workshop.getWorkshopUUID(), workshop.getTrainers());
    }
    public Workshop fromDTO(WorkshopDTO workshopDTO){
        return new Workshop(workshopDTO.getName(),
                workshopDTO.getPrice(), workshopDTO.getDescription(), workshopDTO.getTime(), workshopDTO.getWorkshopUUID() );
    }
}
