package task.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Ticket;
import task.lt.persistence.TicketsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Tickets {
    @Inject
    private TicketsDAO ticketsDAO;

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
        this.loadTickets();
        this.loadTicketsWithTrip();
    }
}