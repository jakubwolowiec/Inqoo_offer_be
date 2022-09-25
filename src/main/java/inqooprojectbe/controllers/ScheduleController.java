package inqooprojectbe.controllers;

import inqooprojectbe.model.Schedule;
import inqooprojectbe.model.ScheduleDTO;
import inqooprojectbe.services.ScheduleService;
import inqooprojectbe.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final TrainerService trainerService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, TrainerService trainerService) {
        this.scheduleService = scheduleService;
        this.trainerService = trainerService;
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleDTO>> getAllSchedules(){
        List<ScheduleDTO> scheduleDTOS = scheduleService.getSchedules();
        return new ResponseEntity<>(scheduleDTOS, HttpStatus.OK);
    }

    @PostMapping("/schedule")
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule){
        Schedule schedule1 = scheduleService.bookWorkshop(schedule.getWorkshopUUID(), schedule.getTrainerUUID(), schedule.getStartDate());
        trainerService.addScheduleToTrainer(schedule1);
        return new ResponseEntity<>(schedule, HttpStatus.CREATED);
    }

}
