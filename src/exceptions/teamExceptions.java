package exceptions;

import Model.Team;

public class teamExceptions  extends Exception {

	private static final long serialVersionUID = 1L;

	private Team team;
	
	public teamExceptions(Team team) {
		setTeam(team); 
	}
	
	@Override
	public String getMessage() {
		return "General Team Exception:\n"
		       + getTeam().getId();
	}

	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team setTeam) {
		this.team = setTeam;
	}
	
}

