package task.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Ticket.findAll", query = "select tck from Ticket as tck"),
        @NamedQuery(name = "Ticket.findAllWithTrips",
                query = "select tck from Ticket tck left join fetch tck.trip")
})
@Table(name = "ticket", schema = "public")
@Getter @Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "seat")
    @NotBlank
    private Integer seat;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_bought")
    private boolean isBought;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(seat, ticket.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seat);
    }
}