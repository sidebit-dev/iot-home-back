package dev.sidebit.iot_home_back.entities.enums;

public enum SensorStatus {
	NORMAL(1),
	ALARME(2);
	
	private int code;
	
	private SensorStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static SensorStatus valueOf(int code) {
		for (SensorStatus value : SensorStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de Status inválido");
	}
}
