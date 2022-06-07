package moviesapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import moviesapi.Entities.Compra;
import moviesapi.Repositories.CompraRepository;

@Service
public class CompraService {
	
	private CompraRepository compraRepository;
	
	public CompraService(CompraRepository comprasRepository) {
		this.compraRepository = comprasRepository;
	}
	
	
	
	public List<Compra> listarCompras (){
		
		return compraRepository.findAll();
		
	}
	
	
	
	public Compra novaCompra(Compra compra) {
		
		
		return  compraRepository.save(compra);
	}
	
	
	
	public Compra findById(Long id ) {
		
		Optional<Compra> optional = compraRepository.findById(id);
		
		return optional.get();
	}
	
	
	
	public void deleteCompra(Long id) {
		
		Compra idCompra = this.findById(id);
		
		compraRepository.deleteById(idCompra.getId());
	}

}
