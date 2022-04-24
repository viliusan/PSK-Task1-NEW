package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Bus;
import task.lt.entities.Driver;
import task.lt.persistence.BusesDAO;
import task.lt.persistence.DriversDAO;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import javax.transaction.Transactional;
import java.util.List;

@ViewScoped
@Named
public class Buses implements Serializable {
    @Inject
    private BusesDAO busesDAO;

    @Inject
    private DriversDAO driversDAO;

    @Getter
    @Setter
    private Bus busToCreate = new Bus();

    @Getter
    @Setter
    private List<Bus> allbuses;

    @Getter @Setter
    private List<Driver> driversByBus;

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
    public String assignDriverToBus(Integer driverId, Integer busId){
        Driver driver = this.driversDAO.findOne(driverId);
        if (driver == null) {
            return "false";
        }
        Bus bus = this.busesDAO.findOne(busId);
        bus.addDriver(driver);
        busesDAO.persist(bus);
        return "buses?faces-redirect=true";
    }

    @Transactional
    public String deleteBus(Bus busToDelete){
        this.busesDAO.delete(busToDelete);
        return "buses?faces-redirect=true";
    }
}