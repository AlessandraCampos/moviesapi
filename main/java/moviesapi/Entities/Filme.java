package moviesapi.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_filme")
public class Filme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String genero;

	private int classificacao;
	
    private String data;
    
    public Filme(Long id, String nome, String genero, int classificacao, String data, String horarioInicio,
			String horarioFim, Sala sala, List<Compra> compras) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.classificacao = classificacao;
		this.data = data;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.sala = sala;
		this.compras = compras;
	}

	@Column(name="horarioinicio")
	private String horarioInicio;
	
    @Column(name="horariofim")
	private String horarioFim;
	
    
    @ManyToOne
    @JoinColumn(name="sala_id", nullable=false)
	private Sala sala;
    
    @OneToMany(mappedBy ="filme")
    private List<Compra> compras;
	
	public Filme() {
		
	}

	public Filme(Long id, String nome, String genero, int classificacao, String data, String horarioInicio,
			String horarioFim, Sala sala) {
		
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.classificacao = classificacao;
		this.data = data;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.sala = sala;
	}
	


	public Sala getSala() {
		return sala;
	}

	public void setSalaId(Sala salaid) {
		this.sala = salaid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	

public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}



}
