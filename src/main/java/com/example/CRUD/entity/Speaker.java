package com.example.CRUD.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@Entity
@Table(name = "speaker")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String email;
    private BigDecimal salary;
    private String cellphone;
    private Boolean status;
    @Enumerated(EnumType.STRING)
    private SpeakerType type;

}
