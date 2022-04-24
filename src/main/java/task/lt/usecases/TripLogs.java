package task.lt.usecases;

import task.lt.entities.Trip;
import task.lt.entities.TripLog;
import task.lt.persistence.TripLogDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class TripLogs {
    @Inject
    private TripLogDAO tripLogDAO;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void addTripLog(Trip trip) {
        TripLog tripLog = new TripLog(trip);
        tripLogDAO.persist(tripLog);
    }
}