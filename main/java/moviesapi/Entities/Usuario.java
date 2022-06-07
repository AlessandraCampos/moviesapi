package moviesapi.Entities;


import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="tb_usuario")
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
	return "Usuario [id=" + id + ", email=" + email + ", perfil=" + perfil + "]";
	}
	

	public Usuario() {
		
	}


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String senha;
	
	@OneToOne
	private Perfil perfil;
	
	
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
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(this.perfil);
	}
	@Override
	public String getPassword() {
	
		return this.senha;
	}
	@Override
	public String getUsername() {
		
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	@Override
	public boolean isEnabled() {
	
		return true;
	}
}