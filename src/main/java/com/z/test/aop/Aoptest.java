package com.z.test.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zcq
 * @ClassName:
 * @Description: TODO()
 * @date 2016/6/17 20:08
 */
@Aspect
@Component
public class Aoptest {
    @Pointcut("execution(* com.z.test.dao.impl.*.*(..))")
    public void pointcut() {
        // 定义一个pointcut，下面用Annotation标注的通知方法可以公用这个pointcut
    }

    @Before("pointcut()")
    public void before(){
        System.out.println("before");
    }
}
