package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Trip;
import task.lt.persistence.TripsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;

@Model
@Getter
@Setter
public class TripToCreate implements Serializable {
    @Inject
    private TripsDAO tripsDAO;

    @Getter @Setter
    private Trip trip;

    @PostConstruct
    public void init(){
        trip = new Trip();
    }

    @Transactional
    public String createTrip(){
        this.tripsDAO.persist(trip);
        return "trips?faces-redirect=true";
    }
}