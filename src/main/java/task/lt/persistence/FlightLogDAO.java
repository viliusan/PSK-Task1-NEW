package task.lt.persistence;

import task.lt.entities.FlightLog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class FlightLogDAO {
    @Inject
    private EntityManager em;

    public void persist(FlightLog flightLog){
        this.em.persist(flightLog);
    }
}