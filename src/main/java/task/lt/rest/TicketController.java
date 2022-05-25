package task.lt.rest;

import lombok.Getter;
import lombok.Setter;
import task.lt.entities.Ticket;
import task.lt.persistence.TicketsDAO;
import task.lt.rest.contracts.TicketDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("tickets")
public class TicketController {
    @Inject
    @Setter @Getter
    private TicketsDAO ticketsDAO;

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketById(@PathParam("id") final Integer id) {
        Ticket ticket = ticketsDAO.findOne(id);
        if (ticket == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(ticket).build();
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer ticketId, @Valid TicketDto ticket) {
        Ticket ticketToUpdate = ticketsDAO.findOne(ticketId);
        if (ticketToUpdate == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        ticketToUpdate.setIsBought(ticket.getBought());
        ticketToUpdate.setSeat(ticket.getSeat());
        ticketToUpdate.setPrice(ticket.getPrice());
        ticketsDAO.update(ticketToUpdate);
        return Response.ok(ticketToUpdate).build();
    }

    /*
    {
        "seat":"130",
        "price":"130",
        "bought":true
    }
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response post(@Valid TicketDto ticket) {
        Ticket ticketToPost = new Ticket();
        ticketToPost.setIsBought(ticket.getBought());
        ticketToPost.setSeat(ticket.getSeat());
        ticketToPost.setPrice(ticket.getPrice());
        ticketsDAO.persist(ticketToPost);
        return Response.ok(ticketToPost).build();
    }
}