package task.lt.services;

import task.lt.interceptors.LoggedInvocation;

import javax.enterprise.inject.Alternative;
import java.io.Serializable;

@Alternative
@LoggedInvocation
public class PlateNumberCheckerCheckerLT implements PlateNumberChecker, Serializable {
    @Override
    public Boolean checkPlateNumber(String plateNumber) {
        //checking
        return true;
    }
}