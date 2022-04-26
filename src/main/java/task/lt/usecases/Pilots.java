package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Flight;
import task.lt.entities.Pilot;
import task.lt.interceptors.LoggedInvocation;
import task.lt.persistence.PilotsDAO;
import task.lt.persistence.FlightsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Pilots {
    @Inject
    private PilotsDAO pilotsDAO;

    @Inject
    private FlightsDAO flightsDAO;

    @Getter @Setter
    private Pilot pilotToCreate = new Pilot();

    @Getter @Setter
    private List<Pilot> allPilots;

    @Getter @Setter
    private List<Flight> flightsById;

    @PostConstruct
    public void init(){
        loadPilots();
    }

    public void loadPilots() {
        this.allPilots = pilotsDAO.loadAll();
    }

    public void loadFlightsByPilotId(Integer pilotId) {
        this.flightsById = flightsDAO.loadFlightsByPilotId(pilotId);
    }

    @Transactional
    @LoggedInvocation
    public String createPilot(){
        this.pilotsDAO.persist(pilotToCreate);
        return "pilots?faces-redirect=true";
    }

    @Transactional
    @LoggedInvocation
    public String deletePilot(Pilot pilot){
        this.pilotsDAO.delete(pilot);
        return "pilots?faces-redirect=true";
    }
}