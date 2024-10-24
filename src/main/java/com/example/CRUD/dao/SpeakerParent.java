package com.example.CRUD.dao;

import com.example.CRUD.entity.SpeakerType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
public class SpeakerParent {

    private Long id;
    private String name;
    private BigDecimal salary;
    private SpeakerType type;

}
