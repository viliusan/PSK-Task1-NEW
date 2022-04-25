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
@Table(name = "driver", schema = "public",
        uniqueConstraints={@UniqueConstraint(columnNames = {"name", "surname", "cell_phone"})}
)
@Getter @Setter
public class Driver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Integer driverId;

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

    @OneToMany(mappedBy = "driver")
    private List<Trip> trips;

    @ManyToMany(mappedBy="drivers")
    private List<Bus> buses = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name) && Objects.equals(surname, driver.surname) && Objects.equals(cellPhone, driver.cellPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, cellPhone);
    }
}