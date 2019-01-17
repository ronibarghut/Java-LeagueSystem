package exceptions;

public class playerAlreadyInTeamException  extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public playerAlreadyInTeamException() {
	}
	
	@Override
	public String getMessage() {
		return"Failed!\nPlayer is already part of this Team!";
	}

}
