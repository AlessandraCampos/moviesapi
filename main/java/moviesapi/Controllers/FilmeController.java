package moviesapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import moviesapi.DTO.FilmeDTO;
import moviesapi.DTO.MapperDTO;
import moviesapi.Entities.Filme;
import moviesapi.Services.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	private FilmeService filmeService;

	public FilmeController(FilmeService filmeService) {
		this.filmeService = filmeService;
	}

	@Autowired
	private MapperDTO mapper;

	public FilmeDTO toFilmeDTO(Filme filme) {
		return mapper.modelMapper().map(filme, FilmeDTO.class);

	}

	public Filme toEntity(FilmeDTO filmeDTO) {
		return mapper.modelMapper().map(filmeDTO, Filme.class);

	}
	
	
	@GetMapping
	public ResponseEntity<Page<FilmeDTO>> buscarTodosFilmes(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(filmeService.listarFilmes(pageable).map(this::toFilmeDTO));
	}

	@PostMapping
	public ResponseEntity<FilmeDTO> salvarFilme(@RequestBody FilmeDTO filmedto) {

		Filme filme = filmeService.salvarFilme(toEntity(filmedto));

		return ResponseEntity.ok(toFilmeDTO(filme));

	}

	@GetMapping("{id}")
	public ResponseEntity<FilmeDTO> buscarFilmeById(@PathVariable Long id) {

		Filme filme = filmeService.findById(id);
		return ResponseEntity.ok(toFilmeDTO(filme));

	}

	@PutMapping("{id}")
	public ResponseEntity<FilmeDTO> atualizarFilme(@RequestBody FilmeDTO filmedto, @PathVariable Long id) {

		try {

			Filme filme = filmeService.atualizarFilme(toEntity(filmedto), id);

			return ResponseEntity.ok(toFilmeDTO(filme));

		} catch (RuntimeException ex) {

			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<FilmeDTO> excluirFilme(@PathVariable Long id) {
		try {
			filmeService.excluirFilme(id);
			return ResponseEntity.ok().build();

		} catch (RuntimeException ex) {

			return ResponseEntity.notFound().build();
		}
	}

}
