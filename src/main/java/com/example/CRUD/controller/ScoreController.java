package com.example.CRUD.controller;

import com.example.CRUD.dao.request.ScoreRequestDao;
import com.example.CRUD.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/save")
    public void saveScoreToStudent(@RequestBody ScoreRequestDao requestDao) {
        scoreService.saveScoreToStudent(requestDao);
    }
}
