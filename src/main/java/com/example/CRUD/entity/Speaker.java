package com.example.CRUD.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
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

    // Constructor sin parámetros
    public Speaker() {
    }

    // Otros constructores, getters y setters
    public Speaker(Long id, String name, Integer age, String address, String email, BigDecimal salary, String cellphone, Boolean status, SpeakerType type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.salary = salary;
        this.cellphone = cellphone;
        this.status = status;
        this.type = type;
    }
}
