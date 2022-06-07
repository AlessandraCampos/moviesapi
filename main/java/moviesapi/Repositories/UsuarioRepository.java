package moviesapi.Repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import moviesapi.Entities.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	
    Optional<Usuario> findByEmail(String email);
    Page<Usuario>findAll(Pageable pageable);
}
