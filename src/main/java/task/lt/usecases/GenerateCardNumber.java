package task.lt.usecases;

import task.lt.interceptors.LoggedInvocation;
import task.lt.services.DriverCardNumberGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class GenerateCardNumber implements Serializable {
    @Inject
    DriverCardNumberGenerator driverCardNumberGenerator;

    private Future<Integer> driverCardNumberGenerationTask = null;

    @LoggedInvocation
    public String generateDriverCardNumber() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        driverCardNumberGenerationTask = driverCardNumberGenerator.generateDriverCardNumber();
        return  "driverToUpdate?faces-redirect=true&driverId=" + requestParameters.get("driverId");
    }

    public boolean isCardNumberGenerationRunning() {
        return driverCardNumberGenerationTask != null && !driverCardNumberGenerationTask.isDone();
    }

    public String getCardNumberGenerationStatus() throws ExecutionException, InterruptedException {
        if (driverCardNumberGenerationTask == null) {
            return null;
        } else if (isCardNumberGenerationRunning()) {
            return "Card number generation in progress. Refresh to see if number exists ";
        }
        return "Suggested card number: " + driverCardNumberGenerationTask.get() + " ";
    }
}