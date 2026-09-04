package dev.sidebit.iot_home_back.entities.enums;

public enum TicketStatus {
	PENDENTE(1),
	ANDAMENTO(2),
	CONCLUIDO(3);
	
	private int code;
	
	private TicketStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TicketStatus valueOf(int code) {
		for (TicketStatus value : TicketStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de Status inválido");
	}
}
