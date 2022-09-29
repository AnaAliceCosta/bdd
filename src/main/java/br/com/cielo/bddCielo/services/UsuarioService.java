package br.com.cielo.bddCielo.services;

import br.com.cielo.bddCielo.entities.Usuario;
import br.com.cielo.bddCielo.useCases.ConsultarUsuarioPorIdUseCase;
import br.com.cielo.bddCielo.useCases.ConsultarUsuarioPorNomeUseCase;
import br.com.cielo.bddCielo.useCases.SalvarUsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    SalvarUsuarioUseCase salvarUsuario;

    @Autowired
    ConsultarUsuarioPorNomeUseCase consularPorNome;
    @Autowired
    ConsultarUsuarioPorIdUseCase consularPorId;


    public Usuario criar(Usuario usuario){

        if(consularPorNome.execute(usuario.getNome()) != null)
            throw new RuntimeException("usuario ja cadastrado");

        Usuario usuarioSalvo = salvarUsuario.execute(usuario);
        return usuarioSalvo;

    }


    public Usuario consultarPorId(Long id) {
        Usuario usuarioConsultado = consularPorId.execute(id);
        return usuarioConsultado;
    }
}
