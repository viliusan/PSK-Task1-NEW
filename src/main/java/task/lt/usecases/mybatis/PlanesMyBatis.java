package task.lt.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import task.lt.mybatis.dao.PlaneMapper;
import task.lt.mybatis.dao.PilotPlaneMapper;
import task.lt.mybatis.dao.PilotMapper;
import task.lt.mybatis.model.Plane;
import task.lt.mybatis.model.Pilot;
import task.lt.mybatis.model.PilotPlane;
import task.lt.mybatis.model.Ticket;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class PlanesMyBatis implements Serializable {
    @Inject
    private PlaneMapper planeMapper;

    @Inject
    private PilotMapper pilotMapper;

    @Inject
    private PilotPlaneMapper pilotPlaneMapper;

    @Getter@Setter
    private List<Plane> allPlanes;

    @Getter @Setter
    private List<Pilot> currentPlanePilots;

    @Getter @Setter
    private List<Ticket> ticketsByFlightId;

    public void loadPilots() {
        this.allPlanes = planeMapper.selectAllWithFlights();
    }

    @PostConstruct
    public void init() {
        this.loadPilots();
    }

    @Transactional
    public String deletePlane(Integer planeId) {
        planeMapper.deleteByPrimaryKey(planeId);
        return "/mybatis/planes?faces-redirect=true";
    }

    @Transactional
    public String assignPilotToPlane(Integer planeId, Integer pilotId) {
        Pilot pilot = this.pilotMapper.selectByPrimaryKey(pilotId);
        if (pilot == null) {
            return "false";
        }
        PilotPlane pilotPlane = new PilotPlane();
        pilotPlane.setPilotId(pilotId);
        pilotPlane.setPlaneId(planeId);
        pilotPlaneMapper.insert(pilotPlane);
        return "/mybatis/planes?faces-redirect=true";
    }

    public void loadPilotsById(Integer planeId){
        for (Plane plane:allPlanes) {
            if (plane.getPlaneId().equals(planeId)){
                this.currentPlanePilots = plane.getPilots();
            }
        }
    }
}