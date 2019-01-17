package exceptions;

public class playerNotInTeamException extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public playerNotInTeamException() {
	}
	
	@Override
	public String getMessage() {
		return"Failed!\nPlayer belongs to different Team!";
	}

}
