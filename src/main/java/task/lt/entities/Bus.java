package task.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Bus.findAll", query = "select a from Bus as a")
})
@Table(name = "bus", schema = "public")
@Getter @Setter
public class Bus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    @Getter @Setter
    private Integer busId;

    @Size(max = 6)
    @NotNull
    @Column(name = "plate_number", unique=true)
    @Getter @Setter
    private String plateNumber;

    @Column(name = "current_fuel")
    @Getter @Setter
    private Integer currentFuel;

    @OneToMany(mappedBy = "bus")
    @Getter @Setter
    List<Trip> trips;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return plateNumber.equals(bus.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber);
    }
}