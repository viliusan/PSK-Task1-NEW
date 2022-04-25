package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Ticket;
import task.lt.interceptors.LoggedInvocation;
import task.lt.persistence.TicketsDAO;
import task.lt.services.TicketNumberGenerator;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class Tickets implements Serializable {
    @Inject
    private TicketsDAO ticketsDAO;

    @Inject
    private TicketNumberGenerator ticketNumberGenerator;

    @Getter @Setter
    private Ticket ticketToCreate = new Ticket();

    @Getter @Setter
    private List<Ticket> allTickets;

    @Getter @Setter
    private List<Ticket> allTicketsWithTrip;

    public void loadTickets() {
        this.allTickets = ticketsDAO.loadAll();
    }

    public void loadTicketsWithTrip() {
        this.allTicketsWithTrip = ticketsDAO.loadAllWithTrip();
    }

    @PostConstruct
    public void init(){
        this.loadTicketsWithTrip();
    }

    @Transactional
    @LoggedInvocation
    public String createTicket(){
        ticketToCreate.setTicketNumber(ticketNumberGenerator.generateTicketNumber(200));
        this.ticketsDAO.persist(ticketToCreate);
        return "ticket?faces-redirect=true";
    }
}