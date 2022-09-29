package br.com.cielo.bddCielo.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
@ResponseStatus(HttpStatus.NO_CONTENT)

public class UsuarioNaoEncontradoExeption extends HttpClientErrorException {
    private final String message;

    public UsuarioNaoEncontradoExeption(String message) {
        super(HttpStatus.NO_CONTENT);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
