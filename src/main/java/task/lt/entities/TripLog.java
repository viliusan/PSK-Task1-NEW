package task.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")

    private Date creationDate;

    public TripLog (Trip trip) {
        this.name = trip.getName();
        this.arrivalTime = trip.getArrivalTime();
        this.departureTime = trip.getDepartureTime();
        this.driverId = trip.getDriver().getDriverId();
        this.busId = trip.getBus().getBusId();
    }

    public TripLog () {
    }
}