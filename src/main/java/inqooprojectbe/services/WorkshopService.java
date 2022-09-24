package inqooprojectbe.services;

import inqooprojectbe.model.*;
import inqooprojectbe.repositories.SubcategoryRepository;
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
    private final TrainerService trainerService;
    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    public  WorkshopService(WorkshopRepository workshopRepository, WorkshopMapper workshopMapper, TrainerService trainerService, SubcategoryRepository subcategoryRepository)
    {this.workshopRepository = workshopRepository;
        this.workshopMapper = workshopMapper;
        this.trainerService = trainerService;
        this.subcategoryRepository = subcategoryRepository;
    }

    public Workshop addWorkshop(Workshop newWorkshop, String subCategoryUUID) {
        newWorkshop.setWorkshopUUID(UUID.randomUUID().toString());
        Workshop savedWorkshop = workshopRepository.save(newWorkshop);
        subcategoryRepository.findBySubcategoryUUID(subCategoryUUID).addWorkshop(savedWorkshop);
        return savedWorkshop;
    }

    public List<WorkshopDTO>getWorkshops(){
        List<WorkshopDTO>workshopDTOList = new ArrayList<>();
        for (Workshop workshop: workshopRepository.findAll()
        ) {
            workshopDTOList.add(workshopMapper.toDTO(workshop));
        }
        return workshopDTOList;}

    public void addTrainerToWorkshop(String workshopUUID, String trainerUUID){
        Trainer trainer = trainerService.getTrainerByUUID(trainerUUID) ;
        Workshop workshop = workshopRepository.findByWorkshopUUID(workshopUUID);
        workshop.addTrainerToWorkshop(trainer);
    }
}