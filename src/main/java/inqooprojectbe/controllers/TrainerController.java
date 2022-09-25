package inqooprojectbe.controllers;

import inqooprojectbe.model.Trainer;
import inqooprojectbe.model.TrainerDTO;
import inqooprojectbe.model.Workshop;
import inqooprojectbe.repositories.TrainerRepository;
import inqooprojectbe.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TrainerController {
    private final TrainerService trainerService;

    TrainerController( TrainerService trainerService){
        this.trainerService = trainerService;}

    @GetMapping("/trainer/{workshopUUID}")
    public ResponseEntity<TrainerDTO> getTrainerByWorkshopUUID(@PathVariable String workshopUUID){
        TrainerDTO trainerList = trainerService.getTrainer(workshopUUID);
        return new ResponseEntity<>(trainerList, HttpStatus.OK);
    }

    @PostMapping("/trainer/{workshopUUID}")
    public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer, @PathVariable String workshopUUID){
        Trainer addedTrainer = trainerService.addTrainer(trainer);
        return new ResponseEntity<>(addedTrainer, HttpStatus.CREATED);
    }

}
