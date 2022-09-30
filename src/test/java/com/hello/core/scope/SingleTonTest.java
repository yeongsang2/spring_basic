package com.hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingleTonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(SingleTonBean.class);
        SingleTonBean singleTonBean1 = ac.getBean(SingleTonBean.class);
        SingleTonBean singleTonBean2 = ac.getBean(SingleTonBean.class);

        System.out.println("singletonBean1 = " + singleTonBean1);
        System.out.println("singletonBean2 = " + singleTonBean2);
        assertThat(singleTonBean1).isSameAs(singleTonBean2);


        ac.close();


    }

    @Scope("singleton")
    static class SingleTonBean {

        @PostConstruct
        public void init(){
            System.out.println("singletonBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("singletonBean.destroy");
        }

    }

}
