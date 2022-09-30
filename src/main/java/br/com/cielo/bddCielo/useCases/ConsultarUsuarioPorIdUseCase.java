package br.com.cielo.bddCielo.useCases;

import br.com.cielo.bddCielo.entities.Usuario;
import br.com.cielo.bddCielo.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ConsultarUsuarioPorIdUseCase {

    private final UsuarioRepository repository;

    public Usuario execute(Long id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        Usuario usuario = usuarioOptional.orElseThrow(RuntimeException::new);
        return usuario;

    }
}
