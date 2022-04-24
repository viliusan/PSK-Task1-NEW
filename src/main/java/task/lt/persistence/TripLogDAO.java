package task.lt.persistence;

import task.lt.entities.TripLog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class TripLogDAO {
    @Inject
    private EntityManager em;

    public void persist(TripLog tripLog){
        this.em.persist(tripLog);
    }
}