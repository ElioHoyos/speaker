package com.example.CRUD.dao;

import com.example.CRUD.entity.SpeakerType;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Getter
public class SpeakerDao implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String email;
    private BigDecimal salary;
    private String cellphone;
    private Boolean status;
    private SpeakerType type;

}

