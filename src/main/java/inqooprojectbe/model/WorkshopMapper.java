package inqooprojectbe.model;

public class WorkshopMapper {
    public WorkshopDTO toDTO(Workshop workshop){
        WorkshopDTO workshopDTO = new WorkshopDTO(workshop.getName(),
                workshop.getPrice(), workshop.getDescription(), workshop.getWorkshopTime());
        return workshopDTO;
    }
    public Workshop fromDTO(WorkshopDTO workshopDTO){
        Workshop workshop = new Workshop(workshopDTO.name,
                workshopDTO.price, workshopDTO.description, workshopDTO.time);
        return workshop;
    }
}
