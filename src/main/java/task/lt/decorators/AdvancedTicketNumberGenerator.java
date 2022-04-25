package task.lt.decorators;

import task.lt.services.TicketNumber;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class AdvancedTicketNumberGenerator implements TicketNumber {
    @Inject
    @Delegate
    @Any
    TicketNumber ticketNumber;

    public Integer generateTicketNumber(Integer bound) {
        Integer number = ticketNumber.generateTicketNumber(bound);
        System.out.println("Generated number before decoration: " + number);
        if (number < 100){
            number = ticketNumber.generateTicketNumber((bound*2));
        }
        return number;
    }
}