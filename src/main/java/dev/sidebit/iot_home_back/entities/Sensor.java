package dev.sidebit.iot_home_back.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.sidebit.iot_home_back.entities.enums.SensorStatus;
import dev.sidebit.iot_home_back.entities.enums.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sensor")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private Integer sensorStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;

	private Sensor() {
	}

	public Sensor(Integer id, String name, String description, SensorStatus sensorStatus, Instant moment, 
			Ticket ticket) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.moment = moment;
		setSensorStatus(sensorStatus);
		this.ticket = ticket;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}	

	public SensorStatus getSensorStatus() {
		return SensorStatus.valueOf(sensorStatus);
	}

	public void setSensorStatus(SensorStatus sensorStatus) {
		if (sensorStatus != null) {
			this.sensorStatus = sensorStatus.getCode();
		}
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
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
		Sensor other = (Sensor) obj;
		return Objects.equals(id, other.id);
	}
}
