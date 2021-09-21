package com.code.eventbelt.Validator;

import org.springframework.stereotype.Component;

import com.code.eventbelt.Models.Event;

@Component
public interface Validator {

    public boolean supports(Class<?> clazz);
    

}
