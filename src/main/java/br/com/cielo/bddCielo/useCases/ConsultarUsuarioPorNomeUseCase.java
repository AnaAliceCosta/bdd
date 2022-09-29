package br.com.cielo.bddCielo.useCases;

import br.com.cielo.bddCielo.entities.Usuario;
import br.com.cielo.bddCielo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultarUsuarioPorNomeUseCase {
    @Autowired
    UsuarioRepository repository;

    public Usuario execute(String nome) {
        Usuario usuario= null;
        List<Usuario> usuarios = repository.findByNome(nome);


        if (usuarios.size() != 0) {
             usuario = usuarios.get(0);
        }
        return usuario;

    }
}
