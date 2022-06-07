package moviesapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import moviesapi.Entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository <Compra, Long>{

}
