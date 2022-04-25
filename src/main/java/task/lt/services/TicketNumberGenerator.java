package task.lt.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class TicketNumberGenerator implements Serializable, TicketNumber {
    private Random random = new Random();

    @Override
    public Integer generateTicketNumber(Integer bound) {
        return random.nextInt(bound);
    }
}