package Model;

import java.io.Serializable;

import utils.TypeOfUser;

public class User implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String pas;
	private TypeOfUser typ;
	
	public User(String username, String password, TypeOfUser type) {
		this.user = username;
		this.pas = password;
		this.typ = type;
	}
	
	public User(String username, String password) {
		this.user = username;
		this.pas = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPas() {
		return pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	public TypeOfUser getType() {
		return typ;
	}

	public void setType(TypeOfUser typ) {
		this.typ = typ;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pas == null) ? 0 : pas.hashCode());
		result = prime * result + ((typ == null) ? 0 : typ.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (pas == null) {
			if (other.pas != null)
				return false;
		} else if (!pas.equals(other.pas))
			return false;
		if (typ != other.typ)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
}
