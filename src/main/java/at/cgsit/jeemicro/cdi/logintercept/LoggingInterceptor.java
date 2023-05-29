package at.cgsit.jeemicro.cdi.logintercept;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.jboss.logging.Logger;



@Logged
@Priority(2020)
@Interceptor
public class LoggingInterceptor {

    @Inject
    Logger logger;

    @AroundInvoke
    Object logInvocation(InvocationContext context) throws Exception {

        logger.info("object before");
        Object ret = context.proceed();
        logger.info("object after");
        return ret;
    }
}

