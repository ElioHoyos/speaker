package com.example.CRUD.dao;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Speaker1Dao extends SpeakerParent{

    private Integer age;
    private String email;

}
