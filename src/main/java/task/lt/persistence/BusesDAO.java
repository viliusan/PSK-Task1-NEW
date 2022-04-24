package task.lt.persistence;

import task.lt.entities.Bus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BusesDAO {
    @Inject
    private EntityManager em;

    public List<Bus> loadAll() {
        return em.createNamedQuery("Bus.findAll", Bus.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Bus bus){
        this.em.persist(bus);
    }

    public void delete(Bus bus){
        this.em.remove(bus);
    }
}