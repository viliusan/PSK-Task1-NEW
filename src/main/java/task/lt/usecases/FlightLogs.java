package task.lt.usecases;

import task.lt.entities.Flight;
import task.lt.entities.FlightLog;
import task.lt.interceptors.LoggedInvocation;
import task.lt.persistence.FlightLogDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class FlightLogs {
    @Inject
    private FlightLogDAO flightLogDAO;

    @LoggedInvocation
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void addFlightLog(Flight flight) {
        FlightLog flightLog = new FlightLog(flight);
        flightLogDAO.persist(flightLog);
    }
}