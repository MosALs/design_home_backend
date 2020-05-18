package com.home.acpect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterCallingMethodAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //public List<Governorates_AreasDTO> getBYName()
    @After(value = "execution(* getBYName()) && execution(* findBySearchCriteria(*))")
    public void afterGetAreasWithinGovernorates(JoinPoint joinPoint) {
//        logger.info("KMG == after methode in aspect" + joinPoint);
        System.out.println("KMG == after methode in aspect" + joinPoint);
    }
    //public DetailedSearchDTO findBySearchCriteria
    @After(value = "execution(* findBySearchCriteria(*)) || execution(* getBYName())")
    public void afterFindBySearchCriteria(JoinPoint joinPoint) {
        logger.info("KMG == after methode in aspect" + joinPoint);
        System.out.println("KMG == after methode in aspect" + joinPoint);
    }
}
