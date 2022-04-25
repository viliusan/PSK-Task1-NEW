package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;
import task.lt.entities.Ticket;
import task.lt.persistence.TicketsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.IOException;
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

    /*@Transactional
    public void updateTicketWithoutAsking() {
        try {
            ticketsDAO.update(this.ticket);
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("ticket.xhtml?faces-redirect=true" + "&info=success");
        } catch (OptimisticLockException e) {
            updateTicketAfterLock();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @Transactional
    public void updateTicket() {
        try {
            ticketsDAO.update(this.ticket);
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("ticket.xhtml?faces-redirect=true&info=success");
        } catch (OptimisticLockException e) {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('confirmDialog').show();");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String updateTicketAfterLock() {
        Ticket ticket = ticketsDAO.findOne(this.ticket.getId());
        ticket.setIsBought(this.ticket.getIsBought());
        ticket.setPrice(this.ticket.getPrice());
        ticket.setSeat(this.ticket.getSeat());
        ticketsDAO.update(ticket);

        return "ticket?faces-redirect=true" + "&info=success";
    }
}