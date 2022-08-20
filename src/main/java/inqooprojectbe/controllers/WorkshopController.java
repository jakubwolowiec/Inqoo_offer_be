package inqooprojectbe.controllers;

import inqooprojectbe.model.Workshop;
import inqooprojectbe.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WorkshopController {
    private WorkshopRepository workshopRepository;

    @Autowired
    public  WorkshopController(WorkshopRepository workshopRepository){this.workshopRepository = workshopRepository;}

    @GetMapping("/workshop")
    public ResponseEntity<List<Workshop>> getAllWorkshop(){
        List<Workshop> workshopList = workshopRepository.findAll();
        return new ResponseEntity<>(workshopList, HttpStatus.OK);
    }
    @PostMapping("/addworkshop")
    public  ResponseEntity<Workshop>addWorkshop(@RequestBody Workshop workshop){
        Workshop workshopToAdd = workshopRepository.save(workshop);
        return new ResponseEntity<>(workshopToAdd, HttpStatus.OK);
    }
}
