package inqooprojectbe.services;

import inqooprojectbe.model.*;
import inqooprojectbe.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkshopService {
    private final WorkshopRepository workshopRepository;
    private final WorkshopMapper workshopMapper;

    @Autowired
    public  WorkshopService(WorkshopRepository workshopRepository, WorkshopMapper workshopMapper)
    {this.workshopRepository = workshopRepository;
        this.workshopMapper = workshopMapper;
    }

    public Workshop addWorkshop (Workshop workshop) {return workshopRepository.save(workshop);}

    public List<WorkshopDTO>getWorkshops(){
        List<WorkshopDTO>workshopDTOList = new ArrayList<>();
        for (Workshop workshop: workshopRepository.findAll()
        ) {
            workshopDTOList.add(workshopMapper.toDTO(workshop));
        }
        return workshopDTOList;}
}
