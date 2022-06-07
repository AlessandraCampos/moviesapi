package moviesapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import moviesapi.Entities.Sala;
import moviesapi.Repositories.SalaRepository;

@Service
public class SalaService {

	private SalaRepository salaRepository;

	public SalaService(SalaRepository salaRepository) {
		this.salaRepository = salaRepository;
	}

	public List<Sala> listarSalas() {

		return salaRepository.findAll();
	}
	
	

	public Sala salvarSala(Sala sala) {
		try {
			salaRepository.save(sala);

			return sala;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return sala;

	}
	

	public Sala salaPorId(Long id) {

		Optional<Sala> optional = salaRepository.findById(id);

		return optional.get();
	}
	
	
	
	public void deleteSala(Long id) {
		
	Sala encontraSala =	this.salaPorId(id);
	
	salaRepository.delete(encontraSala);
		
	}
	
	public int controleAssentos(Long salaId , int quantidade ) {
		Optional<Sala> findSala = salaRepository.findById(salaId);
		if(findSala.isPresent()) {
			Sala sala = findSala.get();
			sala.setAssentos(sala.getAssentos() - quantidade);
			return  salaRepository.save(sala).getAssentos();
		}
		
		Sala sala = new Sala();
		
		sala.setAssentos(quantidade);
		return  salaRepository.save(sala).getAssentos();
	}

	
}
