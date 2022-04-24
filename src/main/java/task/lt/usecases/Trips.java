package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Bus;
import task.lt.entities.Driver;
import task.lt.entities.Trip;
import task.lt.persistence.BusesDAO;
import task.lt.persistence.DriversDAO;
import task.lt.persistence.TripsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class Trips {
    @Inject
    private TripsDAO tripsDAO;

    @Inject
    private DriversDAO driversDAO;

    @Inject
    private BusesDAO busesDAO;

    @Getter @Setter
    private Trip tripToCreate = new Trip();

    @Getter @Setter
    private Bus currentBus;

    @Getter @Setter
    private Bus bus;

    @Getter @Setter
    private Driver driver;

    @Getter
    private List<Trip> allTrips;

    @Getter
    private List<Trip> driverTrips;

    public void loadTrips() {
        this.allTrips = tripsDAO.loadAll();
    }

    public void loadTripsByDriver(Integer driverId){
        //tripsDAO.loadByDriverId(driverId);
        driverTrips = new ArrayList<>();
        for (Trip trip : this.allTrips) {
            if (trip.getDriver().getDriverId() == driverId){
                this.driverTrips.add(trip);
            }
        }
    }

    @PostConstruct
    public void init() {
        this.loadTrips();
    }

    @Transactional
    //@LoggedInvocation
    public String createTrip(){
        /*this.tripToCreate.setBus(this.bus);
        this.tripToCreate.setDriver(this.driver);*/
        this.tripsDAO.persist(tripToCreate);
        return "trips?faces-redirect=true";
    }
}