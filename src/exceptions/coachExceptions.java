package exceptions;

import Model.Coach;
import Model.Player;

public class coachExceptions extends Exception {

	private static final long serialVersionUID = 1L;

	private Object obj;
	
	public coachExceptions(Object coach) {
		setObject(coach); 
	}
	
	@Override
	public String getMessage() {
		if(obj instanceof Coach){
		return "General coach Exception:\n"
		       + ((Coach) getObject()).getId();
		}
		if(obj instanceof Player){
			return "General Player Exception:\n"
			       + ((Player) getObject()).getId();
			}
		return null;
	}

	public Object getObject() {
		return obj;
	}
	
	public void setObject(Object coach) {
		this.obj = coach;
	}
	
}
