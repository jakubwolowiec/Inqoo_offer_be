package inqooprojectbe.controllers;

import inqooprojectbe.model.*;
import inqooprojectbe.repositories.WorkshopRepository;
import inqooprojectbe.services.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("/trainerAssignment")
    public ResponseEntity<Workshop>addTrainerToWorkshop(@RequestBody TrainerAssignment trainerAssignment){
        UUID trainerUUID = trainerAssignment.getTrainerUUID();
        UUID workshopUUID = trainerAssignment.getWorkshopUUID();
        workshopService.addTrainerToWorkshop(workshopUUID, trainerUUID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}