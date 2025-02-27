package com.uaemex.BackendCompiladores.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.uaemex.BackendCompiladores.domains.Token;

@Service
public class TokenService {

    public List<Token> obtenerLista(String cadena) {

        List<Token> tokens = new ArrayList<>();
        
                Pattern patron = Pattern.compile("" +
                "(?<reservada>public|class|static|void|if|else|while|byte|short|char)|"
                + "(?<operador>[+\\-/*=<>])|" + "(?<delimitador>[{}\\[\\]();])|" + "(?<literal>(-?[0-9])+(\\.[0-9])?)|"
                + "(?<identificador>[a-zA-Z][a-zA-Z0-9]+)");

        Matcher matcher = patron.matcher(cadena);
        while (matcher.find()) {
            if (matcher.group("reservada") != null)
                tokens.add(new Token(matcher.group("reservada"), "reservada"));
            if (matcher.group("delimitador") != null)
                tokens.add(new Token(matcher.group("delimitador"), "delimitador"));
            if (matcher.group("literal") != null)
                tokens.add(new Token(matcher.group("literal"), "literal"));
            if (matcher.group("operador") != null)
                tokens.add(new Token(matcher.group("operador"), "operador"));
            if (matcher.group("identificador") != null)
                tokens.add(new Token(matcher.group("identificador"), "identificador"));
        }

        return tokens;
    }

}
