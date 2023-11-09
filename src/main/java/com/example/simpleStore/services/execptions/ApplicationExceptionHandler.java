package com.example.simpleStore.services.execptions;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity nullExepction(Exception e){
        return new ResponseEntity("Não encontrado no Banco de Dados", HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public  ResponseEntity entityExecption(Exception a){
        return new ResponseEntity("Entidade não encontrada no Banco de dados", HttpStatus.NOT_FOUND);
    }
}
