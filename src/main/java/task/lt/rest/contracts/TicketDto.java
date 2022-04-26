package task.lt.rest.contracts;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TicketDto {
    @NotNull
    private Integer seat;

    private Double price;

    private Boolean bought;

    private String FlightName;
}