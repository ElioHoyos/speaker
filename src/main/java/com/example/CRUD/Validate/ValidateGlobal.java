package com.example.CRUD.Validate;

import com.example.CRUD.dao.SpeakerRequestDao;
import org.springframework.util.StringUtils;

public class ValidateGlobal {

    public static void validateSpeaker(SpeakerRequestDao student) {
        if(StringUtils.isEmpty(student.getName())){
            throw new IllegalArgumentException("el nombre es null o vacío");
        }
    }

}
