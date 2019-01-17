package exceptions;

import Model.Stadium;
import Model.Team;

public class NoneExistingException extends Exception {

	private static final long serialVersionUID = 1L;

	private Object obj;
	
	public NoneExistingException(Object obj) {
		setObj(obj); 
	}
	
	@Override
	public String getMessage() {
		if(obj instanceof Team){
				return "Failed, Team:" +((Team)getObj()).getId() +"\n does not exist";
		}
		if(obj instanceof Stadium){
			return "Stadium:" +((Stadium)getObj()).getId() +"\n does not exist";
	}
	return null;
	}

	public Object getObj() {
		return obj;
	}
	
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
