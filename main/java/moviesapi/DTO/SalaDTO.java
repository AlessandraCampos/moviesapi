package moviesapi.DTO;


public class SalaDTO {
	
	private Long id;

	public SalaDTO(int numerosala, int assentos) {
		this.numerosala = numerosala;
		this.assentos = assentos;
	}

	private int numerosala;
	
	private int assentos;
	


	public SalaDTO() {
	}

	public SalaDTO(Long id, int numerosala, int assentos) {
		this.id = id;
		this.numerosala = numerosala;
		this.assentos = assentos;
	}
	
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
