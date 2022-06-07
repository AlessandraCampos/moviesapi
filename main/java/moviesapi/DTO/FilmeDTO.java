package moviesapi.DTO;



import moviesapi.Entities.Sala;

public class FilmeDTO {
	private Long id;

public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

private String nome;

public Sala getSala() {
	return sala;
}

public void setSala(Sala sala) {
	this.sala = sala;
}

private String genero;

private int classificacao;

private String data;

private String horarioInicio;

private String horarioFim;

private Sala sala;


public FilmeDTO(Long id, String nome, String genero, int classificacao, String data, String horarioInicio, String horarioFim) {
    this.id =id;
	this.nome = nome;
	this.genero = genero;
	this.classificacao = classificacao;
	this.data = data;
	this.horarioInicio = horarioInicio;
	this.horarioFim = horarioFim;
}

public FilmeDTO() {

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
