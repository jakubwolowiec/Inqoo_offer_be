package inqooprojectbe.controllers;

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
    public  ResponseEntity<Workshop>addWorkshop(@RequestBody Workshop workshop){
        Workshop workshopToAdd = workshopService.addWorkshop(workshop);
        return new ResponseEntity<>(workshopToAdd, HttpStatus.CREATED);
    }
}
