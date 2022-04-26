package task.lt.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import task.lt.mybatis.dao.FlightMapper;
import task.lt.mybatis.model.Plane;
import task.lt.mybatis.model.Pilot;
import task.lt.mybatis.model.Ticket;
import task.lt.mybatis.model.Flight;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class FlightsMyBatis implements Serializable {
    @Inject
    private FlightMapper flightMapper;

    @Getter @Setter
    private Plane plane;

    @Getter @Setter
    private Pilot pilot;

    @Getter @Setter
    private List<Flight> allFlights;

    @Getter @Setter
    private List<Ticket> ticketsByFlightId;

    public void loadFlights() {
        //to select without tickets
        this.allFlights = flightMapper.selectAll();
        //to select with tickets
        //this.allTrips = tripMapper.selectTripsWithTickets();
    }

    public void loadTicketsByFlightId(Integer flightId) {
        //possible to get it from allTrips if fetched with tickets
        this.ticketsByFlightId = flightMapper.selectTicketsByFlightId(flightId);
    }

    @PostConstruct
    public void init() {
        this.loadFlights();
    }
}