package dev.sidebit.iot_home_back.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sidebit.iot_home_back.entities.enums.TicketStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_ticket")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String name;
    private String description;
    private String address;
    private Integer ticketStatus;
	private Boolean active;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	@OneToMany(mappedBy = "service")
	private List<Sensor> sensors = new ArrayList<>();

    public Ticket(){
	}

	public Ticket(Integer id, String name, String description, String address, TicketStatus ticketStatus, Boolean active, Instant moment, User client) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		setTicketStatus(ticketStatus);
		this.active = active;
		this.moment = moment;
		this.client = client;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TicketStatus getTicketStatus() {
		return TicketStatus.valueOf(ticketStatus);
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		if(ticketStatus != null) {
			this.ticketStatus = ticketStatus.getCode();
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

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
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
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", address='" + address + '\'' +
				", ticketStatus=" + ticketStatus +
				", active=" + active +
				", moment=" + moment +
				", client=" + client +
				", sensors=" + sensors +
				'}';
	}
}
