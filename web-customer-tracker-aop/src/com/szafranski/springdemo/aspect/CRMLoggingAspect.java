package com.szafranski.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.szafranski.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.szafranski.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.szafranski.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
	
		//display method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>>> in @Before calling method is: " + method);
		
		//get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop through and display args
		for(Object tempArg : args) {
			myLogger.info("====>>> argument: " + tempArg);
		}
	}
	
	
	//add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
	
		//display method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>>> in @AfterReturning calling method is: " + method);
		
		//display data returned
		myLogger.info("====>>> argument: " + theResult);
		
		}
	}
	
