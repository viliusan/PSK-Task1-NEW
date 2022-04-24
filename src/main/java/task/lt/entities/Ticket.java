package task.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Ticket.findAll", query = "select tck from Ticket as tck")
})
@Table(name = "ticket", schema = "public")
@Getter @Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    @Getter @Setter
    private Trip trip;

    @Column(name = "seat")
    @Getter @Setter
    private Integer seat;

    @Column(name = "price")
    @Getter @Setter
    private Double price;

    @Column(name = "is_bought")
    @Getter @Setter
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