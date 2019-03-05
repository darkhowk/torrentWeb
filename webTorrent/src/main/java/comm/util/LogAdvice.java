package comm.util;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect // AOP bean
public class LogAdvice {

 private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

 @Around(
		 "execution(* admin..controller.*Controller.*(..))"
         + " or execution(* admin..service..*Impl.*(..))"
         + " or execution(* admin..dao.*Dao.*(..))"
         + " or execution(* main..controller..*Controller.*(..))"
         + " or execution(* main..service..*Impl.*(..))"
         + " or execution(* main..dao.*Dao.*(..))"
         )
 public Object logPrinnt(ProceedingJoinPoint joinPoint) throws Throwable{
     long start = System.currentTimeMillis();
     Object result = joinPoint.proceed();
     String type = joinPoint.getSignature().getDeclaringTypeName();
     String name = "";
     if (type.indexOf("Controller") > -1) {
    	 logger.info("");
         name = "Controller:";
     } else if (type.indexOf("Service") > -1) {
    	 logger.info("");
         name = "ServiceImpl:";
     } else if (type.indexOf("Dao") > -1) {
         name = "Dao:";
         logger.info("=====================================================================================================================");
     }
    
     logger.info("1. Method :: >> "+name+type+"."+joinPoint.getSignature().getName()+"()");
     logger.info("2. Params :: >> "+Arrays.toString(joinPoint.getArgs()));
     long end = System.currentTimeMillis();
     long time = end-start;
     logger.info("3. time:: >> "+time);
     if (type.indexOf("Controller") > -1) {
    	   logger.info("====================================================================================================================="); 
     }
     return result;
 }

}
