package br.com.cielo.bddCielo.rest;

import br.com.cielo.bddCielo.entities.Usuario;
import br.com.cielo.bddCielo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @PostMapping("/criarusuario")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioCriado = service.criar(usuario);
        ResponseEntity usuarioResponse = new ResponseEntity(usuarioCriado, HttpStatus.CREATED);
        return usuarioResponse;

    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> consultaUsuario(@PathVariable Long id){
        Usuario usuario = service.consultarPorId(id);
        ResponseEntity usuarioResponse = ResponseEntity.ok(usuario);
        return usuarioResponse;

    }
}
