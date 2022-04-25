package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Bus;
import task.lt.entities.Driver;
import task.lt.interceptors.LoggedInvocation;
import task.lt.persistence.BusesDAO;
import task.lt.persistence.DriversDAO;
import task.lt.services.PlateNumberChecker;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class Buses implements Serializable {
    @Inject
    private BusesDAO busesDAO;

    @Inject
    private DriversDAO driversDAO;

    @Inject
    private PlateNumberChecker plateNumberChecker;

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

    /*public String getAllDriversAsString(Bus bus){
        String driversList = "";
        int index = allbuses.indexOf(bus);
        Bus currentBus = allbuses.get(index);
        for (Driver driver: currentBus.getDrivers()) {
            driversList += driver.getDriverId().toString() + ";";
        }
        return driversList;
    }*/

    @Transactional
    @LoggedInvocation
    public String createBus(){
        if (!plateNumberChecker.checkPlateNumber(busToCreate.getPlateNumber())){
            return "Plate number doesn't pass validation";
        }
        this.busesDAO.persist(busToCreate);
        return "buses?faces-redirect=true";
    }

    @Transactional
    @LoggedInvocation
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
    @LoggedInvocation
    public String deleteBus(Bus busToDelete){
        this.busesDAO.delete(busToDelete);
        return "buses?faces-redirect=true";
    }
}