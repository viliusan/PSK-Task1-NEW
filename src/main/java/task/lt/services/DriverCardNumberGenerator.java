package task.lt.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
public class DriverCardNumberGenerator implements Serializable {
    Random random = new Random();

    @Futureable
    public Future<Integer> generateDriverCardNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return new AsyncResult<>(random.nextInt(100));
    }
}