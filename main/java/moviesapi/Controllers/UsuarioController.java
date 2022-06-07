package moviesapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import moviesapi.DTO.MapperDTO;
import moviesapi.DTO.UsuarioDTO;
import moviesapi.Entities.Usuario;
import moviesapi.Services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@Autowired
	private MapperDTO mapper;
	
	public UsuarioDTO toUsuarioDTO(Usuario usuario) {
		return mapper.modelMapper().map(usuario, UsuarioDTO.class);
		
	}
	public Usuario toEntity(UsuarioDTO usuarioDTO) {
		return mapper.modelMapper().map(usuarioDTO, Usuario.class);
		
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDto){
			
			Usuario usuario = usuarioService.salvarUsuario(toEntity(usuarioDto));
			
			return ResponseEntity.ok(toUsuarioDTO(usuario));
			
	}
	

}
