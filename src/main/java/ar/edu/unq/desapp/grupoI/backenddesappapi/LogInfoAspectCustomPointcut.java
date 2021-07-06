package ar.edu.unq.desapp.grupoi.backenddesappapi;

import ar.edu.unq.desapp.grupoi.backenddesappapi.services.AuthService;
import ar.edu.unq.desapp.grupoi.backenddesappapi.webservices.TitleController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(0)
public class LogInfoAspectCustomPointcut  {

	static Logger logger = LoggerFactory.getLogger(LogInfoAspectCustomPointcut.class);

	@Autowired
	AuthService authService;
	/// CUSTOM  POINTCUT////
	@Pointcut("within(ar.edu.unq.desapp.grupoi.backenddesappapi.webservices..*)")
	public void methodsStarterServicePointcut() {
	}

	@Before("methodsStarterServicePointcut()")
	public void beforeMethods() throws Throwable {
	}

	@Around("@annotation(ar.edu.unq.desapp.grupoi.backenddesappapi.LogExecutionTime)")
	public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		String apiKey = (String) proceedingJoinPoint.getArgs()[0];
		Object[] parameters =proceedingJoinPoint.getArgs();
		String user = authService.getUser(apiKey);
		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();


		// Measure method execution time
		StopWatch stopWatch = new StopWatch("USER : " + user +
				" | CLASS->Method: + " +className + "->" + methodName +
				" | PARAMETERS : " + Arrays.toString(parameters));
		stopWatch.start(methodName);
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();
		// Log method execution time
		if (logger.isInfoEnabled()) {
			logger.info(stopWatch.prettyPrint());
		}
		return result;
	}

	@After("methodsStarterServicePointcut()")
	public void afterMethods() throws Throwable {
	}
}
