package com.hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

public class ComponentFIlterAppConfigTest {

    @Test
    void filterScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        BeanB beanB = ac.getBean("beanB", BeanB.class);
        Assertions.assertThat(beanB).isNotNull();
    }


    @Configuration
    @ComponentScan(
             includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =  MyIncludeComponent.class),
            excludeFilters  = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =  MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig{

    }
}
