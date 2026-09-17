package dev.sidebit.iot_home_back.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sidebit.iot_home_back.entities.enums.SensorStatus;
import dev.sidebit.iot_home_back.entities.enums.TicketStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_sensor")
public class Sensor implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String name;
    private String description;
    private Integer sensorStatus;
	private Boolean active;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private Ticket service;

    public Sensor(){
	}

	public Sensor(Integer id, String name, String description, SensorStatus sensorStatus, Boolean active, Instant moment, Ticket service) {
		this.id = id;
		this.name = name;
		this.description = description;
		setSensorStatus(sensorStatus);
		this.active = active;
		this.moment = moment;
		this.service = service;
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

	public SensorStatus getSensorStatus() {
		return SensorStatus.valueOf(sensorStatus);
	}

	public void setSensorStatus(SensorStatus sensorStatus) {
		if(sensorStatus != null) {
			this.sensorStatus = sensorStatus.getCode();
		}
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Ticket getService() {
		return service;
	}

	public void setService(Ticket service) {
		this.service = service;
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
