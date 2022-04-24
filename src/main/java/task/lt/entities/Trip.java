package task.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Trip.findAll", query = "select a from Trip as a"),
        @NamedQuery(name = "Trip.findAllWithBusAndDriver",
                query = "select tr from Trip tr left join fetch tr.bus left join fetch tr.driver"),
        @NamedQuery(name = "Trip.findByDriverId", query = "select tr from Trip as tr left join fetch tr.bus " +
                "left join fetch tr.driver where tr.driver.driverId = :driverId")
})
@Table(name = "trip", schema = "public")
@Getter @Setter
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id")
    @Getter @Setter
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    @Getter @Setter
    private Driver driver;

    @OneToMany(mappedBy = "trip")
    @Getter @Setter
    List<Ticket> tickets;

    @Size(max = 100)
    @NotBlank
    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "departure_time")
    @NotBlank
    @Getter @Setter
    private String departureTime;

    @Column(name = "arrival_time")
    @NotBlank
    @Getter @Setter
    private String arrivalTime;

    public Trip() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(id, trip.id) && Objects.equals(name, trip.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}