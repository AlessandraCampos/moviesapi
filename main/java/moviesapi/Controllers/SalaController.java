package moviesapi.Controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moviesapi.DTO.FilmeDTO;
import moviesapi.DTO.MapperDTO;
import moviesapi.DTO.SalaDTO;
import moviesapi.Entities.Sala;
import moviesapi.Services.SalaService;


@RestController
@RequestMapping("/salas")
public class SalaController {
	
	private SalaService salaService;
	
	public SalaController (SalaService salaService) {
		this.salaService = salaService;
	}
	
	@Autowired
	private MapperDTO mapper;
	
	public SalaDTO toSalaDTO(Sala sala) {
		
		return mapper.modelMapper().map(sala, SalaDTO.class);	
	}
	
	public Sala toEntity(SalaDTO salaDTO) {
		return mapper.modelMapper().map(salaDTO, Sala.class);
	}
	
	@GetMapping
	public ResponseEntity<List<SalaDTO>> ListarSalas(){
		
		return ResponseEntity.ok(
				salaService.listarSalas()
				.stream()
				.map(this:: toSalaDTO).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity <SalaDTO> cadastrarSala(@RequestBody SalaDTO salaDTO) {
		
			Sala sala = salaService.salvarSala(toEntity(salaDTO));
			return ResponseEntity.ok(toSalaDTO(sala));
	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<SalaDTO> excluirSala(@PathVariable Long id) {
		try {
			salaService.deleteSala(id);
			return ResponseEntity.ok().build();

		} catch (RuntimeException ex) {

			return ResponseEntity.notFound().build();
		}
}
}
