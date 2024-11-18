package com.example.CRUD.dao;

import com.example.CRUD.entity.enums.SpeakerType;
import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
    private BigDecimal salary;
    private String cellphone;
    private Boolean status;
    private SpeakerType type;
}
