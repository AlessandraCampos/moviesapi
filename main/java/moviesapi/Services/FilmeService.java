package moviesapi.Services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import moviesapi.Entities.Filme;
import moviesapi.Repositories.FilmeRepository;

@Service
public class FilmeService {
	
	private FilmeRepository filmeRepository;
	
	
	public FilmeService (FilmeRepository filmeRepository) {
		this.filmeRepository = filmeRepository;
		
	}
	
	public Page<Filme> listarFilmes(Pageable pageable) {	
		
		return filmeRepository.findAll(pageable);
	}
	
	public Filme salvarFilme(Filme filme) {
		try {
			filmeRepository.save(filme);	
			
		}catch(Exception e ) {
			 e.printStackTrace();
		}
		return filme;
	}
	
	
	public Filme findById(Long id) {
		
	Optional<Filme> buscaFilme = filmeRepository.findById(id);
	
	
	return buscaFilme.orElseThrow(()-> new EntityNotFoundException("Filme não encontrado"));
	}
	
	
	

	public Filme  atualizarFilme( Filme filme, Long id){
	
		Filme filmeOriginal = this.findById(id);
		
			filme.setId(filmeOriginal.getId());
			
			return filmeRepository.save(filme);
		
}

	public void excluirFilme(Long id) {
		Filme filmeOriginal = this.findById(id);
		
		filmeRepository.deleteById(filmeOriginal.getId());
		
	}
}
