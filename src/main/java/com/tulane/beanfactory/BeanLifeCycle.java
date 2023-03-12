package com.tulane.beanfactory;

import com.tulane.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Tulane
 * @date 2023/3/12
 */
public class BeanLifeCycle {

    private static void lifeCycleInBeanFactory(){
        Resource res = new ClassPathResource("com/tulane/beanfactory/beans.xml");

        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
        reader.loadBeanDefinitions(res);

        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car1 = (Car)bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        ((ConfigurableBeanFactory) bf).destroySingletons();
    }

    public static void main(String[] args) {
        lifeCycleInBeanFactory();
    }
}