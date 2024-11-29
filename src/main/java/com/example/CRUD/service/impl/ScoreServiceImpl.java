package com.example.CRUD.service.impl;

import com.example.CRUD.dao.request.ScoreRequestDao;
import com.example.CRUD.entity.Score;
import com.example.CRUD.entity.Speaker;
import com.example.CRUD.entity.Student;
import com.example.CRUD.entity.enums.ScoreType;
import com.example.CRUD.exception.NotFoundException;
import com.example.CRUD.exception.SpeakerNotFoundException;
import com.example.CRUD.exception.StudentNotFoundException;
import com.example.CRUD.repository.ScoreRepository;
import com.example.CRUD.repository.SpeakerRepository;
import com.example.CRUD.repository.StudentRepository;
import com.example.CRUD.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RestControllerAdvice
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveScoreToStudent(ScoreRequestDao requestDao) {

        List<NotFoundException> lisErrors = new ArrayList<>();
        // Validar el score y acumular errores si hay
        //ScoreType scoreType = evaluateScore(requestDao.getScore());
        Student student = studentRepository.findById(requestDao.getIdStudent())
                .orElseGet(() -> {
                    lisErrors.add(new NotFoundException("Student no found with id :: " + requestDao.getIdStudent()));
                    return null;
                });
                //.orElseThrow(() -> new StudentNotFoundException(requestDao.getIdStudent()));
        Speaker speaker = speakerRepository.findById(requestDao.getIdSpeaker())
                .orElseGet(() -> {
                    lisErrors.add(new NotFoundException("Speaker not found with id :: " + requestDao.getIdSpeaker()));
                    return null;
                });
                //.orElseThrow(() -> new SpeakerNotFoundException(requestDao.getIdSpeaker()));

        if(!ObjectUtils.isEmpty(lisErrors)){
            throw new NotFoundException(lisErrors);
        }

        try {
            // Intentar evaluar el score y capturar posibles errores
            ScoreType scoreType = evaluateScore(requestDao.getScore());

            // Continuar con la creación del Score si no hay errores
            Score score = Score.builder()
                    .score(requestDao.getScore())
                    .date(LocalDate.now())
                    .scoreType(scoreType)
                    .student(student)
                    .speaker(speaker)
                    .build();
            scoreRepository.save(score);

        } catch (IllegalArgumentException e) {
            // Agregar el mensaje de error a la lista de errores
            lisErrors.add(new NotFoundException(e.getMessage()));
        }
    }

//    private ScoreType getScoreTypeByScore(Long score){
//        return switch ((int) (score / 30)) {
//            case 0 -> // 0 - 30
//                    ScoreType.BAD;
//            case 1 -> // 31 - 60
//                    ScoreType.REGULAR;
//            case 2 -> // 61 - 90
//                    ScoreType.GOOD;
//            case 3 -> // 91 - 100
//                    ScoreType.GOOD; // Puedes decidir cómo manejar scores > 100
//            default -> throw new IllegalArgumentException("Score must be between 0 and 100.");
//        };
//    }

    public static ScoreType evaluateScore(long score) {
        // Validar si el score está fuera del rango esperado
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("La puntuación debe estar entre 0 y 100.");
        }

        return switch ((int) (score / 30)) {
            case 0 -> ScoreType.BAD;        // 0 - 30
            case 1 -> ScoreType.REGULAR;    // 31 - 60
            case 2 -> ScoreType.GOOD;       // 61 - 90
            case 3 -> ScoreType.GOOD;       // 91 - 100
            // No se necesita un case para valores > 3 porque ya se validó antes
            default -> throw new IllegalStateException("Unexpected value: " + (int) (score / 30));
        };
    }

    public static void main(String[] args) {
        long score = 200; // Cambia este valor para probar diferentes casos
        try {
            ScoreType result = evaluateScore(score);
            System.out.println("El tipo de puntuación es: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void someMethod(Long speakerId, Long studentId) {
        if (speakerId == null) {
            throw new SpeakerNotFoundException("No se encontró el speaker.");
        }
        if (studentId == null) {
            throw new StudentNotFoundException("No se encontró el estudiante.");
        }
    }


}
