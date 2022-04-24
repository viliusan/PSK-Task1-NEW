package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Driver;
import task.lt.persistence.DriversDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Drivers {
    @Inject
    private DriversDAO driversDAO;

    @Getter @Setter
    private Driver driverToCreate = new Driver();

    private List<Driver> allDrivers;

    @PostConstruct
    public void init(){
        loadDrivers();
    }

    public void loadDrivers() {
        this.allDrivers = driversDAO.loadAll();
    }

    public List<Driver> getAllPlayers(){
        return allDrivers;
    }

    @Transactional
    public String createDriver(){
        this.driversDAO.persist(driverToCreate);
        return "success";
    }

    /*public Driver getPlayerToCreate() {
        return driverToCreate;
    }
    public void setPlayerToCreate(Driver driverToCreate) {
        this.driverToCreate = driverToCreate;
    }*/
}