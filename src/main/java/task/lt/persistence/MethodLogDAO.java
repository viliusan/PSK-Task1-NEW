package task.lt.persistence;

import task.lt.entities.MethodLog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class MethodLogDAO {
    @Inject
    private EntityManager em;

    public void persist(MethodLog methodLog){
        this.em.persist(methodLog);
    }
}