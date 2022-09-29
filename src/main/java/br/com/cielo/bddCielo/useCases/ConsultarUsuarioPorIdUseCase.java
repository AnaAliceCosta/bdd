package br.com.cielo.bddCielo.useCases;

import br.com.cielo.bddCielo.entities.Usuario;
import br.com.cielo.bddCielo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ConsultarUsuarioPorIdUseCase {
    @Autowired
    UsuarioRepository repository;

    public Usuario execute(Long id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        Usuario usuario = usuarioOptional.orElseThrow(RuntimeException::new);
        return usuario;

    }
}
