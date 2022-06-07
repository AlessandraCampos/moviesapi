package moviesapi.DTO;

import moviesapi.Entities.Filme;

public class CompraDTO {
	
	private Long id;
	
    private Filme filme; 

	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	private int quantidade;
	
    public CompraDTO() {
	}



	public CompraDTO(Long id, Filme filme, int quantidade) {
		super();
		this.id = id;
		this.filme = filme;
		this.quantidade = quantidade;
	}


	public CompraDTO(int quantidade) {

		this.quantidade = quantidade;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	

}
