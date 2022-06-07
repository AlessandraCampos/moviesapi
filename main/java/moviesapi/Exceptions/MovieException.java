package moviesapi.Exceptions;

public class MovieException extends RuntimeException{

	private static final long serialVersionUID = -842933078036407119L;
	
	private String message;

	public MovieException(String message) {
		this.message = message;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
