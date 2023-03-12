package com.tulane.context;

import com.tulane.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tulane
 * @date 2023/3/12
 */
public class AnnotationApplicationContext {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car =ctx.getBean("car",Car.class);
        System.out.println(car.toString());
    }
}
