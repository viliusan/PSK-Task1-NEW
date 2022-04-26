package task.lt.persistence;

import task.lt.entities.Flight;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@ApplicationScoped
public class FlightsDAO {
    @Inject
    private EntityManager em;

    public List<Flight> loadAll() {
        return em.createNamedQuery("Flight.findAllWithPlaneAndPilot", Flight.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Flight flight){
        this.em.persist(flight);
    }

    public Flight findOne(Integer id) { return em.find(Flight.class, id); }

    public List<Flight> loadFlightsByPilotId(Integer pilotId) {
        return em.createNamedQuery("Flight.findByPilotId", Flight.class)
                .setParameter("pilotId", pilotId)
                .getResultList();
    }
}