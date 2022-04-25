package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Ticket;
import task.lt.persistence.TicketsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class TicketToUpdate implements Serializable {
    @Inject
    private TicketsDAO ticketsDAO;

    @Getter @Setter
    private Ticket ticket;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer ticketId = Integer.parseInt(requestParameters.get("ticketId"));
        this.ticket = ticketsDAO.findOne(ticketId);
    }

    @Transactional
    public String updateTicket() {
        try {
            ticketsDAO.update(this.ticket);
        } catch (OptimisticLockException e) {
            return "ticketToUpdate?faces-redirect=true&ticketId=" + this.ticket.getId() + "&error=optimistic-lock-exception";
        }
        return "ticket?faces-redirect=true";
    }
}