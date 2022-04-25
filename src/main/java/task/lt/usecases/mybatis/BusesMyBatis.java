package task.lt.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import task.lt.mybatis.dao.BusMapper;
import task.lt.mybatis.dao.DriverBusMapper;
import task.lt.mybatis.dao.DriverMapper;
import task.lt.mybatis.model.Bus;
import task.lt.mybatis.model.Driver;
import task.lt.mybatis.model.DriverBus;
import task.lt.mybatis.model.Ticket;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class BusesMyBatis implements Serializable {
    @Inject
    private BusMapper busMapper;

    @Inject
    private DriverMapper driverMapper;

    @Inject
    private DriverBusMapper driverBusMapper;

    @Getter@Setter
    private List<Bus> allBuses;

    @Getter @Setter
    private List<Driver> currentBusDrivers;

    @Getter @Setter
    private List<Ticket> ticketsByTripId;

    public void loadDrivers() {
        this.allBuses = busMapper.selectAllWithTrips();
    }

    @PostConstruct
    public void init() {
        this.loadDrivers();
    }

    @Transactional
    public String deleteBus(Integer busId) {
        busMapper.deleteByPrimaryKey(busId);
        return "/mybatis/buses?faces-redirect=true";
    }

    @Transactional
    public String assignDriverToBus(Integer busId, Integer driverId) {
        Driver driver = this.driverMapper.selectByPrimaryKey(driverId);
        if (driver == null) {
            return "false";
        }
        DriverBus driverBus = new DriverBus();
        driverBus.setDriverId(driverId);
        driverBus.setBusId(busId);
        driverBusMapper.insert(driverBus);
        return "/mybatis/buses?faces-redirect=true";
    }

    public void loadDriversById(Integer busId){
        for (Bus bus:allBuses) {
            if (bus.getBusId().equals(busId)){
                this.currentBusDrivers = bus.getDrivers();
            }
        }
    }
}