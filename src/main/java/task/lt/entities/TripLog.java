package task.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Setter @Getter
@Table(name="trip_log")
public class TripLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "bus_id")
    private Integer busId;

    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public TripLog () {
    }

    public TripLog (Trip trip) {
        this.name = trip.getName();
        this.arrivalTime = trip.getArrivalTime();
        this.departureTime = trip.getDepartureTime();
        this.driverId = trip.getDriver().getDriverId();
        this.busId = trip.getBus().getBusId();
        this.creationDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripLog tripLog = (TripLog) o;
        return Objects.equals(id, tripLog.id) && Objects.equals(name, tripLog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}