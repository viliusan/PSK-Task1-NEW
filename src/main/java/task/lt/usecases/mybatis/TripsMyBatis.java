package task.lt.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import task.lt.mybatis.dao.TripMapper;
import task.lt.mybatis.model.Bus;
import task.lt.mybatis.model.Driver;
import task.lt.mybatis.model.Ticket;
import task.lt.mybatis.model.Trip;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class TripsMyBatis implements Serializable {
    @Inject
    private TripMapper tripMapper;

    @Getter @Setter
    private Bus bus;

    @Getter @Setter
    private Driver driver;

    @Getter @Setter
    private List<Trip> allTrips;

    @Getter @Setter
    private List<Ticket> ticketsByTripId;

    public void loadTrips() {
        this.allTrips = tripMapper.selectAll();
    }

    public void loadTicketsByTripId(Integer tripId) {
        //possible to get it from allTrips
        this.ticketsByTripId = tripMapper.selectTicketsByTripId(tripId);
    }

    @PostConstruct
    public void init() {
        this.loadTrips();
    }
}