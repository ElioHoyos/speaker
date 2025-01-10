package com.example.CRUD.service.impl;

import com.example.CRUD.Validate.ValidateGlobal;
import com.example.CRUD.dao.Speaker1Dao;
import com.example.CRUD.dao.Speaker2Dao;
import com.example.CRUD.dao.SpeakerRequestDao;
import com.example.CRUD.entity.Speaker;
import com.example.CRUD.repository.SpeakerRepository;
import com.example.CRUD.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;


    @Override
    public List<Speaker2Dao> getSpeakers() {
        return speakerRepository.findAll().stream()
                .map(speaker -> Speaker2Dao.builder()
                        .type(speaker.getType())
                        .salary(speaker.getSalary())
                        .address(speaker.getAddress())
                        .cellphone(speaker.getCellphone())
                        .name(speaker.getName())
                        .id(speaker.getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<Speaker1Dao> getSpeakers1() {
        return speakerRepository.findAll().stream().map(
                speaker -> Speaker1Dao.builder()
                        .type(speaker.getType())
                        .salary(speaker.getSalary())
                        .age(speaker.getAge())
                        .email(speaker.getEmail())
                        .name(speaker.getName())
                        .id(speaker.getId())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public Optional<Speaker> getSpeaker(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(SpeakerRequestDao speakerRequestDao) {

        ValidateGlobal.validateSpeaker(speakerRequestDao);

        speakerRepository.save(Speaker.builder()
                 .name(speakerRequestDao.getName())
                .email(speakerRequestDao.getEmail())
                .age(speakerRequestDao.getAge())
                .address(speakerRequestDao.getAddress())
                .salary(speakerRequestDao.getSalary())
                .cellphone(speakerRequestDao.getCellphone())
                .status(speakerRequestDao.getStatus())
                .type(speakerRequestDao.getType())
                .build());
    }

    @Override
    public void delete(Long id) {
        speakerRepository.deleteById(id);
    }
}
