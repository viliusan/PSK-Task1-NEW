package task.lt.interceptors;

import task.lt.usecases.MethodLogs;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedInvocation
@Priority(Interceptor.Priority.APPLICATION)
public class MethodLogger implements Serializable {
    @Inject
    MethodLogs methodLogs;

    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        methodLogs.addMethodLog(context.getMethod().getName(), context.getTarget().getClass().getName());
        return context.proceed();
    }
}