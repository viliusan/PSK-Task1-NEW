package task.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Plane.findAll", query = "select a from Plane as a"),
        @NamedQuery(name = "Plane.findAllWithPilots", query = "select distinct plane from Plane plane left join fetch plane.pilots")
})
@Table(name = "plane", schema = "public")
@Getter @Setter
public class Plane implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plane_id")
    private Integer planeId;

    @Size(max = 6)
    @NotBlank
    @Column(name = "plane_number", unique=true)
    private String planeNumber;

    @Column(name = "current_fuel")
    private Integer currentFuel;

    @OneToMany(mappedBy = "plane")
    private List<Flight> flights;

    @ManyToMany
    @JoinTable(name= "pilot_plane",
            joinColumns = @JoinColumn(name = "plane_id"),
            inverseJoinColumns = @JoinColumn(name = "pilot_id"))
    private List<Pilot> pilots = new ArrayList<>();

    public void addPilot(Pilot pilot){
        pilots.add(pilot);
    }

    public void removePilot(Pilot pilot){
        pilots.remove(pilot);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return planeNumber.equals(plane.planeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeNumber);
    }
}