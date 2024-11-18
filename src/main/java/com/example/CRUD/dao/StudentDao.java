package com.example.CRUD.dao;


import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class StudentDao implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String dni;
    private String email;
    private String cellphone;
    private Boolean status;

}
