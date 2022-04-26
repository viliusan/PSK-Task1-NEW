package task.lt.persistence;

import task.lt.entities.Plane;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PlanesDAO {
    @Inject
    private EntityManager em;

    public List<Plane> loadAll() {
        return em.createNamedQuery("Plane.findAllWithPilots", Plane.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Plane findOne(Integer busId){
        return this.em.find(Plane.class, busId);
    }

    public void update(Plane plane){
        this.em.merge(plane);
    }

    public void persist(Plane plane){
        this.em.persist(plane);
    }

    public void delete(Plane plane){
        this.em.remove(em.contains(plane) ? plane : em.merge(plane));
    }
}