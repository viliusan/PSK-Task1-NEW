package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Flight;
import task.lt.entities.Plane;
import task.lt.entities.Pilot;
import task.lt.persistence.FlightsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Flights {
    @Inject
    private FlightsDAO flightsDAO;

    @Getter @Setter
    private Plane plane;

    @Getter @Setter
    private Pilot pilot;

    @Getter @Setter
    private List<Flight> allFlightsWithPilotPlanes;

    public void loadFlights() {
        this.allFlightsWithPilotPlanes = flightsDAO.loadAll();
    }

    @PostConstruct
    public void init() {
        this.loadFlights();
    }
}