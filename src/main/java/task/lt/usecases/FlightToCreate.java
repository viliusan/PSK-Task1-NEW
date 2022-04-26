package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Flight;
import task.lt.interceptors.LoggedInvocation;
import task.lt.persistence.FlightsDAO;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@ViewScoped
@Named
@Getter
@Setter
public class FlightToCreate implements Serializable {
    @Inject
    private FlightsDAO flightsDAO;

    @Inject
    private FlightLogs flightLogs;

    @Getter @Setter
    private Flight flight;

    @PostConstruct
    public void init(){
        flight = new Flight();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @LoggedInvocation
    public String createFlight(){
        this.flightLogs.addFlightLog(flight);
        this.flightsDAO.persist(flight);
        return "trips?faces-redirect=true";
    }
}