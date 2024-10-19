package com.example.CRUD.dao;

import com.example.CRUD.entity.SpeakerType;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Builder
@Getter
public class SpeakerRequestDao {

    private Long id;
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;
    private Integer age;
    private String address;
    private String email;
    private BigDecimal salary;
    private String cellphone;
    private Boolean status;
    private SpeakerType type;

}
