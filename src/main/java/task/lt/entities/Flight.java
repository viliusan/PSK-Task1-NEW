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
        @NamedQuery(name = "Flight.findAll", query = "select a from Flight as a"),
        @NamedQuery(name = "Flight.findAllWithPlaneAndPilot",
                query = "select fl from Flight fl left join fetch fl.plane left join fetch fl.pilot"),
        @NamedQuery(name = "Flight.findByPilotId", query = "select fl from Flight as fl left join fetch fl.plane " +
                "left join fetch fl.pilot where fl.pilot.pilotId = :pilotId")
})
@Table(name = "flight", schema = "public")
@Getter @Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pilot_id")
    private Pilot pilot;

    @OneToMany(mappedBy = "flight")
    List<Ticket> tickets;

    @Size(max = 100)
    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "departure_time")
    @NotBlank
    private String departureTime;

    @Column(name = "arrival_time")
    @NotBlank
    private String arrivalTime;

    public Flight() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(name, flight.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}