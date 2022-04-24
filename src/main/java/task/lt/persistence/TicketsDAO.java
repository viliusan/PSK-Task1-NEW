package task.lt.persistence;

import task.lt.entities.Ticket;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TicketsDAO {
    @Inject
    private EntityManager em;

    public List<Ticket> loadAll() {
        System.out.println("Loading only tickets: ");
        return em.createNamedQuery("Ticket.findAll", Ticket.class).getResultList();
    }

    public List<Ticket> loadAllWithTrip() {
        System.out.println("Loading tickets with trips: ");
        return em.createNamedQuery("Ticket.findAllWithTrips", Ticket.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Ticket ticket){
        this.em.persist(ticket);
    }
}