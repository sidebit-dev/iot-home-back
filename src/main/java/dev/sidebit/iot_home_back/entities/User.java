package dev.sidebit.iot_home_back.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private String name;
    private String email;
    private String passwor;
    private String phone;
    private Boolean active;
    
    public User() {    	
    }

	public User(Integer id, String name, String email, String passwor, String phone, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwor = passwor;
		this.phone = phone;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswor() {
		return passwor;
	}

	public String getPhone() {
		return phone;
	}

	public Boolean getActive() {
		return active;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPasswor(String passwor) {
		this.passwor = passwor;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
    
    
    
}
