package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Driver;
import task.lt.entities.Trip;
import task.lt.persistence.DriversDAO;
import task.lt.persistence.TripsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Drivers {
    @Inject
    private DriversDAO driversDAO;

    @Inject
    private TripsDAO tripsDAO;

    @Getter @Setter
    private Driver driverToCreate = new Driver();

    private List<Driver> allDrivers;

    @Getter @Setter
    private List<Trip> tripsById;

    @PostConstruct
    public void init(){
        loadDrivers();
    }

    public void loadDrivers() {
        this.allDrivers = driversDAO.loadAll();
    }

    public void loadTripsByDriverId(Integer driverId) {
        this.tripsById = tripsDAO.loadTripsByDriverId(driverId);
    }

    public List<Driver> getAllPlayers(){
        return allDrivers;
    }

    @Transactional
    public String createDriver(){
        this.driversDAO.persist(driverToCreate);
        return "drivers?faces-redirect=true";
    }

    @Transactional
    public String deleteDriver(Driver driver){
        this.driversDAO.delete(driver);
        return "drivers?faces-redirect=true";
    }
}