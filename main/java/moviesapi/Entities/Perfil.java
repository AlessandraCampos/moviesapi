package moviesapi.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="tb_perfil")
public class Perfil implements GrantedAuthority{

	private static final long serialVersionUID = -5627368424076168092L;

		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private Long id;
		
		private String nome;
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		@Override
		public String getAuthority() {
			
			return getNome();
		}

	}



