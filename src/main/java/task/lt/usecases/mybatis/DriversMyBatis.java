package task.lt.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import task.lt.mybatis.dao.DriverBusMapper;
import task.lt.mybatis.dao.DriverMapper;
import task.lt.mybatis.model.Driver;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class DriversMyBatis {
    @Inject
    private DriverMapper driverMapper;

    @Inject
    private DriverBusMapper driverBusMapper;

    @Getter
    @Setter
    private List<Driver> allDrivers;

    @Getter
    @Setter
    private Driver driverToCreate = new Driver();

    public void loadDrivers() {
        this.allDrivers = driverMapper.selectAllWithTrips();
    }

    @PostConstruct
    public void init() {
        this.loadDrivers();
    }

    @Transactional
    public String deleteDriver(Integer driverId) {
        driverBusMapper.deleteByDriverId(driverId);
        driverMapper.deleteByPrimaryKey(driverId);
        return "/mybatis/drivers?faces-redirect=true";
    }

    @Transactional
    public String createDriver() {
        driverMapper.insert(driverToCreate);
        return "/mybatis/drivers?faces-redirect=true";
    }
}