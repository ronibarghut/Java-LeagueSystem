package exceptions;

public class favTeamException extends Exception {
private static final long serialVersionUID = 1L;
	
	
	public favTeamException() {
	}
	
	@Override
	public String getMessage() {
		return "No favourite team choosen or Does not exist!";
	}

}
