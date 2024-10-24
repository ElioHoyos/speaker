package com.example.CRUD.dao;

import com.example.CRUD.entity.SpeakerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
public class Speaker1Dao extends SpeakerParent{

    private Integer age;
    private String email;

}
