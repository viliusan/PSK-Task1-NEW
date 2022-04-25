package task.lt.services;

import task.lt.interceptors.LoggedInvocation;

import javax.enterprise.inject.Specializes;
import java.io.Serializable;

@Specializes
@LoggedInvocation
public class AdvancedNumberCheckerCheckerEU extends PlateNumberCheckerCheckerEU implements Serializable {
    @Override
    public Boolean checkPlateNumber(String plateNumber) {
        if (super.checkPlateNumber(plateNumber)){
            //advanced checking
            return true;
        }
        return false;
    }
}