package moviesapi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import moviesapi.Entities.Sala;

@Repository
public interface SalaRepository extends JpaRepository< Sala, Long >{

	Optional<Sala> findById(Optional<Sala> salaId);
	

}
