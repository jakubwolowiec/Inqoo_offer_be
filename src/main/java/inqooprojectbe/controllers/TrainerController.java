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
    private final TrainerRepository trainerRepository;
    private final TrainerService trainerService;

    TrainerController(TrainerRepository trainerRepository, TrainerService trainerService){
        this.trainerRepository = trainerRepository;
        this.trainerService = trainerService;}

    @GetMapping("/trainer")
    public ResponseEntity<List<TrainerDTO>> getAllTrainer(){
        List<TrainerDTO> trainerList = trainerService.getTrainers();
        return new ResponseEntity<>(trainerList, HttpStatus.OK);
    }

    @PostMapping("/trainer")
    public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer){
        Trainer addedTrainer = trainerService.addTrainer(trainer);
        return new ResponseEntity<>(addedTrainer, HttpStatus.CREATED);
    }

}
