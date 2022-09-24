package inqooprojectbe.controllers;

import inqooprojectbe.model.Schedule;
import inqooprojectbe.model.ScheduleDTO;
import inqooprojectbe.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleDTO>> getAllSchedules(){
        List<ScheduleDTO> scheduleDTOS = scheduleService.getSchedules();
        return new ResponseEntity<>(scheduleDTOS, HttpStatus.OK);
    }

    @PostMapping("/schedule")
    public ResponseEntity<ScheduleDTO> addSchedule(@RequestBody Schedule schedule){
        ScheduleDTO scheduleDTO = scheduleService.bookWorkshop(schedule.getWorkshopUUID(), schedule.getTrainerUUID(), schedule.getStartDate());
        return new ResponseEntity<>(scheduleDTO, HttpStatus.CREATED);
    }

}
