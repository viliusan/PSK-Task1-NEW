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
        @NamedQuery(name = "Pilot.findAll", query = "select a from Pilot as a"),
})
@Table(name = "pilot", schema = "public",
        uniqueConstraints={@UniqueConstraint(columnNames = {"name", "surname", "cell_phone"})}
)
@Getter @Setter
public class Pilot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pilot_id")
    private Integer pilotId;

    @Size(max = 50)
    @Column(name = "name")
    @NotBlank
    private String name;

    @Size(max = 50)
    @Column(name = "surname")
    @NotBlank
    private String surname;

    @Size(max = 20)
    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "card_number")
    private Integer cardNumber;

    @OneToMany(mappedBy = "pilot")
    private List<Flight> flights;

    @ManyToMany(mappedBy="pilots")
    private List<Plane> planes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return Objects.equals(name, pilot.name) && Objects.equals(surname, pilot.surname) && Objects.equals(cellPhone, pilot.cellPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, cellPhone);
    }
}