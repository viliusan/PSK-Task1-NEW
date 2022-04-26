package task.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Setter @Getter
@Table(name="flight_log")
public class FlightLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "plane_id")
    private Integer planeId;

    @Column(name = "pilot_id")
    private Integer pilotId;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public FlightLog() {
    }

    public FlightLog(Flight flight) {
        this.name = flight.getName();
        this.arrivalTime = flight.getArrivalTime();
        this.departureTime = flight.getDepartureTime();
        this.pilotId = flight.getPilot().getPilotId();
        this.planeId = flight.getPlane().getPlaneId();
        this.creationDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightLog flightLog = (FlightLog) o;
        return Objects.equals(id, flightLog.id) && Objects.equals(name, flightLog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}