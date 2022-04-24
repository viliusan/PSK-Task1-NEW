package task.lt.usecases;

import lombok.Getter;
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

    @Getter
    private List<Ticket> allTickets;

    public void loadTickets() {
        this.allTickets = ticketsDAO.loadAll();
    }

    @PostConstruct
    public void init(){
        this.loadTickets();
    }
}