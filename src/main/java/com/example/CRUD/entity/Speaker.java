package com.example.CRUD.entity;

import com.example.CRUD.entity.enums.SpeakerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
