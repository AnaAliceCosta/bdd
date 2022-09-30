package br.com.cielo.bddCielo.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
@ResponseStatus(HttpStatus.NO_CONTENT)
@ResponseBody
public class UsuarioNaoEncontradoExeption extends RuntimeException {
    private final String message;

    public UsuarioNaoEncontradoExeption(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
