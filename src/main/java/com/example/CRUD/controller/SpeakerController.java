package com.example.CRUD.controller;

import com.example.CRUD.dao.SpeakerDao;
import com.example.CRUD.dao.SpeakerRequestDao;
import com.example.CRUD.entity.Speaker;
import com.example.CRUD.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/speaker")
@Validated
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @GetMapping("/custom2")
    public List<SpeakerDao> getAll(){
        return speakerService.getSpeakers();
    }

    @GetMapping("/custom")
    public List<SpeakerDao> getAllByCustom(){
        return speakerService.getSpeakers1();
    }

    @GetMapping("/{Id}")
    public Optional<Speaker> getBId(@PathVariable("Id") Long Id){
        return speakerService.getSpeaker(Id);
    }

    @PostMapping
    public void saveSpeaker(@RequestBody @Valid SpeakerRequestDao speaker){
        speakerService.save(speaker);
        //return "User created with email: " + speaker.getEmail();
    }

    @DeleteMapping("/{Id}")
    public void saveUpdate(@PathVariable("Id") Long Id){
        speakerService.delete(Id);
    }

}
