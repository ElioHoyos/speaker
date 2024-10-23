package com.example.CRUD.service.impl;

import com.example.CRUD.Validate.ValidateGlobal;
import com.example.CRUD.dao.SpeakerDao;
import com.example.CRUD.dao.SpeakerRequestDao;
import com.example.CRUD.entity.Speaker;
import com.example.CRUD.repository.SpeakerRepository;
import com.example.CRUD.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;


    @Override
    public List<SpeakerDao> getSpeakers() {
        return speakerRepository.findAll().stream().map(
                speaker -> SpeakerDao.builder()
                        .type(speaker.getType())
                        .salary(speaker.getSalary())
                        .email(speaker.getEmail())
                        .age(speaker.getAge())
                        .name(speaker.getName())
                        .id(speaker.getId()).build()
        ).toList();
    }

    @Override
    public List<SpeakerDao> getSpeakers1() {
        return speakerRepository.findAll().stream().map(
                speaker -> SpeakerDao.builder()
                        .status(speaker.getStatus())
                        .type(speaker.getType())
                        .address(speaker.getAddress())
                        .cellphone(speaker.getCellphone())
                        .age(speaker.getAge())
                        .name(speaker.getName())
                        .id(speaker.getId()).build()
        ).toList();
    }

    @Override
    public Optional<Speaker> getSpeaker(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(SpeakerRequestDao student) {

        ValidateGlobal.validateSpeaker(student);

        speakerRepository.save(Speaker.builder()
                 .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .address(student.getAddress())
                .salary(student.getSalary())
                .cellphone(student.getCellphone())
                .status(student.getStatus())
                .type(student.getType())
                .build());
    }

    @Override
    public void delete(Long id) {
        speakerRepository.deleteById(id);
    }
}
