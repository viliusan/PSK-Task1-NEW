package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Driver;
import task.lt.interceptors.LoggedInvocation;
import task.lt.persistence.DriversDAO;

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
public class DriverToUpdate implements Serializable {
    @Inject
    private DriversDAO driversDAO;

    @Getter @Setter
    private Driver driver;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer driverId = Integer.parseInt(requestParameters.get("driverId"));
        this.driver = driversDAO.findOne(driverId);
    }

    @LoggedInvocation
    @Transactional
    public String updateDriver(){
        this.driversDAO.update(driver);
        return "drivers?faces-redirect=true";
    }
}