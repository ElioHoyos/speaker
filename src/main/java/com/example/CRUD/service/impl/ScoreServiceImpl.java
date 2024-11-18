package com.example.CRUD.service.impl;

import com.example.CRUD.dao.request.ScoreRequestDao;
import com.example.CRUD.entity.Score;
import com.example.CRUD.entity.Speaker;
import com.example.CRUD.entity.Student;
import com.example.CRUD.entity.enums.ScoreType;
import com.example.CRUD.exception.SpeakerNotFoundException;
import com.example.CRUD.exception.StudentNotFoundException;
import com.example.CRUD.repository.ScoreRepository;
import com.example.CRUD.repository.SpeakerRepository;
import com.example.CRUD.repository.StudentRepository;
import com.example.CRUD.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveScoreToStudent(ScoreRequestDao requestDao) {
//        ScoreType scoreType = getScoreTypeByScore(requestDao.getScore());
          ScoreType scoreType = evaluateScore(requestDao.getScore());
        Student student = studentRepository.findById(requestDao.getIdStudent())
                .orElseThrow(() -> new StudentNotFoundException(requestDao.getIdStudent()));
        Speaker speaker = speakerRepository.findById(requestDao.getIdSpeaker())
                .orElseThrow(() -> new SpeakerNotFoundException(requestDao.getIdSpeaker()));

        Score score = Score.builder()
                .score(requestDao.getScore())
                .date(LocalDate.now())
                .scoreType(scoreType)
                .student(student)
                .speaker(speaker)
                .build();
        scoreRepository.save(score);
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
            throw new IllegalArgumentException("Score must be between 0 and 100.");
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

}
