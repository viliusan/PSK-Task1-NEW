package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Pilot;
import task.lt.interceptors.LoggedInvocation;
import task.lt.persistence.PilotsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class PilotToUpdate implements Serializable {
    @Inject
    private PilotsDAO pilotsDAO;

    @Getter @Setter
    private Pilot pilot;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer pilotId = Integer.parseInt(requestParameters.get("pilotId"));
        this.pilot = pilotsDAO.findOne(pilotId);
    }

    @LoggedInvocation
    @Transactional
    public String updatePilot(){
        this.pilotsDAO.update(pilot);
        return "pilots?faces-redirect=true";
    }
}