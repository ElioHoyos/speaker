package com.example.CRUD.dao;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Speaker2Dao extends SpeakerParent{

    private String address;
    private String cellphone;

}
