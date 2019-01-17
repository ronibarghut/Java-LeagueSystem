package exceptions;

import Model.Team;

public class existingTeamException extends teamExceptions {

	private static final long serialVersionUID = 1L;
	
	public existingTeamException(Team team) {
		super(team);
	}
	
	@Override
	public String getMessage() {
		return "Failed, Team:\n"
		+ super.getTeam().getId()	
        + "\n already exists!";
	}

}
