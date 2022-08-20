package inqooprojectbe.services;

import inqooprojectbe.model.Workshop;
import inqooprojectbe.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkshopService {
    private final WorkshopRepository workshopRepository;

    @Autowired
    public  WorkshopService(WorkshopRepository workshopRepository)
    {this.workshopRepository = workshopRepository;}

    public Workshop addWorkshop (Workshop workshop) {return workshopRepository.save(workshop);}

    public List<Workshop> getWorkshops(){return workshopRepository.findAll();}
}
