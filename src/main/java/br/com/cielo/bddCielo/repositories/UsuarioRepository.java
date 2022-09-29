package br.com.cielo.bddCielo.repositories;

import br.com.cielo.bddCielo.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
    List<Usuario> findByNome(String nome);
}
