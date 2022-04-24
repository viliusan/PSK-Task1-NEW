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
        @NamedQuery(name = "Driver.findAll", query = "select a from Driver as a"),
})
@Table(name = "driver", schema = "public")
@Getter @Setter
public class Driver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    @Getter @Setter
    private Integer driverId;

    @Size(max = 50)
    @NotBlank
    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Size(max = 50)
    @Column(name = "surname")
    @NotBlank
    @Getter @Setter
    private String surname;

    @Size(max = 20)
    @Column(name = "cell_phone")
    @Getter @Setter
    private String cellPhone;

    @OneToMany(mappedBy = "driver")
    @Getter @Setter
    private List<Trip> trips;

    @ManyToMany(mappedBy="drivers")
    @Getter @Setter
    private List<Bus> buses = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name) && Objects.equals(surname, driver.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}