package inqooprojectbe.controllers;

import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.TrainerDTO;
import inqooprojectbe.model.Workshop;
import inqooprojectbe.model.WorkshopDTO;
import inqooprojectbe.repositories.WorkshopRepository;
import inqooprojectbe.services.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WorkshopController {
    private WorkshopService workshopService;

    @Autowired
    public  WorkshopController(WorkshopService workshopService){this.workshopService = workshopService;}

    @GetMapping("/workshop")
    public ResponseEntity<List<WorkshopDTO>> getAllWorkshop(){
        List<WorkshopDTO> workshopList = workshopService.getWorkshops();
        return new ResponseEntity<>(workshopList, HttpStatus.OK);
    }
    @PostMapping("/workshop")
    public  ResponseEntity<WorkshopDTO>addWorkshop(@RequestBody WorkshopDTO workshop){
        WorkshopDTO workshopToAdd = workshopService.addWorkshop(workshop);
        return new ResponseEntity<>(workshopToAdd, HttpStatus.CREATED);
    }

//    @PutMapping("/workshop")
//    public ResponseEntity<Workshop>addTrainerToWorkshop(){
//
//    }
}
