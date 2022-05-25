package task.lt.usecases;

import task.lt.interceptors.LoggedInvocation;
import task.lt.services.PilotCardNumberGenerator;

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
    PilotCardNumberGenerator pilotCardNumberGenerator;

    private Future<Integer> pilotCardNumberGenerationTask = null;

    @LoggedInvocation
    public String generatePilotCardNumber() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        pilotCardNumberGenerationTask = pilotCardNumberGenerator.generatePilotCardNumber();
        return  "pilotToUpdate?faces-redirect=true&pilotId=" + requestParameters.get("pilotId");
    }

    public boolean isCardNumberGenerationRunning() {
        return pilotCardNumberGenerationTask != null && !pilotCardNumberGenerationTask.isDone();
    }

    public String getCardNumberGenerationStatus() throws ExecutionException, InterruptedException {
        if (pilotCardNumberGenerationTask == null) {
            return null;
        } else if (isCardNumberGenerationRunning()) {
            return "Card number generation in progress. Refresh to see if number exists ";
        }
        return "Suggested card number: " + pilotCardNumberGenerationTask.get() + " ";
    }
}