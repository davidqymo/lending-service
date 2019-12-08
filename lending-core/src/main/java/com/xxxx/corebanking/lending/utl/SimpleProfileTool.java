//package com.xxxx.corebanking.lending.utl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
//import org.springframework.util.StopWatch;
//
//public class SimpleProfileTool {
//
//    private static Logger logger = LoggerFactory.getLogger( Thread.currentThread().getName() );
//
//    public Object profile(MethodInvocationProceedingJoinPoint call) throws Throwable {
//        Object returnValue;
//        StopWatch sw = new StopWatch( call.getClass().getName() );
//
//        sw.start( call.toShortString() );
//        try {
//            returnValue = call.proceed();
//        } finally {
//            sw.stop();
//        }
//        return returnValue;
//    }
//}
