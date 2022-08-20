package inqooprojectbe.model;

public class WorkshopMapper {
    public WorkshopDTO toDTO(Workshop workshop){

        return new WorkshopDTO(workshop.getName(),
                workshop.getPrice(), workshop.getDescription(), workshop.getWorkshopTime());
    }
    public Workshop fromDTO(WorkshopDTO workshopDTO){

        return new Workshop(workshopDTO.name,
                workshopDTO.price, workshopDTO.description, workshopDTO.time);
    }
}
