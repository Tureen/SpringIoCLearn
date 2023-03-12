package com.tulane.context;

import com.tulane.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tulane
 * @date 2023/3/11
 */
@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("红旗CA73");
        car.setMaxSpeed(300);
        return car;
    }
}
