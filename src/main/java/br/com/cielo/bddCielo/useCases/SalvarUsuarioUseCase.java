package br.com.cielo.bddCielo.useCases;

import br.com.cielo.bddCielo.entities.Usuario;
import br.com.cielo.bddCielo.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SalvarUsuarioUseCase {
    private final UsuarioRepository repository;

    public Usuario execute(Usuario usuario) {

        Usuario save = repository.save(usuario);
        return save;

    }
}
