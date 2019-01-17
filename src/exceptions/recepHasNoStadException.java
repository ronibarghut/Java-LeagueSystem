package exceptions;

public class recepHasNoStadException extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public recepHasNoStadException() {
	}
	
	@Override
	public String getMessage() {
		return"Failed!\nReceptionist does not belong to any Stadium!";
	}

}
