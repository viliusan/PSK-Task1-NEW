package task.lt.persistence;

import task.lt.entities.Trip;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@ApplicationScoped
public class TripsDAO {
    @Inject
    private EntityManager em;

    public List<Trip> loadAll() {
        return em.createNamedQuery("Trip.findAllWithBusAndDriver", Trip.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Trip trip){
        this.em.persist(trip);
    }

    public Trip findOne(Integer id) { return em.find(Trip.class, id); }

    public List<Trip> loadTripsByDriverId(Integer driverId) {
        return em.createNamedQuery("Trip.findByDriverId", Trip.class)
                .setParameter("driverId", driverId)
                .getResultList();
    }
}