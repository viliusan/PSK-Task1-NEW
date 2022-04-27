package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Plane;
import task.lt.entities.Pilot;
import task.lt.interceptors.LoggedInvocation;
import task.lt.persistence.PlanesDAO;
import task.lt.persistence.PilotsDAO;
import task.lt.services.PlaneNumberCheckerService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class Planes implements Serializable {
    @Inject
    private PlanesDAO planesDAO;

    @Inject
    private PilotsDAO pilotsDAO;

    @Inject
    private PlaneNumberCheckerService planeNumberChecker;

    @Getter
    @Setter
    private Plane planeToCreate = new Plane();

    @Getter
    @Setter
    private List<Plane> allPlanes;

    @Getter @Setter
    private List<Pilot> pilotsByPlanes;

    @PostConstruct
    public void init(){
        loadPlanes();
    }

    public void loadPlanes() {
        this.allPlanes = planesDAO.loadAll();
    }

    /*public String getAllDriversAsString(Bus bus){
        String driversList = "";
        int index = allbuses.indexOf(bus);
        Bus currentBus = allbuses.get(index);
        for (Driver driver: currentBus.getDrivers()) {
            driversList += driver.getDriverId().toString() + ";";
        }
        return driversList;
    }*/

    @Transactional
    @LoggedInvocation
    public String createPlane(){
        if (!planeNumberChecker.checkPlaneNumber(planeToCreate.getPlaneNumber())){
            return "Plane number doesn't pass validation";
        }
        this.planesDAO.persist(planeToCreate);
        return "planes?faces-redirect=true";
    }

    @Transactional
    @LoggedInvocation
    public String assignPilotToPlane(Integer pilotId, Integer planeId){
        Pilot pilot = this.pilotsDAO.findOne(pilotId);
        if (pilot == null) {
            return "false";
        }
        Plane plane = this.planesDAO.findOne(planeId);
        plane.addPilot(pilot);
        planesDAO.persist(plane);
        System.out.println(plane.getPilots().size());
        return "planes?faces-redirect=true";
    }

    @Transactional
    @LoggedInvocation
    public String deletePlane(Plane planeToDelete){
        this.planesDAO.delete(planeToDelete);
        return "planes?faces-redirect=true";
    }
}