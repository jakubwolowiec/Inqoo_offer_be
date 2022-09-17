package inqooprojectbe.services;

import inqooprojectbe.model.*;
import inqooprojectbe.repositories.TrainerRepository;
import inqooprojectbe.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WorkshopService{
    private final WorkshopRepository workshopRepository;
    private final WorkshopMapper workshopMapper;
    private final TrainerRepository trainerRepository;

    @Autowired
    public  WorkshopService(WorkshopRepository workshopRepository, WorkshopMapper workshopMapper, TrainerRepository trainerRepository)
    {this.workshopRepository = workshopRepository;
        this.workshopMapper = workshopMapper;
        this.trainerRepository = trainerRepository;
    }

    public WorkshopDTO addWorkshop(WorkshopDTO newWorkshopDto) {
        Workshop workshop = workshopMapper.fromDTO(newWorkshopDto);
        workshop.setWorkshopUUID(UUID.randomUUID());
        Workshop savedWorkshop = workshopRepository.save(workshop);
        return workshopMapper.toDTO(savedWorkshop);
    }

    public List<WorkshopDTO>getWorkshops(){
        List<WorkshopDTO>workshopDTOList = new ArrayList<>();
        for (Workshop workshop: workshopRepository.findAll()
        ) {
            workshopDTOList.add(workshopMapper.toDTO(workshop));
        }
        return workshopDTOList;}

    public void addTrainerToWorkshop(UUID workshopUUID, UUID trainerUUID){
        Trainer trainer = trainerRepository.findByTrainerUUID(trainerUUID).orElse(null) ;
        Workshop workshop = workshopRepository.findByWorkshopUUID(workshopUUID);
        workshop.addTrainerToWorkshop(trainer);
    }
    public int getWorkshopDays(UUID workshopUUID){
    int workshopDays = 0;
    int workshopTime = workshopRepository.findByWorkshopUUID(workshopUUID).getWorkshopTime();
    while(workshopTime > 0){
        workshopTime =- 8;
        workshopDays ++;
    }
    return workshopDays;}

    }
