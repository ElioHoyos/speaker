package com.example.CRUD.dao.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentRequestDao {

    private Long id;
    private String name;
    private Integer age;
    private String dni;
    private String email;
    private String cellphone;
    private Boolean status;

}
