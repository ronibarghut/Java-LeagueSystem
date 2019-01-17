package exceptions;

public class recepAlreadyInStad extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public recepAlreadyInStad() {
	}
	
	@Override
	public String getMessage() {
		return"Failed!\nReceptionist is already in this Stadium!";
	}

}
