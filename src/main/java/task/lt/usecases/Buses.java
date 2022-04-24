package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Bus;
import task.lt.persistence.BusesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Buses {
    @Inject
    private BusesDAO busesDAO;

    @Getter
    @Setter
    private Bus busToCreate = new Bus();

    @Getter
    @Setter
    private List<Bus> allbuses;

    @PostConstruct
    public void init(){
        loadBuses();
    }

    public void loadBuses() {
        this.allbuses = busesDAO.loadAll();
    }

    @Transactional
    public String createBus(){
        this.busesDAO.persist(busToCreate);
        return "buses?faces-redirect=true";
    }

    @Transactional
    public String deleteBus(Bus busToDelete){
        this.busesDAO.delete(busToDelete);
        return "buses?faces-redirect=true";
    }
}