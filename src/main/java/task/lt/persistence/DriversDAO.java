package task.lt.persistence;

import task.lt.entities.Driver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class DriversDAO {
    @Inject
    private EntityManager em;

    public List<Driver> loadAll() {
        return em.createNamedQuery("Driver.findAll", Driver.class).getResultList();
    }

    public Driver findOne(Integer id){
        return em.find(Driver.class, id);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void delete(Driver driver){
        this.em.remove(driver);
    }

    public void update(Driver driver) {
        this.em.merge(driver);
    }

    public void persist(Driver driver){
        this.em.persist(driver);
    }
}