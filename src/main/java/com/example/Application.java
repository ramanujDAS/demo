package com.example;

import com.example.truecaller.TrueCaller;
import com.example.truecaller.exception.BadRequest;
import com.example.truecaller.exception.WrongConfigurationException;
import com.example.truecaller.util.UserCategory;
import io.micronaut.runtime.Micronaut;

import java.text.ParseException;

public class Application {

    public static void main(String[] args) throws BadRequest, WrongConfigurationException, ParseException {
        Micronaut.run(Application.class, args);
        TrueCaller trueCaller= new TrueCaller();
        trueCaller.startApplication();
    }
}