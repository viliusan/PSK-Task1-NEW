package task.lt.persistence;

import task.lt.entities.Pilot;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PilotsDAO {
    @Inject
    private EntityManager em;

    public List<Pilot> loadAll() {
        return em.createNamedQuery("Pilot.findAll", Pilot.class).getResultList();
    }

    public Pilot findOne(Integer id){
        return em.find(Pilot.class, id);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void delete(Pilot pilot){
        this.em.remove(em.contains(pilot) ? pilot : em.merge(pilot));
    }

    public void update(Pilot pilot) {
        this.em.merge(pilot);
    }

    public void persist(Pilot pilot){
        this.em.persist(pilot);
    }
}