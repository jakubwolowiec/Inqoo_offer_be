package inqooprojectbe.services;

import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.Workshop;
import inqooprojectbe.model.WorkshopDTO;
import inqooprojectbe.model.WorkshopMapper;
import inqooprojectbe.repositories.SubcategoryRepository;
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
public class WorkshopService {
    private WorkshopRepository workshopRepository;
    private  WorkshopMapper workshopMapper;
    private TrainerService trainerService;
    private SubcategoryRepository subcategoryRepository;
    private TrainerRepository trainerRepository;

    @Autowired
    public WorkshopService(WorkshopRepository workshopRepository, WorkshopMapper workshopMapper, TrainerRepository trainerRepository) {
        this.workshopRepository = workshopRepository;
        this.workshopMapper = workshopMapper;
        this.trainerService = trainerService;
        this.subcategoryRepository = subcategoryRepository;
        this.trainerRepository = trainerRepository;
    }

    public WorkshopService(WorkshopRepository workshopRepository) {
    }

    public Workshop addWorkshop(Workshop newWorkshop, String subCategoryUUID) {
        newWorkshop.setWorkshopUUID(UUID.randomUUID().toString());
        Workshop savedWorkshop = workshopRepository.save(newWorkshop);
        subcategoryRepository.findBySubcategoryUUID(subCategoryUUID).addWorkshop(savedWorkshop);
        return savedWorkshop;
    }

    public List<WorkshopDTO> getWorkshops() {
        List<WorkshopDTO> workshopDTOList = new ArrayList<>();
        for (Workshop workshop : workshopRepository.findAll()
        ) {
            workshopDTOList.add(workshopMapper.toDTO(workshop));
        }
        return workshopDTOList;
    }

    public void addTrainerToWorkshop(String workshopUUID, String trainerUUID) {
        Trainer trainer = trainerRepository.findByTrainerUUID(trainerUUID).orElse(null);
        Workshop workshop = workshopRepository.findByWorkshopUUID(workshopUUID);
        workshop.addTrainerToWorkshop(trainer);
    }

    public int getWorkshopDays(String workshopUUID) {
        int workshopDays = 0;
        int workshopTime = workshopRepository.findByWorkshopUUID(workshopUUID).getWorkshopTime();
        while (workshopTime > 0) {
            workshopTime = -8;
            workshopDays++;
        }
        return workshopDays;
    }
}