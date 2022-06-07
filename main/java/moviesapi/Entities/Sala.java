package moviesapi.Entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "tb_sala")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int numerosala;
	
	public Sala() {
	
	}

	public Sala(Long id) {
		super();
		this.id = id;
	}

	public Sala(Long id, int numerosala, int assentos) {
		this.id = id;
		this.numerosala = numerosala;
		this.assentos = assentos;
	}
	public Sala( int numerosala, int assentos) {
		this.numerosala = numerosala;
		this.assentos = assentos;
	}
	private int assentos;
	
	@OneToMany(mappedBy ="sala")
	private List<Filme> filmes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumerosala() {
		return numerosala;
	}

	public void setNumerosala(int numerosala) {
		this.numerosala = numerosala;
	}

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}

	
	
	
	
	
	

	

}
