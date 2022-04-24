package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Bus;
import task.lt.entities.Driver;
import task.lt.entities.Trip;
import task.lt.persistence.TripsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Trips {
    @Inject
    private TripsDAO tripsDAO;

    @Getter @Setter
    private Bus bus;

    @Getter @Setter
    private Driver driver;

    @Getter
    private List<Trip> allTripsWithDriverBus;

    public void loadTrips() {
        this.allTripsWithDriverBus = tripsDAO.loadAll();
    }

    @PostConstruct
    public void init() {
        this.loadTrips();
    }
}