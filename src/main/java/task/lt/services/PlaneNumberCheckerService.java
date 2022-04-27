package task.lt.services;

import task.lt.interceptors.LoggedInvocation;

import javax.enterprise.inject.Alternative;
import java.io.Serializable;

@Alternative
@LoggedInvocation
public class PlaneNumberCheckerService implements PlaneNumberChecker, Serializable {
    @Override
    public Boolean checkPlaneNumber(String planeNumber) {
        if (planeNumber.charAt(0) != 'N' || planeNumber.length() != 6) {
            return false;
        }
        return true;
    }
}
