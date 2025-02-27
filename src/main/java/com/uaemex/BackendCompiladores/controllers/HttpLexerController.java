package com.uaemex.BackendCompiladores.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.uaemex.BackendCompiladores.domains.Token;
import com.uaemex.BackendCompiladores.services.TokenService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin("*")
public class HttpLexerController {

    @GetMapping("/hola")
    public String getMethodName() {
        return new String("hola");
    }

    @PostMapping("/recibir")
    public List<Token> postMethodName(@RequestBody String textoRecibido) {
        System.out.println(textoRecibido);
        TokenService tokenService = new TokenService();
        List<Token> paraenviar = tokenService.obtenerLista(textoRecibido);
        return paraenviar;
    }
    
    
    
}
