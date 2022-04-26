package task.lt.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import task.lt.mybatis.dao.PilotPlaneMapper;
import task.lt.mybatis.dao.PilotMapper;
import task.lt.mybatis.model.Pilot;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class PilotsMyBatis {
    @Inject
    private PilotMapper pilotMapper;

    @Inject
    private PilotPlaneMapper pilotPlaneMapper;

    @Getter
    @Setter
    private List<Pilot> allPilots;

    @Getter
    @Setter
    private Pilot pilotToCreate = new Pilot();

    public void loadPilots() {
        this.allPilots = pilotMapper.selectAllWithFlights();
    }

    @PostConstruct
    public void init() {
        this.loadPilots();
    }

    @Transactional
    public String deletePilot(Integer pilotId) {
        pilotPlaneMapper.deleteByPilotId(pilotId);
        pilotMapper.deleteByPrimaryKey(pilotId);
        return "/mybatis/pilots?faces-redirect=true";
    }

    @Transactional
    public String createPilot() {
        pilotMapper.insert(pilotToCreate);
        return "/mybatis/pilots?faces-redirect=true";
    }
}