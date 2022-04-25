package task.lt.usecases;

import task.lt.entities.MethodLog;
import task.lt.persistence.MethodLogDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

@Model
public class MethodLogs {
    @Inject
    private MethodLogDAO methodLogDAO;

    @Transactional
    public void addMethodLog(String methodName, String className) {
        MethodLog log = new MethodLog();
        log.setMethodName(methodName);
        log.setClassName(className);
        log.setCreationDate(new Date());
        methodLogDAO.persist(log);
    }
}