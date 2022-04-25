package task.lt.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import task.lt.mybatis.dao.TicketMapper;
import task.lt.mybatis.model.Ticket;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class TicketsMyBatis {
    @Inject
    private TicketMapper ticketMapper;

    @Getter @Setter
    private List<Ticket> allTickets;

    public void loadTrips() {
        this.allTickets = ticketMapper.selectAll();
    }

    @PostConstruct
    public void init() {
        this.loadTrips();
    }
}