package com.example.CRUD.service;

import com.example.CRUD.dao.Speaker1Dao;
import com.example.CRUD.dao.Speaker2Dao;
import com.example.CRUD.dao.SpeakerDao;
import com.example.CRUD.dao.SpeakerRequestDao;
import com.example.CRUD.entity.Speaker;

import java.util.List;
import java.util.Optional;

public interface SpeakerService {

    List<Speaker2Dao> getSpeakers();
    List<Speaker1Dao> getSpeakers1();
    Optional<Speaker> getSpeaker(Long Id);
    void save(SpeakerRequestDao speaker);
    void delete(Long id);

}
