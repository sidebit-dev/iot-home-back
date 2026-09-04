package dev.sidebit.iot_home_back.entities.enums;

public enum UserRole {
	ADMIN(1),
	CLIENTE(2);
	
	private int code;
	
	private UserRole(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static UserRole valueOf(int code) {
		for (UserRole value : UserRole.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Tipo de usuário inválido");
	}
}
