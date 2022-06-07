package moviesapi.DTO;
import moviesapi.Entities.Perfil;

public class UsuarioDTO {
	
	private Long id;
	
	private String email;
	
	private String senha;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Long id, String email, String senha, Perfil perfil) {
	
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	private Perfil perfil;
	

}
