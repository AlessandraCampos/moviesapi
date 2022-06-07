package moviesapi.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moviesapi.DTO.CompraDTO;
import moviesapi.DTO.MapperDTO;
import moviesapi.Entities.Compra;
import moviesapi.Entities.Filme;
import moviesapi.Entities.Sala;
import moviesapi.Services.CompraService;
import moviesapi.Services.FilmeService;
import moviesapi.Services.SalaService;

@RestController
@RequestMapping("/compras")
public class CompraController {

	private CompraService compraService;
	private FilmeService filmeService;
	private SalaService salaService;

	@Autowired
	private MapperDTO mapper;

	public CompraController(CompraService compraService, FilmeService filmeService, SalaService salaService) {
		this.compraService = compraService;
		this.filmeService = filmeService;
		this.salaService = salaService;

	}

	public CompraDTO toCompraDTO(Compra compra) {
		return mapper.modelMapper().map(compra, CompraDTO.class);
	}

	public Compra toEntity(CompraDTO compraDTO) {
		return mapper.modelMapper().map(compraDTO, Compra.class);
	}

	@GetMapping
	public ResponseEntity<List<CompraDTO>> listarCompras() {

		return ResponseEntity
				.ok(compraService.listarCompras().stream().map(this::toCompraDTO).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<CompraDTO> registrarCompra(@RequestBody CompraDTO compraDTO) {

		Compra compra = compraService.novaCompra(toEntity(compraDTO));
		Filme filmeid = filmeService.findById(compra.getFilme().getId());
		Sala salaId = salaService.salaPorId(filmeid.getSala().getId());
		compra.setQuantidade(salaService.controleAssentos(salaId.getId(), compra.getQuantidade()));

		return ResponseEntity.ok(toCompraDTO(compra));
	}

	@GetMapping("{id}")
	public ResponseEntity<CompraDTO> buscarCompraById(@PathVariable Long id) {

		Compra compra = compraService.findById(id);
		return ResponseEntity.ok(toCompraDTO(compra));

	}

}
