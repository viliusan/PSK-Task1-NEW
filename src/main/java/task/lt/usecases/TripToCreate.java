package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Trip;
import task.lt.interceptors.LoggedInvocation;
import task.lt.persistence.TripsDAO;

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
public class TripToCreate implements Serializable {
    @Inject
    private TripsDAO tripsDAO;

    @Inject
    private TripLogs tripLogs;

    @Getter @Setter
    private Trip trip;

    @PostConstruct
    public void init(){
        trip = new Trip();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @LoggedInvocation
    public String createTrip(){
        this.tripLogs.addTripLog(trip);
        this.tripsDAO.persist(trip);
        return "trips?faces-redirect=true";
    }
}