package moviesapi.Exceptions;

public class EntityNotFoundException extends MovieException{

	private static final long serialVersionUID = -472522611916652019L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
