package com.example.simpleStore.services.execptions;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity nullExepction(Exception e){
        return new ResponseEntity("ERROR: Favor informar o dado em questão valido", HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public  ResponseEntity entityExecption(Exception a){
        return new ResponseEntity("ERROR: Entidade não encontrada no Banco de dados", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public  ResponseEntity unauthorized(Exception b){
        return new ResponseEntity("ERROR: VOCE NÃO É AUTORIZADO, FAVOR VALIDAR CREDENCIAIS!", HttpStatus.UNAUTHORIZED);
    }
}
