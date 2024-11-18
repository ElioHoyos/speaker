package com.example.CRUD.dao.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ScoreRequestDao {

    private Long score;
    private Long idSpeaker;
    private Long idStudent;

}
